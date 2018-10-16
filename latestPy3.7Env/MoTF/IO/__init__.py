from pyecore.resources import ResourceSet, URI, global_registry
from pyecore.resources.xmi import XMIResource
from pyecore.ecore import EPackage

import pyecore.ecore as Ecore
import pyuml2.uml as UML

from .IOStrategy import *

BuiltInMetaModels = [Ecore, UML]

EAttributeType2PythonType = {
    'EFloat': float,
    'EString': str,
    'EDouble': float,
    'EInt': int,
    'LogicalOperation': lambda x: x
}

def loadMetaModel(file):
    global_registry[Ecore.nsURI] = Ecore # We load the Ecore metamodel first
    rset = ResourceSet()
    metamodel = rset.get_resource(URI(file))
    return metamodel.contents[0]


def loadModel(metamodel, file):
    rset = ResourceSet()
    rset.metamodel_registry[metamodel.nsURI] = metamodel
    return rset.get_resource(file).contents[0]


def saveModel(metamodel, model, output):
    rset = ResourceSet()
    rset.metamodel_registry[metamodel.nsURI] = metamodel
    model_resource = rset.create_resource(URI(output))
    model_resource.append(model)
    return model_resource.save()


class IO:
    def __init__(self, metamodel_file, model_file=None):
        self.metamodel_f = ""
        self.__metamodel = None
        self.model_f = model_file
        self.__model = None

        if metamodel_file in BuiltInMetaModels:
            self.__metamodel = metamodel_file
        elif isinstance(metamodel_file, str):
            self.metamodel_f = metamodel_file
            self.__metamodel = loadMetaModel(metamodel_file)

        if self.model_f:
            self.__model = loadModel(self.__metamodel, model_file)

        self.__io_strategy = NewStrategy("BASIC")

    def getModel(self):
        return self.__io_strategy.getModel(self.__model)

    def getMetaModel(self):
        return self.__metamodel

    def searchContentInMModel(self, name):
        for content in self.getMetaModel().eAllContents():
            if content.name == name:
                return content
        return None

    def getDefaultValue(self, attr_name):
        content = self.searchContentInMModel(attr_name)
        return (content, EAttributeType2PythonType[content.eType.name](content.defaultValueLiteral)) if content else (content, content)

    def getProcessedValue(self, content, attr):
        # print("ENTER", hasattr(content, attr), getattr(content, attr), hasattr(getattr(content, attr), 'eType'))
        if hasattr(content, attr):
            if hasattr(getattr(content, attr), 'eType'):
                return EAttributeType2PythonType[getattr(content, attr).eType.name](getattr(content, attr))
            else:
                return getattr(content, attr)
        # print("EXIT!")
        return self.getDefaultValue(attr)[1]

    def setIOStrategy(self, new_strategy):
        assert isinstance(new_strategy, IOStrategyInterface)
        assert new_strategy.__class__.__bases__
        self.__io_strategy = new_strategy

    def loadModel(self):
        if self.__model:
            self.__model = loadModel(self.__metamodel, self.model_f)

        raise FileNotFoundError('Model File has not been specified!!')

    def saveModel(self):
        if self.__model:
            return saveModel(self.__metamodel, self.__model, self.model_f)

        raise IOError('Model is empty!!')

    def setModelFile(self, file):
        self.model_f = file
        self.__model = loadModel(self.__metamodel, self.model_f)