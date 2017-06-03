import os
import glob
from sys import argv, stderr
from subprocess import Popen, call

ENV_ALIAS = "LFOS_DIR"

def get_fm_directories():
    base_dir = os.getenv(ENV_ALIAS)
    if not base_dir:
        print >>stderr, 'Wrong environment name for the base directory=', ENV_ALIAS
        return []

    fm_directory = os.path.join(base_dir, 'FM_LFOS')
    # print base_dir, fm_directory
    directories = [os.path.join(fm_directory, file) for file in os.listdir(fm_directory) if
                   os.path.isdir(os.path.join(fm_directory, file)) and file.isupper()]
    # print 'Directories= %s' % '\n'.join(directories)

    return directories


def get_files_by_ext(dir, ext='cfr'):
    return [os.path.join(dir, file) for file in os.listdir(dir) if file.endswith(".%s" % ext)]

def _execute(dir, ext, execution_parameters, out=False):
    _files = get_files_by_ext(dir, ext)
    current_env = dict(os.environ)

    for _file in _files:
        call(execution_parameters + ([_file[:-(len(ext) + 1)]+'.%s'%out] if out else []) + [_file], env=current_env)
        print '%s has been executed...' % execution_parameters[0].upper(), _file

    return True

def convert_dot2pdf(dir):
    _execute(dir, 'dot', ['dot', '-Tpdf', '-o'], 'pdf')

def compile_clafers(dir):
    clafer_files = get_files_by_ext(dir, 'cfr')
    current_env = dict(os.environ)

    for clafer_file in clafer_files:
        call(['clafer', clafer_file], env=current_env)
        print 'Clafer file has been compiled...', clafer_file

        alloy_solver = os.path.join(os.getenv(ENV_ALIAS), 'tools')
        alloy_solver = glob.glob(alloy_solver + '/alloy*.jar')[0]
        if not alloy_solver:
            print >>stderr, 'Unable to find the place of Alloy solver..'
            return False

        call(['java', '-jar', alloy_solver, clafer_file[:-4]+'.als'], env=current_env)
        print 'Alloy file has been generated...', clafer_file[:-4]+'.als'

    return True

if __name__ == '__main__':
    directories = get_fm_directories()
    file = '/Users/orhanguner/workspace/LFOS/FM_LFOS/RMS'
    # compile_clafers(file)
    convert_dot2pdf(file)