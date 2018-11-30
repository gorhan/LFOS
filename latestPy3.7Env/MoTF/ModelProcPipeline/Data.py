
from .. import LOG, Logs
from ..ModelDecorator import Model


class MoPP_D:
    def __init__(self, owner_cls, owner_index, data=None):
        self.__owner = self.__data = None

        self.owner = (owner_cls, owner_index)
        self.data = data

    @property
    def owner(self):
        from copy import copy
        return copy(self.__owner)

    @owner.setter
    def owner(self, owner):
        all_owners = [(elem["class"], elem["index"]) for elem in Model.__ALL__]
        if owner in all_owners:
            self.__owner = owner
            return True

        LOG(msg=f"Given owner id is not in the list: {all_owners}")
        return False

    @property
    def data(self):
        return self.__size, self.__data

    @data.setter
    def data(self, data):
        self.__data = data
        self.__type = type(self.__data)

        if self.__type is list or self.__type is dict:
            self.__size = len(self.__data)
        else:
            self.__size = 1

    def __eq__(self, other):
        cmp_ = False

        if isinstance(other, tuple):
            cmp_ = other == self.__owner
        elif isinstance(other, MoPP_D):
            cmp_ = other.owner == self.__owner

        return cmp_

    def __str__(self):
        return f"Owner={self.__owner}, Data={self.__data}:[{self.__size}]"

    def __repr__(self):
        return str(self)


class MoPPData(list):
    def __init__(self):
        list.__init__(self, [])

    def append(self, object: MoPP_D):
        try:
            assert(isinstance(object, MoPP_D))
            list.append(self, object)
        except AssertionError:
            LOG(msg=f"Given object is not in the type of MoPP_D class!", log=Logs.WARN)

    def __getitem__(self, owner):
        try:
            if isinstance(owner, tuple):
                return list.__getitem__(self, list.index(self, owner)).data
            elif isinstance(owner, int):
                return list.__getitem__(self, -1).data
        except ValueError:
            LOG(msg=f"There is no data belonging to {owner}", log=Logs.WARN)
            return None
