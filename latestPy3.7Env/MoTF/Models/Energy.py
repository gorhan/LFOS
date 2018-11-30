from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D
from .. import LOG, Logs


class EnergyModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)

