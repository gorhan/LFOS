from .Models.Platform import PlatformModel
from .Models.Process import ProcessModel
from .Models.Feature import FeatureModel
from .Models.Class import ClassModel, UML
from .Framework import OptMLFramework

from .Optimizer.Search import FirstOptimalResult
from .ModelProcPipeline import MoPP

from LFOS.Scheduler.Scheduler import Scheduler

if __name__ == "__main__":
    platformModel = PlatformModel("../MDE/Platform/model/platformMM.ecore", "../MDE/org.eclipse.OptML/inputs/system_scenario1.res")
    processModel = ProcessModel("../MDE/Process/model/process.ecore", "../MDE/org.eclipse.OptML/inputs/Reg3D.process")
    classModel = ClassModel(UML, "../MDE/org.eclipse.OptML/inputs/classM.uml")
    featureModel = FeatureModel("../MDE/featuremodel.metamodel/org.eclipse.featuremodel.metamodel/models/featuremodel.ecore", "../MDE/org.eclipse.OptML/inputs/registration.featuremodel")

    mopp = MoPP()

    mopp.setInputTemplate(Scheduler, solver='Gurobi', verbose=1, time_cutoff=25000)
    mopp.append(classModel)
    mopp.append(featureModel)
    mopp.append(platformModel)
    processModelID = mopp.append(processModel)


    OptMLFramework.registerProcessModel(processModelID, "createSchedulerNAddTasks")
    framework = OptMLFramework(mopp, FirstOptimalResult(100, 5))
    framework.exec()