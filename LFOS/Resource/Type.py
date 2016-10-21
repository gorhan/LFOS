from LFOS.Log import Logs, LOG


class ResourceTypeList:
    ACTIVE = 'Resource.Type.ACTIVE'
    PASSIVE = 'Resource.Type.PASSIVE'
    COMPOSITE = 'Resource.Type.COMPOSITE'


class Type:
    ABS_LIST = [ResourceTypeList.ACTIVE, ResourceTypeList.PASSIVE, ResourceTypeList.COMPOSITE]

    def __init__(self, abstraction, identifier):
        if abstraction in Type.ABS_LIST:
            self.abstraction = abstraction
        else:
            self.abstraction = ResourceTypeList.COMPOSITE
            LOG(msg='Invalid type of abstraction. Abstractions=%s' % (', '.join(Type.ABS_LIST)), log=Logs.ERROR)

        self.identifier = identifier

    def same_identifier(self, id):
        return id == self.identifier

    def same_abstraction(self, abs):
        return abs == self.abstraction

    def get_abstraction(self):
        return self.abstraction

    def get_identifier(self):
        return self.identifier

    def __eq__(self, other):
        return self.same_abstraction(other.abstraction) and self.same_identifier(other.identifier) if isinstance(other, Type) else False

    def __str__(self):
        return '[%s, %s]' % (self.abstraction, self.identifier)

    @classmethod
    def check(cls, instance):
        return isinstance(instance, cls)