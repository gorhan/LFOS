import os
import glob
from sys import argv, stderr
from subprocess import call

ENV_ALIAS = "LFOS_DIR"
COPY_DIRECTORY = "/Users/orhanguner/Dropbox/GPCE17/figures"


def get_fm_directories():
    base_dir = os.getenv(ENV_ALIAS)
    if not base_dir:
        print >>stderr, 'Wrong environment name for the base directory=', ENV_ALIAS
        return []

    fm_directory = os.path.join(base_dir, 'FM_LFOS')
    directories = [os.path.join(fm_directory, file) for file in os.listdir(fm_directory) if
                   os.path.isdir(os.path.join(fm_directory, file)) and file.isupper()]

    return directories


def get_files_by_ext(dir, ext='cfr'):
    return [os.path.join(dir, file) for file in os.listdir(dir) if file.endswith(".%s" % ext)]


def _execute(dir, ext_in, execution_parameters, ext_out=None, ext_dir=None):
    _files = get_files_by_ext(dir, ext_in)
    current_env = dict(os.environ)

    for _file in _files:
        try:
            index_out = execution_parameters.index('-o')
        except ValueError:
            index_out = len(execution_parameters)
        execution_parameters.insert(index_out, _file)
        if ext_out:
            ext_file = os.path.join(ext_dir if ext_dir else dir, (_file[:-(len(ext_in) + 1)].split('/')[-1] + '.%s' % ext_out))
            print ext_file, ext_dir, (_file[:-(len(ext_in) + 1)] + '.%s' % ext_out), 'SSSS'
            execution_parameters.insert(index_out+2, ext_file)
        print 'Execution Parameters=', ' '.join(execution_parameters)
        call(execution_parameters, env=current_env)
        print '%s has been executed...' % execution_parameters[0].upper(), _file

    return True


def convert_dot2pdf(dir):
    _execute(dir, 'dot', ['dot', '-Tpdf', '-o'], 'pdf')


def copy_figures(src_dir, dest_dir):
    _execute(src_dir, 'pdf', ['cp'], 'pdf', dest_dir)


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
    copy_figures(file, COPY_DIRECTORY)