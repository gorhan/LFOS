from VisitorInterface.VisitorInterface import *


class Reporter(VisitorInterface):
    HEADER = '''
\documentclass[]{scrartcl}

\usepackage{listings}
\usepackage{color}

% Title Page
\\title{Language Framework for Optimal Schedulers (LFOS)}
\subtitle{Guideline for Users}
\\author{G\\"{u}ner Orhan}

\definecolor{mygreen}{rgb}{0,0.6,0}
\definecolor{backgroundcolor}{rgb}{1,1,0.95}
\definecolor{mygray}{rgb}{0.5,0.5,0.5}
\definecolor{mymauve}{rgb}{0.58,0,0.82}

\lstset{ %
	backgroundcolor=\color{backgroundcolor},	% choose the background color
	basicstyle=\\footnotesize,        			% size of fonts used for the code
	breaklines=true,                 			% automatic line breaking only at whitespace
	captionpos=b,                    			% sets the caption-position to bottom
	commentstyle=\color{mygreen},    			% comment style
	escapeinside={\%*}{*)},          			% if you want to add LaTeX within your code
	keywordstyle=\color{blue},       			% keyword style
	stringstyle=\color{mymauve},    			% string literal style
	showspaces=false,                			% show spaces everywhere adding particular underscores; it overrides 'showstringspaces'
	showstringspaces=false,          			% underline spaces within strings only
	showtabs=false,                  			% show tabs within strings adding particular underscores
	numbers=left,
}

\\begin{document}
\maketitle
    '''
    FOOTER = '''
\end{document}
'''

    def __init__(self, filename):
        VisitorInterface.__init__(self)
        self.__file = filename
        self.__ready = False

    def open(self):
        try:
            self.__file_fp = open(self.__file, 'w')
            self.write(Reporter.HEADER)
        except IOError:
            LOG(msg='Impossible to open file:%s' % self.__file, log=Logs.ERROR)
            return False

        self.__ready = True
        return True

    def close(self):
        self.write(Reporter.FOOTER)
        self.__file_fp.close()
        return True

    def write(self, text):
        self.__file_fp.write(text)
        self.__file_fp.flush()

    def set_filename(self, filename):
        self.__file = filename
        self.open()

    def get_filename(self):
        return self.__file

    def accept(self, visitor):
        if not self.__ready:
            LOG(msg='Unable to proceed.', log=Logs.ERROR)
            return False

        visitor.visit(self)
        return True

    @staticmethod
    def function_implementation(code, label, caption):
        return ('''
\\begin{lstlisting}[language=Python, frame=single, label={lst:%s}, caption={%s}]
%s
\\end{lstlisting}
        ''' % (label, caption, code.strip()))

    def _remove_attributes(self, *args):
        for arg in args:
            try:
                self.__dict__.pop(arg)
            except KeyError:
                pass

    def dynamic_cb(self, *args, **kwargs):
        pass

    def scheduling_window_cb(self, *args, **kwargs):
        pass

    def deadline_cb(self, *args, **kwargs):
        pass

    def scheduling_strategy_cb(self, *args, **kwargs):
        pass

    def power_consumption_cb(self, *args, **kwargs):
        self.write('''
\\subsubsection{Setting Power Consumption}
There are three possible types of power consumption:
\\begin{itemize}
    \\item \\textsf{PowerTypeList.FIXED_STATE_POWER_CONSUMPTION}
    \\item \\textsf{PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION}
    \\item \\textsf{PowerTypeList.CONTINUOUS_STATE_POWER_CONSUMPTION}
\\end{itemize}
Each of these types have their corresponding classes inheriting \\textsf{Resource} class. Therefore, we have utilized factory method design pattern.
        ''')
        if not args[2]:
            self.write('''
Since you have selected non-scalable power consumption for the resource. The following instantiation can be applied:
%s

If you want to get the instance of power, then you can use the following function:
%s
            ''' % (self.function_implementation('''
power_type = PowerTypeList.FIXED_STATE_POWER_CONSUMPTION
{0}_pc = PowerFactory.create_instance(power_type, scale, consumption)
# Arguments: power_type --> PowerTypeList::Enum
#            scale --> float // a scale value within [0.0, 1.0]
#            consumption --> float // a power consumption of one-capacity per unit time
# it returns the instance belonging

{0}.set_power_consumption({0}_pc)
            '''.format(self.resource_cb_flag[0]), '%screatingPowerConsumption' % self.resource_cb_flag[0], 'Initializing power consumption module and setting it to the resource.'),
                   self.function_implementation('''
{0}.get_power_consumption()
            '''.format(self.resource_cb_flag[0]), '%sgettingPowerConsumption' % self.resource_cb_flag[0], 'Getting power consumption module')))

            self.write('''

            ''')

    def terminal_cb(self, *args, **kwargs):
        pass

    def policy_cb(self, *args, **kwargs):
        pass

    def RM_cb(self, *args, **kwargs):
        pass

    def ranking_cb(self, *args, **kwargs):
        pass

    def string_cb(self, *args, **kwargs):
        pass

    def execution_time_cb(self, *args, **kwargs):
        pass

    def scalable_cb(self, *args, **kwargs):
        pass

    def PASSIVE_cb(self, *args, **kwargs):
        self.write(('''
For \\emph{abstraction}, \\textsc{passive} is selected. Therefore, you can create the type object using the following code segment:
%s
        ''' % self.function_implementation('''
{0}_t = Type(ResourceTypeList.PASSIVE, '{0}_t')
        '''.format(self.resource_cb_flag[0]), '%spassiveType' % self.resource_cb_flag[0], 'Passive resource type object instantiation')) + ('''
According to the specification, a programmer can create the resource giving type object and a name of the resource as arguments to the class method of the
ResourceFactory class shown in Listing \\ref{lst:%spassiveInstantiation}. For passive resources, an object belonging to \\textsf{TerminalResource} class is instantiated
using factory method pattern to handle the optional feature under \\emph{Abstraction} sub-feature.

%s
''' % (self.resource_cb_flag[0], self.function_implementation('''
{0} = ResourceFactory.create_instance({0}_t, '{0}')
        '''.format(self.resource_cb_flag[0]), '%spassiveInstantiation' % self.resource_cb_flag[0], 'Passive resource instantiation using ResourceFactory class'))))

    def scheduler_cb(self, *args, **kwargs):
        self.scheduler_cb_flag = [args[0], '\\_'.join(args[0].split('_'))]
        info = '''
\section{Required Modules}
In order to use LFOS frameowrk API, a programmer should import the required module:
%s

\section{Scheduler}
Based on the selected instance, the scheduler instance, namely ``\\textsf{%s}'', can be generated by following the following procedures one-by-one:
        ''' % (self.function_implementation('''
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *
        ''', 'moduleImport', 'Importing required modules'), self.scheduler_cb_flag[1])
        self.write(info)

    def timing_cb(self, *args, **kwargs):
        pass

    def task_objective_purpose_cb(self, *args, **kwargs):
        pass

    def resource_cb(self, *args, **kwargs):
        self.write('''
\subsection{Resource Initialization for ``\\textsf{%s}''}
        ''' % args[0])
        if not hasattr(self, 'resource_cb_flag'):
            self.write('''
Since some of the task specifications are based on the resources, in the framework, a programmer is expected to define the resources, initially.
As explained in the article, some of the specifications are inevitable for a resource. Therefore, it should be defined for each resource.
Based on the feature model, the following attributes are inevitable for a resource:
\\begin{itemize}
    \\item \\textsc{Capacity} ($\mathcal{C}$): The capacity of the resource are required to determine the maximum amount of capacity which can be utilized
    per time unit.
    \\item \\textsc{Type} ($\\Re$): This attribute categorize the resources based on \\emph{Abstractions} and \\emph{Identifier}.
    \\item \\textsc{Mode} ($\\mathcal{X}$): The mode of a resource may be either \\emph{Shared} or \\emph{Exclusive}.
    \\item \\textsc{Power Consumption} ($\\mathcal{V}$): A resource consumes power based on this attribute. The resource is either \\emph{Scalable} or not.
    \\item \\textsc{Objective} ($\\mathcal{O}_\\alpha$): This attribute is related with the resource-related objectives.
\\end{itemize}

The only required specification for the instantiation is \\emph{Type} of the resource. The default values for all specification belonging to a resource are
shown in Table \\ref{tab:resource_vars_default}.

\\begin{table}[!htb]
	\\centering
	\\begin{tabular}{r || c | c |}
		\\hline
		\\textbf{Feature Name} & \\textbf{Variable Type} & \\textbf{Initial Value} \\\\ \\hline \\hline
		Capacity ($\mathcal{C})$ & float & $0.0$ \\\\ \\hline
		Type ($\Re$) & LFOS.Resource.Type.ResourceTypeList::Enum & \\textsf{proc\_t} \\\\ \\hline
		Mode ($\mathcal{X}$) & LFOS.Resource.Mode.ModeTypeList::Enum & \\textsc{cb\_exclusive} \\\\ \\hline
		Power Consumption ($\mathcal{V}$) & LFOS.Resource.Power & \\textsf{None} \\\\ \\hline
		Objective ($\mathcal{O}_{\\alpha}$) & LFOS.Objective & \\textsf{None} \\\\ \\hline
	\end{tabular}
	\caption{Default instance variables of the \emph{Resource} module and their default values.}
	\label{tab:resource_vars_default}
\end{table}

            ''')
        self.resource_cb_flag = [args[0], '\\_'.join(args[0].split('_'))]

    def name_cb(self, *args, **kwargs):
        pass

    def solver_cb(self, *args, **kwargs):
        pass

    def scheduling_characteristic_type_cb(self, *args, **kwargs):
        pass

    def n_tokens_cb(self, *args, **kwargs):
        pass

    def discrete_cb(self, *args, **kwargs):
        pass

    def mode_cb(self, *args, **kwargs):
        self._remove_attributes('semantic_based_cb_flag', 'capacity_based_cb_flag')
        self.write('''
\\subsubsection{Setting mode}
There are three possible types for this ttribute. These are:
\\begin{itemize}
    \\item \\textsf{ModeTypeList.SHARED}
    \\item \\textsf{ModeTypeList.CB\_EXCLUSIVE}
    \\item \\textsf{ModeTypeList.SB\_EXCLUSIVE}
    \\item \\textsf{ModeTypeList.CB\_AND\_SB\_EXCLUSIVE}
\\end{itemize}
The functionality of these modes are discussed in the article.

As shown in Table \\ref{tab:resource_vars_default}, the mode is initially set to \\textsf{ModeTypeList.CB\_EXCLUSIVE}. A programmer can change the mode of a resource by using the following code segment:
%s

In order to check the mode of the resource, you can use the functions depicted in Listing \\ref{lst:%sgetMode}.
%s
        ''' % (self.function_implementation('''
{}.set_mode(mode)
# mode --> ResourceTypeList::Enum
        '''.format(self.resource_cb_flag[0]), '%ssetMode' % self.resource_cb_flag[0], 'Setting the mode of a resource after creating a resource.'),
               self.resource_cb_flag[0], self.function_implementation('''
{0}.is_mode(mode) # mode --> ResourceTypeList::Enum
# returns True if the argument matches with the mode of the resource.

{0}.is_exclusive()
# returns True if the mode of the resource is any one of the exclusive mode.
               '''.format(self.resource_cb_flag[0]), '%sgetMode' % self.resource_cb_flag[0], 'The functions for resource mode check.')))

    def shared_cb(self, *args, **kwargs):
        self.write('''
According to your specification, you have selected the \\textsf{SHARED} mode for your resource ``%s''. Therefore, you should manually set it after resource creation using the following code segment:
%s
        ''' % (self.resource_cb_flag[0], self.function_implementation('''
{}.set_mode(ModeTypeList.SHARED)
        '''.format(self.resource_cb_flag[0]), '%ssetShared' % self.resource_cb_flag[0],
                                                                      'The resource is set to SHARED mode.')))

    def exclusive_cb(self, *args, **kwargs):
        pass

    def capacity_based_cb(self, *args, **kwargs):
        self.capacity_based_cb_flag = True

        if 'semantic_based_cb_flag' in self.__dict__:
            self.write('''
In addition to the SB\_EXCLUSIVE mode, you have selected the \\textsf{CB\_EXCLUSIVE} mode for your resource ``%s''. Therefore, you should manually set it after resource creation using the following code segment:
%s
        ''' % (self.resource_cb_flag[0], self.function_implementation('''
{}.set_mode(ModeTypeList.CB_AND_SB_EXCLUSIVE)
        '''.format(self.resource_cb_flag[0]), '%ssetCBSBExclusiveResource' % self.resource_cb_flag[0], 'The resource is set to CB\_AND\_SB\_EXCLUSIVE mode.')))
        else:
            self.write('''
According to your specification, you have selected at least \\textsf{CB\_EXCLUSIVE} mode for your resource ``%s''. Since the resource is set to this mode initially, you do not need to set it again.
        ''' % (self.resource_cb_flag[0]))

    def semantic_based_cb(self, *args, **kwargs):
        self.semantic_based_cb_flag = True

        if 'capacity_based_cb_flag' in self.__dict__:
            self.write('''
In addition to the CB\_EXCLUSIVE mode, you have selected the \\textsf{SB\_EXCLUSIVE} mode for your resource ``%s''. Therefore, you should manually set it after resource creation using the following code segment:
%s

Due to semantic-based exclusive property of the resource, you can define exclusive resources by using the following formula:
%s
        ''' % (self.resource_cb_flag[0], self.function_implementation('''
{}.set_mode(ModeTypeList.CB_AND_SB_EXCLUSIVE)
        '''.format(self.resource_cb_flag[0]), '%ssetCBSBExclusiveResource' % self.resource_cb_flag[0], 'The resource is set to CB\_AND\_SB\_EXCLUSIVE mode.'),
               self.function_implementation('''
{}.add_exclusive_resource(resource)
# returns True if the SB\_EXCLUSIVE mode is selected and the resource argument is not in the list of exclusive resources. Otherwise, it returns False.
               '''.format(self.resource_cb_flag[0]), '%saddSBExclusiveResource' % self.resource_cb_flag[0],
                                            'A function for adding exclusive resources.')))
        else:
            self.write('''
According to your specification, you have selected at least \\textsf{SB\_EXCLUSIVE} mode for your resource ``%s''. Therefore, you should manually set it after resource creation using the following code segment:
%s

Due to semantic-based exclusive property of the resource, you can define exclusive resources by using the following formula:
%s
        ''' % (self.resource_cb_flag[0], self.function_implementation('''
{}.set_mode(ModeTypeList.SB_EXCLUSIVE)
        '''.format(self.resource_cb_flag[0]), '%ssetSBexclusive' % self.resource_cb_flag[0],
                                                                      'The resource is set to SB\_EXCLUSIVE mode.'),
               self.function_implementation('''
{}.add_exclusive_resource(resource)
# returns True if the SB_EXCLUSIVE mode is selected and the resource argument is not in the list of exclusive resources. Otherwise, it returns False.
               '''.format(self.resource_cb_flag[0]), '%saddSBExclusiveResource' % self.resource_cb_flag[0],
                                            'A function for adding exclusive resources.')))

    def output_cb(self, *args, **kwargs):
        pass

    def identifier_cb(self, *args, **kwargs):
        pass

    def soft_cb(self, *args, **kwargs):
        pass

    def grouping_cb(self, *args, **kwargs):
        pass

    def requirement_cb(self, *args, **kwargs):
        pass

    def cooperative_cb(self, *args, **kwargs):
        pass

    def periodicity_cb(self, *args, **kwargs):
        pass

    def sequence_dependent_setup_time_cb(self, *args, **kwargs):
        pass

    def hard_cb(self, *args, **kwargs):
        pass

    def resource_related_user_defined_criteria_cb(self, *args, **kwargs):
        pass

    def migration_cb(self, *args, **kwargs):
        pass

    def sporadic_cb(self, *args, **kwargs):
        pass

    def required_resources_cb(self, *args, **kwargs):
        pass

    def centering_cb(self, *args, **kwargs):
        pass

    def resource_identifier_cb(self, *args, **kwargs):
        pass

    def aperiodic_cb(self, *args, **kwargs):
        pass

    def offline_cb(self, *args, **kwargs):
        pass

    def task_level_cb(self, *args, **kwargs):
        pass

    def makespan_cb(self, *args, **kwargs):
        pass

    def ED_cb(self, *args, **kwargs):
        pass

    def taskset_cb(self, *args, **kwargs):
        pass

    def granularity_cb(self, *args, **kwargs):
        pass

    def ACTIVE_cb(self, *args, **kwargs):
        self.write(('''
For \\emph{abstraction}, \\textsc{active} is selected. Therefore, you can create the type object using the following code segment:
%s
        ''' % self.function_implementation('''
{0}_t = Type(ResourceTypeList.ACTIVE, '{0}_t')
        '''.format(self.resource_cb_flag[0]), 'activeType', 'Active resource type object instantiation')) + ('''
According to the specification, a programmer can create the resource giving type object and a name of the resource as arguments to the class method of the
ResourceFactory class shown in Listing \\ref{lst:%sactiveInstantiation}. For active resources, an object belonging to \\textsf{TerminalResource} class is instantiated
using factory method pattern to handle the optional feature under \\emph{Abstraction} sub-feature.

%s
''' % (self.resource_cb_flag[0], self.function_implementation('''
{0} = ResourceFactory.create_instance({0}_t, '{0}')
        '''.format(self.resource_cb_flag[0]), '%sactiveInstantiation' % self.resource_cb_flag[0],
                                   'Active resource instantiation using ResourceFactory class'))))

    def DSB_cb(self, *args, **kwargs):
        pass

    def properties_cb(self, *args, **kwargs):
        pass

    def scheduling_policy_cb(self, *args, **kwargs):
        pass

    def solver_meta_knowledge_cb(self, *args, **kwargs):
        pass

    def fixed_cb(self, *args, **kwargs):
        pass

    def COMPOSITE_cb(self, *args, **kwargs):
        self.write(('''
For \\emph{abstraction}, \\textsc{composite} is selected. Therefore, you can create the type object using the following code segment:
%s
        ''' % self.function_implementation('''
{0}_t = Type(ResourceTypeList.COMPOSITE, '{0}_t')
        '''.format(self.resource_cb_flag[0]), 'compositeType', 'Composite resource type object instantiation')) + ('''
According to the specification, a programmer can create the resource giving type object and a name of the resource as arguments to the class method of the
ResourceFactory class shown in Listing \\ref{lst:%scompositeInstantiation}. For compoiste resources, an object belonging to \\textsf{CompositeResource} class is instantiated
using factory method pattern to handle the optional feature under \\emph{Abstraction} sub-feature.

%s
''' % (self.resource_cb_flag[0], self.function_implementation('''
{0} = ResourceFactory.create_instance({0}_t, '{0}')
        '''.format(self.resource_cb_flag[0]), '%scompositeInstantiation' % self.resource_cb_flag[0],
                                   'Instantiating a composite resource using ResourceFactory class'))))

    def task_related_objective_cb(self, *args, **kwargs):
        pass

    def dependency_cb(self, *args, **kwargs):
        pass

    def periodic_cb(self, *args, **kwargs):
        pass

    def throughput_cb(self, *args, **kwargs):
        pass

    def DSLB_cb(self, *args, **kwargs):
        pass

    def objective_purpose_cb(self, *args, **kwargs):
        pass

    def resource_type_cb(self, *args, **kwargs):
        pass

    def time_resolution_cb(self, *args, **kwargs):
        pass

    def SCIP_SoPlex_cb(self, *args, **kwargs):
        pass

    def token_type_cb(self, *args, **kwargs):
        pass

    def scheduling_characteristic_cb(self, *args, **kwargs):
        pass

    def utilization_cb(self, *args, **kwargs):
        pass

    def tardiness_cb(self, *args, **kwargs):
        pass

    def system_cb(self, *args, **kwargs):
        pass

    def strategy_cb(self, *args, **kwargs):
        pass

    def priority_cb(self, *args, **kwargs):
        pass

    def priority_assignment_cb(self, *args, **kwargs):
        pass

    def criteria_cb(self, *args, **kwargs):
        pass

    def firm_cb(self, *args, **kwargs):
        pass

    def SAS_OR_R_cb(self, *args, **kwargs):
        pass

    def task_objective_cb(self, *args, **kwargs):
        pass

    def composite_cb(self, *args, **kwargs):
        pass

    def continuous_cb(self, *args, **kwargs):
        pass

    def resource_objective_cb(self, *args, **kwargs):
        pass

    def FIFO_cb(self, *args, **kwargs):
        pass

    def input_cb(self, *args, **kwargs):
        pass

    def SJF_cb(self, *args, **kwargs):
        pass

    def abstract_objective_criteria_cb(self, *args, **kwargs):
        pass

    def default_cb(self, *args, **kwargs):
        pass

    def preemptive_cb(self, *args, **kwargs):
        pass

    def resource_objective_purpose_cb(self, *args, **kwargs):
        pass

    def ERT_cb(self, *args, **kwargs):
        pass

    def mini_cb(self, *args, **kwargs):
        pass

    def lateness_cb(self, *args, **kwargs):
        pass

    def task_related_user_defined_criteria_cb(self, *args, **kwargs):
        pass

    def earliness_cb(self, *args, **kwargs):
        pass

    def resource_requirement_cb(self, *args, **kwargs):
        pass

    def IBM_ILOG_CPLEX_Optimizer_cb(self, *args, **kwargs):
        pass

    def preemptable_cb(self, *args, **kwargs):
        pass

    def resource_related_objective_cb(self, *args, **kwargs):
        pass

    def user_defined_cb(self, *args, **kwargs):
        pass

    def maxi_cb(self, *args, **kwargs):
        pass

    def Knapsack_cb(self, *args, **kwargs):
        pass

    def online_cb(self, *args, **kwargs):
        pass

    def objective_cb(self, *args, **kwargs):
        pass

    def release_time_cb(self, *args, **kwargs):
        pass

    def resource_related_objective_criteria_cb(self, *args, **kwargs):
        pass

    def eligible_resources_cb(self, *args, **kwargs):
        pass

    def abstraction_cb(self, *args, **kwargs):
        pass

    def purpose_cb(self, *args, **kwargs):
        pass

    def capacity_cb(self, *args, **kwargs):
        pass

    def task_cb(self, *args, **kwargs):
        pass

    def time_related_objective_criteria_cb(self, *args, **kwargs):
        pass

    def job_level_cb(self, *args, **kwargs):
        pass

    def global_objective_cb(self, *args, **kwargs):
        pass