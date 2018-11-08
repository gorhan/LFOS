
from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D
from LFOS.Resource.Resource import *


class PlatformModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self.typeFSF_d = {}

    def _defineResourcePowerConsumption(self, resource):
        if len(resource.states) == 1:
            state = resource.states[0]
            return PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, self.getProcessedValue(state, 'scale'), self.getProcessedValue(state, 'energy'))

        states = []
        for state in resource.states:
            print(f"Scale has been set to {self.getProcessedValue(state, 'scale')} --> {self.getProcessedValue(state, 'energy')}")
            states.append((self.getProcessedValue(state, 'scale'), self.getProcessedValue(state, 'energy')))
        states.sort(key=lambda state: state[0])

        power = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, states[0][0], states[0][1], states[-1][0], states[-1][1])
        for state in states[1:-1]:
            power.add_state(state[0], state[1])

        return power

    def _defineResources(self):
        allResources = self._preOrderTraverseResourceTree(self.getModel().System)

        for resource, parent in allResources[1:]: # excluding the root SYSTEM
            init_resource = ResourceFactory.create_instance(self.typeFSF_d[resource.belongs.identifier], resource.name)
            if parent:
                System.search_resources(name=parent.name if parent.name != 'System' else 'SYSTEM')[0].add(init_resource)

            if resource.belongs.abstraction.name != 'COMPOSITE':
                if resource.capacity > 0:
                    init_resource.set_capacity(resource.capacity)
                else:
                    init_resource.set_capacity(float(self.getDefaultValue('capacity')[1]))

                init_resource.set_power_consumption(self._defineResourcePowerConsumption(resource))

    def _defineExclusiveResources(self):
        allResources = self._preOrderTraverseResourceTree(self.getModel().System)

        for resource, _ in allResources:
            if hasattr(resource, 'exclusiveResources'):
                for exc_resource in resource.exclusiveResources:
                    found_resource = System.search_resources(name=exc_resource.name)[0]
                    if found_resource:
                        System.search_resources(name=resource.name)[0].add_exclusive_resource(found_resource)
                        print("Exclusive resources have been defined.. {} <--> {}".format(resource.name, exc_resource.name))

    def _preOrderTraverseResourceTree(self, resource, parent=None):
        traverse_lst = [(resource, parent)]
        childs = resource.childs if hasattr(resource, 'childs') else []
        for child in childs:
            traverse_lst += self._preOrderTraverseResourceTree(child, resource)
        return traverse_lst

    def _initializeResourceTypes(self, schedulerFSF):
        model = self.getModel()

        for resourceType in model.resourceTypes:
            resourceTypeFSF = ResourceTypeList.COMPOSITE
            if resourceType.abstraction.name == 'ACTIVE':
                resourceTypeFSF = ResourceTypeList.ACTIVE
            elif resourceType.abstraction.name == 'PASSIVE':
                resourceTypeFSF = ResourceTypeList.PASSIVE

            self.typeFSF_d[resourceType.identifier] = Type(resourceTypeFSF, resourceType.identifier)

    def interpret(self, input):
        self._initializeResourceTypes(input)
        self._defineResources()
        self._defineExclusiveResources()
        System.pretty_print()

        input.append(MoPP_D(*self.ID(), System))
        return input