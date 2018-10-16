from graphviz import Digraph

from ..ModelDecorator import *
from .Object import object_node_gen


class ProcessModelVis(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self._graph = Digraph('Process Model', node_attr={"shape":"plaintext"})
        self._graph.attr(compound="true", splines="ortho")

        self.__nodes = []
        self.__dpool = []

        self.traverse()
        self._graph.view()

    def unique_id(self, node):
        return f"{self.getProcessedValue(node, 'namespace')}-{self.getProcessedValue(node, 'name')}[{self.getProcessedValue(node, 'id')}]"

    def traverse(self):
        model = self.getModel()

        for index, node in enumerate(model.nodes):
            with self._graph.subgraph(name=f"Process{index}") as sg:
                _id = self.unique_id(node)
                print("ID", _id)

                attributes = {
                    "name": self.getProcessedValue(node, "name"),
                    "namespace": self.getProcessedValue(node, "namespace"),
                    "id": self.getProcessedValue(node, "id"),
                    "period": self.getProcessedValue(node, "period")
                }

                sg.node(_id, object_node_gen(attributes["name"], "Process", attributes), color="dodgerblue2")
                self.__nodes.append(_id)

                if hasattr(node, "output"):
                    for output in node.output:
                        quantity = self.getProcessedValue(output, "no_provided")

                        data = output.data
                        data_id = self.getProcessedValue(data, "alias")
                        data_attribute = {
                            "alias": self.getProcessedValue(data, "alias"),
                            "no_available": self.getProcessedValue(data, "no_available")
                        }
                        sg.node(data_id, object_node_gen(data_attribute["alias"], "Data", data_attribute), color="red")
                        # self.add_node("Data", data_id, data_attribute, color="red")

                        print(_id, data_id)
                        sg.edge(_id, data_id, taillabel=str(self.getProcessedValue(output, "no_provided")))

                if hasattr(node, "input") and node.input:
                    logicalOperationLiterals = self.getMetaModel().getEClassifier('LogicalOperation')
                    operation = "XOR"
                    if self.getProcessedValue(node.input, 'operation') == logicalOperationLiterals.getEEnumLiteral('AND'):
                        operation = "AND"

                    inputList_id = f"Input-{_id}"
                    # self.add_node("InputList", inputList_id, {"operation": operation})
                    sg.node(inputList_id, object_node_gen("", "InputList", {"operation": operation}))
                    sg.edge(f"{_id}:S", f"{inputList_id}:N", arrowhead="diamond")

                    for item in node.input.item:
                        inp_data = item.data

                        data_id = self.getProcessedValue(inp_data, "alias")
                        sg.edge(inputList_id, data_id, taillabel=str(self.getProcessedValue(item, "no_required")))