
from ..ModelDecorator import *

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

# task_3 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2_1', type='Default', phase=Time(3), deadline=Time(14), periodicity=PeriodicityTypeList.APERIODIC)
# task_3.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(2), cpu2: Time(2)}, capacity=1)
# task_3.add_resource_requirement(resource_type=memory_t, capacity=140)


class Process(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self._allTasks = {}

        self._required_data = {}

    def unique_id(self, node):
        return f"{self.getProcessedValue(node, 'namespace')}-{self.getProcessedValue(node, 'name')}[{self.getProcessedValue(node, 'id')}]"

    def _defineTasks(self, model):
        nodes = model.nodes
        n_nodes = len(nodes)

        for node in nodes:
            task = TaskFactory.create_instance(TaskTypeList.TERMINAL,
                                               name=self.unique_id(node), type=self.getProcessedValue(node, 'namespace'),
                                               phase=Time(0),
                                               deadline=Time(n_nodes),
                                               periodicity=PeriodicityTypeList.APERIODIC,
                                               preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)

            period = self.getProcessedValue(node, 'period')
            if period > 0.0:
                task.set_periodicity(PeriodicityTypeList.PERIODIC)
                task.set_period(Time(period))

            # print("Resource Name=", node.name)
            for requirement in node.requires:
                resource_name = self.getProcessedValue(requirement, 'resourceName')
                print('Resource Requirement=', requirement.resourceName)
                resourceFSF = System.search_resources(identifier=requirement.resourceName)[0]
                if resourceFSF.type.get_abstraction() == ResourceTypeList.ACTIVE:
                    print('WCET:', self.getProcessedValue(requirement, 'WCET'), requirement.WCET)
                    task.add_resource_requirement(resource_type=resourceFSF.type,
                                                  eligible_resources={resource:Time(self.getProcessedValue(requirement, 'WCET')) for resource in System.search_resources(type=resourceFSF.type)},
                                                  capacity=self.getProcessedValue(requirement, 'requiredCapacity'))
                else:
                    task.add_resource_requirement(resource_type=resourceFSF.type, capacity=self.getProcessedValue(requirement, 'requiredCapacity'))

            self._allTasks[self.unique_id(node)] = task

    def _defineDependencies(self, model):
        for node in model.nodes:
            # Output
            task = self._allTasks[self.unique_id(node)]
            if hasattr(node, 'output') and hasattr(node.output[0], 'data'):
                for output in node.output:
                    print(f"Automatic output data \"{self.getProcessedValue(output.data, 'alias')}\" generation for the task \"{self.unique_id(node)}\"")
                    task.add_output_token(self.getProcessedValue(output.data, "alias"), self.getProcessedValue(output, "no_provided"))

                # if node not in [d.data.producedBy for d in node.output]:
                #     print(f"Automatic output data generation for the task \"{node.name}\"")
                #     task.add_output_token(node.name, 1)
            else:
                print(f"Task {self.unique_id(node)} has no attribute named \"output\"")
                task.add_output_token(self.unique_id(node), 1)

            # Input
            if hasattr(node, 'input') and node.input is not None:
                logicalOperationLiterals = self.getMetaModel().getEClassifier('LogicalOperation')
                operation = None
                if self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('AND'):
                    operation = AND()
                elif self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('XOR'):
                    operation = XOR()

                task.set_logical_relation(operation)
                print(f"The logical relation for necessary tokens below is {operation}")
                print(f"Node={self.unique_id(node)}, input={node.input},")
                for token in node.input.item:
                    print(f"The task {self.unique_id(node)} needs the data {self.getProcessedValue(output.data, 'alias')}")
                    task.add_dependency(self.getProcessedValue(token.data, 'alias'), self.getProcessedValue(token, 'no_required'))
            else:
                print(f"Task {self.unique_id(node)} has no attribute named \"input\"")

    def gatherRequiredInfo(self):
        return None

    def processRequiredInfo(self, info):
        self._required_data[info[0]] = info[1]

    @pointcut("before")
    def interpret(self, input=None):
        model = self.getModel()
        self._defineTasks(model)
        self._defineDependencies(model)

        input.add_tasks_in_bundle(*self._allTasks.values())
        input.set_scheduling_window_start_time(Time(0))
        input.set_scheduling_window_duration(Time(len(self._allTasks)))
        input.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO, input.get_taskset())

        print(f"Number of tasks={len(self._allTasks)}")
        for task in self._allTasks.values():
            print(task.info(True))
        return input
