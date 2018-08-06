
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

    def _defineTasks(self, model):
        nodes = model.nodes
        n_nodes = len(nodes)

        for node in nodes:
            task = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=node.name, type=node.namespace,
                                               phase=Time(0), deadline=Time(n_nodes + 2),
                                               periodicity=PeriodicityTypeList.APERIODIC)

            if node.eClass.name == "Process":
                period = self.getProcessedValue(node, 'period')
                if period:
                    task.set_periodicity(PeriodicityTypeList.PERIODIC)
                    task.set_period(Time(int(period)))

            # print("Resource Name=", node.name)
            for requirement in node.requires:
                resource_name = self.getProcessedValue(requirement, 'resourceName')
                print('Resource Requirement=', requirement.resourceName)
                resourceFSF = System.search_resources(identifier=requirement.resourceName)[0]
                if resourceFSF.type.get_abstraction() == ResourceTypeList.ACTIVE:
                    print('WCET:', int(self.getProcessedValue(requirement, 'WCET')))
                    task.add_resource_requirement(resource_type=resourceFSF.type,
                                                  eligible_resources={resource:Time(int(self.getProcessedValue(requirement, 'WCET'))) for resource in System.search_resources(type=resourceFSF.type)},
                                                  capacity=int(self.getProcessedValue(requirement, 'requiredCapacity')))
                else:
                    task.add_resource_requirement(resource_type=resourceFSF.type, capacity=int(self.getProcessedValue(requirement, 'requiredCapacity')))

            self._allTasks[task.name] = task

    def _defineDependencies(self, model):
        for node in model.nodes:
            # Output
            task = self._allTasks[node.name]
            if hasattr(node, 'output') and hasattr(node.output, 'data'):
                for token in node.output.data:
                    print("Automatic output data generation for the task \"{node.name}\"")
                    task.add_output_token(token.producedBy.name, token.amount)

                if node not in [d.producedBy for d in node.output.data]:
                    print("Automatic output data generation for the task \"{node.name}\"")
                    task.add_output_token(node.name, 1)
            else:
                print(f"Task {node.name} has no attribute named \"output\"")
                task.add_output_token(node.name, 1)

            # Input
            if hasattr(node, 'input'):
                logicalOperationLiterals = self.getMetaModel().getEClassifier('LogicalOperation')
                operation = None
                if self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('AND'):
                    operation = AND()
                elif self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('OR'):
                    operation = OR()
                elif self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('XOR'):
                    operation = XOR()

                task.set_logical_relation(operation)
                print(f"The logical relation for necessary tokens below is {operation}")
                if hasattr(node.input, 'data'):
                    for token in node.input.data:
                        print(f"The task {node.name} needs the data {token.producedBy.name}")
                        task.add_dependency(token.producedBy.name, self.getProcessedValue(token, 'amount'))
                else:
                    print(f"Task {node.name} has no attribute named \"input\"")


            print(task.info(True))

    def gatherRequiredInfo(self):
        return [{'name': task.name, "namespace": task.get_attr('namespace')} for task in self._allTasks.values()]

    def interpret(self, input=None):
        model = self.getModel()
        self._defineTasks(model)
        self._defineDependencies(model)

        input.add_tasks_in_bundle(*self._allTasks)

        print(f"Number of tasks={len(self._allTasks)}")
        return input
