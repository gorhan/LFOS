
from ..ModelDecorator import Model


class MoPP(list):
    def __init__(self):
        list.__init__(self, [])
        self._input = [Ellipsis]
        self._output = None

    def append(self, object: Model):
        if not isinstance(object, Model):
            raise ValueError(f"Invalid type of object has been requested to append. Type = {type(object)}")
        list.append(self, object)
        return object.ID()

    def __add__(self, other):
        if not isinstance(other, list):
            raise ValueError(f"Invalid type of object has been requested to add. Type = {type(other)}")
        for elem in other:
            if not isinstance(elem, Model):
                raise ValueError(f"Invalid type of object has been requested to add in the list. Type = {type(elem)}")
        return list.__add__(self, other)

    def __iadd__(self, other):
        if not isinstance(other, list):
            raise ValueError(f"Invalid type of object has been requested to add. Type = {type(other)}")
        for elem in other:
            if not isinstance(elem, Model):
                raise ValueError(f"Invalid type of object has been requested to add in the list. Type = {type(elem)}")
        return list.__iadd__(self, other)

    def __scope__(self, index):
        if index + len(self) < 0 or index >= len(self):
            raise IndexError(f"Index out of range: {index} not in [{-len(self)} {len(self)})")
        return index if index >= 0 else index + len(self)

    def insert(self, index: int, object: Model):
        if not isinstance(object, Model):
            raise ValueError(f"Invalid type of object has been requested to add. Type = {type(other)}")

        list.insert(self, index, object)
        return object.ID()

    def swap(self, swap1, swap2):
        if isinstance(swap1, int) and isinstance(swap2, int):
            swap1, swap2 = self.__scope__(swap1), self.__scope__(swap2)
        elif isinstance(swap1, Model) and isinstance(swap2, Model):
            swap1, swap2 = list.index(self, swap1), list.index(self, swap2)
        else:
            raise TypeError(f"swap is only possible for int, int or Model, Model objects. swap1, swap2 = {type(swap1)}, {type(swap2)}")

        elem2 = list.pop(self, max(swap1, swap2))
        elem1 = list.pop(self, min(swap1, swap2))
        list.insert(self, min(swap1, swap2), elem2)
        list.insert(self, max(swap1, swap2), elem1)

    def input(self, cls, **kwargs):
        self._constructor = (cls, kwargs)

    def run(self):
        for elem in self:
            elem.setInputTemplate(*self._constructor)
            self._input = elem.interpret(self._input)
        self._output = self._input

    def findModelIndex(self, model_id):
        for index, model in enumerate(self):
            if model.ID() == model_id:
                return index

        raise ValueError("Model is not in the list.")

    def command(self, model_id, func):
        return getattr(self[self.findModelIndex(model_id)], func)

    @property
    def output(self):
        return self._output
