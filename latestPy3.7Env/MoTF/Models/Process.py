
from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

from ..ModelDecorator import *
from .. import LOG, Logs

# task_3 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2_1', type='Default', phase=Time(3), deadline=Time(14), periodicity=PeriodicityTypeList.APERIODIC)
# task_3.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(2), cpu2: Time(2)}, capacity=1)
# task_3.add_resource_requirement(resource_type=memory_t, capacity=140)


class Process(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)

        self._required_data = {}
        self._duration = -1

    def unique_id(self, node):
        return f"{self.getProcessedValue(node, 'namespace')}-{self.getProcessedValue(node, 'name')}[{self.getProcessedValue(node, 'id')}]"

    def _defineTask(self, classes, node):

        task = TaskFactory.create_instance(TaskTypeList.TERMINAL,
                                           name=self.unique_id(node), type=self.getProcessedValue(node, 'namespace'),
                                           phase=Time(0),
                                           deadline=Time(self._duration),
                                           periodicity=PeriodicityTypeList.APERIODIC,
                                           preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)

        period = self.getProcessedValue(node, 'period')
        if period > 0.0:
            task.set_periodicity(PeriodicityTypeList.PERIODIC)
            task.set_period(Time(period))

        # print("Resource Name=", node.name)
        for requirement in node.requires:
            resource_name = self.getProcessedValue(requirement, 'resourceName')
            LOG(msg=f"Resource Requirement={requirement.resourceName}")
            resourceFSF = System.search_resources(identifier=requirement.resourceName)[0]
            if resourceFSF.type.get_abstraction() == ResourceTypeList.ACTIVE:
                # print('WCET:', self.getProcessedValue(requirement, 'WCET'), requirement.WCET)

                exec_classes = [(self.getProcessedValue(execution, "class"), self.getProcessedValue(execution, "wcet"))
                        for execution in requirement.execution if self.getProcessedValue(execution, "class") in classes]
                # LOG(msg=f"Node_Name={[(self.getProcessedValue(execution, 'class'), self.getProcessedValue(execution, 'wcet')) for execution in requirement.execution]} Classes={classes}")
                last_execution = exec_classes.pop()
                LOG(msg=f"POPPED Execution Class={last_execution[0]}, WCET={last_execution[1]}")
                task.add_resource_requirement(resource_type=resourceFSF.type,
                                              eligible_resources={resource:Time(last_execution[1]) for resource in System.search_resources(type=resourceFSF.type)},
                                              capacity=self.getProcessedValue(requirement, 'requiredCapacity'))
            else:
                task.add_resource_requirement(resource_type=resourceFSF.type, capacity=self.getProcessedValue(requirement, 'requiredCapacity'))

        return task

    def _defineDependencies(self, node, task):
        if hasattr(node, 'output') and hasattr(node.output[0], 'data'):
            for output in node.output:
                LOG(msg=f"Automatic output data \"{self.getProcessedValue(output.data, 'alias')}\" generation for the task \"{self.unique_id(node)}\"")
                task.add_output_token(self.getProcessedValue(output.data, "alias"), self.getProcessedValue(output, "no_provided"))

            # if node not in [d.data.producedBy for d in node.output]:
            #     print(f"Automatic output data generation for the task \"{node.name}\"")
            #     task.add_output_token(node.name, 1)
        else:
            LOG(msg=f"Task {self.unique_id(node)} has no attribute named \"output\"")
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
            LOG(msg=f"The logical relation for necessary tokens below is {operation}")
            LOG(msg=f"Node={self.unique_id(node)}, input={node.input},")
            for token in node.input.item:
                LOG(msg=f"The task {self.unique_id(node)} needs the data {self.getProcessedValue(output.data, 'alias')}")
                task.add_dependency(self.getProcessedValue(token.data, 'alias'), self.getProcessedValue(token, 'no_required'))
        else:
            LOG(msg=f"Task {self.unique_id(node)} has no attribute named \"input\"")

    def gatherRequiredInfo(self):
        return None

    def processRequiredInfo(self, info):
        self._required_data[info[0]] = info[1]

    def _filterInstances(self, model):
        classes = set([self.getProcessedValue(node, "namespace") for node in model.nodes])
        LOG(msg=classes)

        exists = len(self._required_data["FModel"])
        self._required_data["FModel"] = [instance for instance in self._required_data["FModel"] if not classes.difference(set([item.name for item in instance]))]
        eliminated = exists - len(self._required_data["FModel"])
        LOG(msg=f"#Instance (after filtering)={len(self._required_data['FModel'])} Eliminated #instances={eliminated}")

    # def _createSchedulers(self, model):
    #     schedulers = []
    #
    #     self._duration = self.getProcessedValue(model, "duration")
    #     LOG(msg=f"Duration = {self._duration}", log=Logs.INFO)
    #
    #     for instance in self._required_data["FModel"]:
    #         tasks = []
    #         for node in model.nodes:
    #             task = self._defineTask(instance, node)
    #             self._defineDependencies(node, task)
    #             tasks.append(task)
    #
    #         schedulers.append({"configuration": instance,
    #                            "duration": self._duration})
    #
    #     return schedulers

    def createSchedulerNAddTasks(self, instance):
        model = self.getModel()
        self._duration = self.getProcessedValue(model, "duration")

        scheduler = self.createInputTemplate()
        scheduler.set_scheduling_window_start_time(Time(0))
        scheduler.set_scheduling_window_duration(Time(self._duration))

        for node in model.nodes:
            task = self._defineTask(instance, node)
            self._defineDependencies(node, task)
            scheduler.add_tasks_in_bundle(task)

        scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO, scheduler.get_taskset())
        return scheduler

    @pointcut("before")
    def interpret(self, input=None):
        self._filterInstances(self.getModel())
        return self._required_data["FModel"]
