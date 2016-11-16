from LFOS.Scheduling.Solver.Solver import SolverAdapter


class SchedulingStrategy(SolverAdapter):
    def __init__(self, **kwargs):
        SolverAdapter.__init__(self, **kwargs)