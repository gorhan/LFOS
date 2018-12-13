
from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D
from .. import LOG, Logs

# task_3 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2_1', type='Default', phase=Time(3), deadline=Time(14), periodicity=PeriodicityTypeList.APERIODIC)
# task_3.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(2), cpu2: Time(2)}, capacity=1)
# task_3.add_resource_requirement(resource_type=memory_t, capacity=140)


class ProcessModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)

        self._required_data = {}
        self._duration = -1
        self._system = None

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

            resourceFSF = self._system.search_resources(identifier=requirement.resourceName)[0]
            if resourceFSF.type.get_abstraction() == ResourceTypeList.ACTIVE:
                # print('WCET:', self.getProcessedValue(requirement, 'WCET'), requirement.WCET)

                exec_classes = [(self.getProcessedValue(execution, "class"), self.getProcessedValue(execution, "wcet"))
                        for execution in requirement.execution if self.getProcessedValue(execution, "class") in classes]
                # LOG(msg=f"Node_Name={[(self.getProcessedValue(execution, 'class'), self.getProcessedValue(execution, 'wcet')) for execution in requirement.execution]} Classes={classes}")
                last_execution = exec_classes[-1]
                task.namespace = last_execution[0]

                LOG(msg=f"POPPED Execution Class={last_execution[0]}, WCET={last_execution[1]}")
                task.add_resource_requirement(resource_type=resourceFSF.type,
                                              eligible_resources={resource:Time(last_execution[1]) for resource in self._system.search_resources(type=resourceFSF.type)},
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

    def _filterInstances(self, input, model):
        classes = set([self.getProcessedValue(node, "namespace") for node in model.nodes])
        LOG(msg=classes)

        feature_model = input[("FeatureModel", 0)][1]

        exists = len(feature_model)
        feature_model = [instance for instance in feature_model if not classes.difference(set([item.name for item in instance]))]
        eliminated = exists - len(feature_model)
        LOG(msg=f"#Instance (after filtering)={len(feature_model)} Eliminated #instances={eliminated}")
        return feature_model

    def createSchedulerNAddTasks(self, instance):
        model = self.getModel()
        self._duration = self.getProcessedValue(model, "duration")

        scheduler = self.createInputTemplate()
        scheduler.set_scheduling_window_start_time(Time(0))
        scheduler.set_scheduling_window_duration(Time(self._duration))

        tasks = []
        for node in model.nodes:
            task = self._defineTask(instance, node)
            tasks.append(task)
            self._defineDependencies(node, task)
            scheduler.add_tasks_in_bundle(task)

        scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO, scheduler.get_taskset())

        for task in tasks:
            print(task.info(True))

        scheduler.set_scheduling_objective(Mini(), ObjectiveLateness())
        return scheduler

    def interpret(self, input):
        self._system = input[("PlatformModel", 0)][1]

        feature_model = self._filterInstances(input, self.getModel())
        input.append(MoPP_D(*self.ID(), feature_model))
        return input
