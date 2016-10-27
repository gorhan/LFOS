from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Solver.SolverIO import SolverInOut
from pyscipopt import Model


class SolverInterface(SolverInOut):
    def __init__(self):
        self.model = None



class IBM_ILOG_CPLEX_Solver(SolverInterface):
    def __init__(self):
        self.model = None


class SCIP_SOPLEX_Solver(SolverInterface):
    def __init__(self):
        self.model = Model('SCIP_SOPLEX_SOLVER: SCHEDULING')


class SolverTypes:
    IBM_ILOG_CPLEX_OPTIMIZER = 'SolverTypes.IBM_ILOG_CPLEX'
    SCIP_SOPLEX = 'SolverTypes.SCIP_SoPlex'


class SolverFactory:
    TYPES = {
        SolverTypes.IBM_ILOG_CPLEX_OPTIMIZER: IBM_ILOG_CPLEX_Solver,
        SolverTypes.SCIP_SOPLEX: SCIP_SOPLEX_Solver
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, **kwargs):
        if _type in cls.TYPES:
            return cls.TYPES[_type](**kwargs)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None