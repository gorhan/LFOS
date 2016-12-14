import os
import sys
sys.path.insert(0, os.getenv('LFOS_DIR'))

from LFOS.Log import LOG, Logs

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
    IG_args = ['--file', '--prettify']

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

def construct_structure(instance_data):
    print 'TODO'

def main():
    from optparse import OptionParser

    usage = "usage: python %prog [options] arg"
    parser = OptionParser(usage)

    parser.add_option('-f', '--file', dest='filename', default='%s/FM_LFOS/example1.cfr' % os.getenv('LFOS_DIR'), help='The .cfr file containing feature model and configuration.')
    parser.add_option('-t', '--tool', dest='IGtool', default='%s/tools/chocosolver.jar' % os.getenv('LFOS_DIR') , help='The instance generator tool.')
    parser.add_option('--fmodel', dest='fmodelfile', default='%s/FM_LFOS/feature_model.cfr' % os.getenv('LFOS_DIR'), help='The .cfr file containing the feature model only.')
    parser.add_option('-?', action='help', help='Prints the options')

    options, args = parser.parse_args()
    instance_data = exec_IG_tool(options.IGtool, options.filename)
    feature_model = parse_feature_model(options.fmodelfile)

    print feature_model

if __name__ == '__main__':
    main()