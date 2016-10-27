from pyscipopt import Model
from LFOS.Scheduling.Solver.Solver import SolverTypes


class SolverInOut:
    def __init__(self, solver_type):
        self.__solver_type = solver_type
        self.__variables = dict()
        self.__schedule = None

    def add_variable(self, model, variable_name, **kwargs):
        if self.__solver_type == SolverTypes.SCIP_SOPLEX:
            assert isinstance(model, Model)
            self.__variables[variable_name] = {}

            self.__variables[variable_name] = model.addVar(kwargs)
            return self.__variables[variable_name]

    def get_variable(self, variable):
        return self.__variables[variable]

    def add_constraint(self, model, constraint, constraint_identifier):
        if self.__solver_type == SolverTypes.SCIP_SOPLEX:
            assert isinstance(model, Model)

            model.addCons(constraint, constraint_identifier)

    def set_objective(self, model, objective, objective_idenftifier):
        if self.__solver_type == SolverTypes.SCIP_SOPLEX:
            assert isinstance(model, Model)

            model.setObjective(objective, objective_idenftifier)

    def optimize(self, model, hide=True):
        if self.__solver_type == SolverTypes.SCIP_SOPLEX:
            assert isinstance(model, Model)
            if hide:
                model.hideOutput()

            model.optimize()

    def get_schedule(self):