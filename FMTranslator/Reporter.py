from VisitorInterface.VisitorInterface import VisitorInterface


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
}

\\begin{document}
\maketitle
    '''
    FOOTER = '''
\end{document}
'''

    def __init__(self, filename):
        VisitorInterface.__init__(self)
        self.__file = open(filename, 'w')

    def operate(self):
        self.__file.write(Reporter.HEADER)
        return True

    def terminate(self):
        self.__file.write(Reporter.FOOTER)
        self.__file.close()
        return True

    def write(self, text):
        self.__file.write(text)
        self.__file.flush()

    def accept(self, visitor):
        visitor.visit(self)

    def exclusive_cb(self):
        pass

    def dynamic_cb(self):
        pass

    def scheduling_window_cb(self):
        pass

    def deadline_cb(self):
        pass

    def semantic_based_cb(self):
        pass

    def scheduling_strategy_cb(self):
        pass

    def power_consumption_cb(self):
        pass

    def terminal_cb(self):
        pass

    def policy_cb(self):
        pass

    def RM_cb(self):
        pass

    def ranking_cb(self):
        pass

    def string_cb(self):
        pass

    def execution_time_cb(self):
        pass

    def scalable_cb(self):
        pass

    def PASSIVE_cb(self):
        pass

    def scheduler_cb(self):
        print  'Entered scheduler_cb'
        info = '''
\section{Scheduler class}
Hebele gubele
        '''
        self.write(info)

    def timing_cb(self):
        pass

    def task_objective_purpose_cb(self):
        pass

    def resource_cb(self):
        pass

    def name_cb(self):
        pass

    def solver_cb(self):
        pass

    def scheduling_characteristic_type_cb(self):
        pass

    def n_tokens_cb(self):
        pass

    def discrete_cb(self):
        pass

    def mode_cb(self):
        pass

    def capacity_based_cb(self):
        pass

    def output_cb(self):
        pass

    def identifier_cb(self):
        pass

    def soft_cb(self):
        pass

    def grouping_cb(self):
        pass

    def requirement_cb(self):
        pass

    def cooperative_cb(self):
        pass

    def periodicity_cb(self):
        pass

    def sequence_dependent_setup_time_cb(self):
        pass

    def hard_cb(self):
        pass

    def resource_related_user_defined_criteria_cb(self):
        pass

    def migration_cb(self):
        pass

    def sporadic_cb(self):
        pass

    def required_resources_cb(self):
        pass

    def centering_cb(self):
        pass

    def resource_identifier_cb(self):
        pass

    def aperiodic_cb(self):
        pass

    def shared_cb(self):
        pass

    def offline_cb(self):
        pass

    def task_level_cb(self):
        pass

    def makespan_cb(self):
        pass

    def ED_cb(self):
        pass

    def taskset_cb(self):
        pass

    def granularity_cb(self):
        pass

    def ACTIVE_cb(self):
        pass

    def DSB_cb(self):
        pass

    def properties_cb(self):
        pass

    def scheduling_policy_cb(self):
        pass

    def solver_meta_knowledge_cb(self):
        pass

    def fixed_cb(self):
        pass

    def COMPOSITE_cb(self):
        pass

    def task_related_objective_cb(self):
        pass

    def dependency_cb(self):
        pass

    def periodic_cb(self):
        pass

    def throughput_cb(self):
        pass

    def DSLB_cb(self):
        pass

    def objective_purpose_cb(self):
        pass

    def resource_type_cb(self):
        pass

    def time_resolution_cb(self):
        pass

    def SCIP_SoPlex_cb(self):
        pass

    def token_type_cb(self):
        pass

    def scheduling_characteristic_cb(self):
        pass

    def utilization_cb(self):
        pass

    def tardiness_cb(self):
        pass

    def system_cb(self):
        pass

    def strategy_cb(self):
        pass

    def priority_cb(self):
        pass

    def priority_assignment_cb(self):
        pass

    def criteria_cb(self):
        pass

    def firm_cb(self):
        pass

    def SAS_OR_R_cb(self):
        pass

    def task_objective_cb(self):
        pass

    def composite_cb(self):
        pass

    def continuous_cb(self):
        pass

    def resource_objective_cb(self):
        pass

    def FIFO_cb(self):
        pass

    def input_cb(self):
        pass

    def SJF_cb(self):
        pass

    def abstract_objective_criteria_cb(self):
        pass

    def default_cb(self):
        pass

    def preemptive_cb(self):
        pass

    def resource_objective_purpose_cb(self):
        pass

    def ERT_cb(self):
        pass

    def mini_cb(self):
        pass

    def lateness_cb(self):
        pass

    def task_related_user_defined_criteria_cb(self):
        pass

    def earliness_cb(self):
        pass

    def resource_requirement_cb(self):
        pass

    def IBM_ILOG_CPLEX_Optimizer_cb(self):
        pass

    def preemptable_cb(self):
        pass

    def resource_related_objective_cb(self):
        pass

    def user_defined_cb(self):
        pass

    def maxi_cb(self):
        pass

    def Knapsack_cb(self):
        pass

    def online_cb(self):
        pass

    def objective_cb(self):
        pass

    def release_time_cb(self):
        pass

    def resource_related_objective_criteria_cb(self):
        pass

    def eligible_resources_cb(self):
        pass

    def abstraction_cb(self):
        pass

    def purpose_cb(self):
        pass

    def capacity_cb(self):
        pass

    def task_cb(self):
        pass

    def time_related_objective_criteria_cb(self):
        pass

    def job_level_cb(self):
        pass

    def global_objective_cb(self):
        pass