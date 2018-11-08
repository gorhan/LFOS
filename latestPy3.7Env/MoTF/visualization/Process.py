from graphviz import Digraph

from ..ModelDecorator import *
from .Object import object_node_gen


class ProcessModelVis(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self.__f_group = ["Input", "Filter", "FExtract"]
        self.__s_group = ["Match", "Transform"]
        self._graphs = Digraph(f"ProcessModel_{'_'.join(self.__f_group)}", node_attr={"shape":"plaintext"}, format="pdf"), \
                       Digraph(f"ProcessModel_{'_'.join(self.__s_group)}", node_attr={"shape":"plaintext"}, format="pdf")
        self._graphs[0].attr(compound="true", splines="ortho")
        self._graphs[1].attr(compound="true", splines="ortho")

        self.__nodes = []
        self.__dpool = []

        self.traverse()
        self._graphs[0].render()
        self._graphs[1].render()

    def unique_id(self, node):
        return f"{self.getProcessedValue(node, 'namespace')}-{self.getProcessedValue(node, 'name')}[{self.getProcessedValue(node, 'id')}]"

    def traverse(self):
        model = self.getModel()

        for index, node in enumerate(model.nodes):
            graph = self._graphs[1]
            if self.getProcessedValue(node, "namespace") in self.__f_group:
                graph = self._graphs[0]
            elif self.getProcessedValue(node, "namespace") in self.__s_group:
                graph = self._graphs[1]

            with graph.subgraph(name=f"Process{index}") as sg:
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

                        data_attribute = {
                            "alias": self.getProcessedValue(inp_data, "alias"),
                            "no_available": self.getProcessedValue(inp_data, "no_available")
                        }

                        data_id = self.getProcessedValue(inp_data, "alias")
                        sg.node(data_id, object_node_gen(data_id, "Data", data_attribute), color="red")
                        sg.edge(inputList_id, data_id, taillabel=str(self.getProcessedValue(item, "no_required")))