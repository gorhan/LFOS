import os
import sys
from sys import stderr
sys.path.insert(0, os.getenv('LFOS_DIR'))

from LFOS.Log import LOG, Logs
from Feature.Feature import Feature
from Reporter import Reporter

def parse_raw_data_2_instances(raw_data):
    instance_data = []
    instance_header = '=== Instance %d Begin ==='

    current_instance_id = 1
    for id, line in enumerate(raw_data):
        if line == instance_header % current_instance_id:
            instance_begin_id = id + 1
        elif line == instance_header % (current_instance_id + 1):
            instance_data.append(raw_data[instance_begin_id:id - 2])
            current_instance_id += 1
            instance_begin_id = id + 1
    instance_data.append(raw_data[instance_begin_id:-2])  # get the last instance

    # from random import randint
    # num_instances = len(instance_data)
    # instance_id = randint(0, num_instances)
    # LOG(msg='Number of instances=%d, Printing instance %d:' % (num_instances, instance_id + 1))
    # print '%r' % instance_data[instance_id]

    return instance_data

def parse_IG_tool_output(raw_data):
    import re

    num_instances = int(re.findall(r'\b\d+\b', raw_data[-1])[0])
    LOG(msg='Number of instances=%d' % num_instances)

    return parse_raw_data_2_instances(raw_data)

def exec_IG_tool(igtool, filename):
    import subprocess
    java_app = 'java'
    java_args = '-jar'
    IG_args = ['--file']

    proc = subprocess.Popen([java_app, java_args, igtool, IG_args[0], filename] + IG_args[1:], stdout=subprocess.PIPE)
    raw_data = [line.strip('\n') for line in proc.stdout.readlines() if line != '\n'][2:] # cut dummy first two lines
    return parse_IG_tool_output(raw_data)

def parse_feature_model(fmodelfile):
    fp = open(fmodelfile, 'r')

    ignored_keywords = ['abstract', 'or', 'xor', ':', '->', '?', '!', '&', '|', '+', '*']

    feature_model_set = set()
    for line in fp.readlines():
        if line.find('[') != -1 or line == '\n':
            continue

        line = line.strip().split(' ')
        for keyword in line:
            if keyword == '' or keyword in ignored_keywords:
                continue

            if keyword[0] == '`':
                keyword = keyword[1:]

            feature_model_set.add(keyword)
    fp.close()

    return list(feature_model_set)

def remove_blanks(src_str):
    return ''.join([char for char in src_str if char != ' ' and char != '\t'])

def search_stack(stck, feature_name, instance_name, roots=False):
    found = []
    for elem in stck:
        assert isinstance(elem, Feature)
        if roots:
            if elem.name == feature_name and elem.instance == instance_name:
                return elem
        else:
            elem.search_feature(feature_name, instance_name, found)
            if found:
                return found[0]

    return None

def construct_structure(instance, features):
    import re
    stack = []
    indent = '  '

    # for item in instance:
    #     print >>stderr, item

    curr_instance = None
    for data in instance:
        num_indent = data.count(indent)
        data = remove_blanks(data)
        feature_name = instance_name = None
        pattern = re.compile(r'\w+?_(\w+)')
        if data.find('->') != -1:
            ref_ins = data.split('->')[-1].split('=')
            feature_name = pattern.search(ref_ins[0]).group(1)
            instance_name = pattern.search(ref_ins[-1]).group(1)
        elif data.find(':') != -1:
            ref_ins = data.split(':')
            feature_name = pattern.search(ref_ins[-1]).group(1)
            instance_name = pattern.search(ref_ins[0]).group(1)
        else:
            feature_name = pattern.search(data).group(1)

        if num_indent != 0:
            parent_feature = curr_instance if curr_instance else stack[-1]
            feature_ptr = parent_feature
            num_indent -= 1
            while num_indent > 0:
                feature_ptr = feature_ptr[-1]
                num_indent -= 1

            child_feature = Feature(feature_name, instance_name)
            if instance_name:
                found = search_stack(stack, feature_name, instance_name, True)
                if found:
                    child_feature = found

            feature_ptr.add(child_feature)
        else:
            found = search_stack(stack, feature_name, instance_name)
            if found:
                curr_instance = found
            else:
                curr_instance = None
                feature = Feature(feature_name, instance_name)
                stack.append(feature)

        # raw_input('################')
        # for item in stack:
        #     item.pretty_print()
        #     print '#' * 50

    return stack[-1]

def main():
    from optparse import OptionParser

    usage = "usage: python %prog [options] arg"
    parser = OptionParser(usage)

    parser.add_option('-f', '--file', dest='filename', default='%s/FM_LFOS/example1.cfr' % os.getenv('LFOS_DIR'), help='The Clafer file containing feature model and configuration.')
    parser.add_option('-t', '--tool', dest='IGtool', default='%s/tools/chocosolver.jar' % os.getenv('LFOS_DIR') , help='The Instance Generator tool.')
    parser.add_option('--fmodel', dest='fmodelfile', default='%s/FM_LFOS/feature_model.cfr' % os.getenv('LFOS_DIR'), help='The Clafer file containing only the feature model.')
    parser.add_option('-o', '--output', dest='output', default='FMTranslater.tex', help='Output file name to create a Latex file.')
    parser.add_option('-?', action='help', help='Shows this help message and exits')

    options, args = parser.parse_args()
    instance_data = exec_IG_tool(options.IGtool, options.filename)
    features = parse_feature_model(options.fmodelfile)
    # print '\n'.join(instance_data[0])
    scheduler_instance = construct_structure(instance_data[0], features)
    assert isinstance(scheduler_instance, Feature)
    scheduler_instance.pretty_print()

    report = Reporter(options.output)
    report.open()
    for instance in scheduler_instance.traverse():
        # print instance.name
        report.accept(instance)
    report.close()

if __name__ == '__main__':
    main()