from .Models.Platform import PlatformModel
from .Models.Process import ProcessModel
from .Models.Feature import FeatureModel
from .Models.Class import ClassModel, UML
from .Models.Value import ValueModel
from .Framework import OptMLFramework

from .ModelProcPipeline import MoPP

from LFOS.Scheduler.Scheduler import Scheduler

if __name__ == "__main__":
    platformModel = PlatformModel("../MDE/Platform/model/platformMM.ecore", "../MDE/org.eclipse.OptML/inputs/System.res")
    processModel = ProcessModel("../MDE/Process/model/process.ecore", "../MDE/org.eclipse.OptML/inputs/Reg3D.process")
    classModel = ClassModel(UML, "../MDE/org.eclipse.OptML/inputs/classM.uml")
    featureModel = FeatureModel("../MDE/featuremodel.metamodel/org.eclipse.featuremodel.metamodel/models/featuremodel.ecore", "../MDE/org.eclipse.OptML/inputs/registration.featuremodel")
    energyModel = ValueModel("../MDE/Value/model/value.ecore", "../MDE/org.eclipse.OptML/inputs/energy.value")

    mopp = MoPP()

    mopp.setInputTemplate(Scheduler, solver='Gurobi', verbose=1, time_cutoff=25000)
    mopp.append(classModel)
    mopp.append(featureModel)
    mopp.append(platformModel)
    processModelID = mopp.append(processModel)
    mopp.append(energyModel)

    OptMLFramework.registerProcessModel(processModelID, "createSchedulerNAddTasks")
    framework = OptMLFramework(mopp)
    framework.exec(extractor_owner=["ValueModel"], fitness=True, ranking_strategy="ascending", search=["nth-fit", 5, 10000], normalize=False)