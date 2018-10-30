from .Models.Platform import Platform
from .Models.Process import Process
from .Models.FModel import FModel
from .Models.Class import ClassModel, UML
from .Models.Optimization import Optimization
from .Framework import OptMLFramework, GlobalOptimizer

from .ModelProcPipeline import MoPP

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

if __name__ == "__main__":
    platformModel = Platform("../MDE/Platform/model/platformMM.ecore", "../MDE/org.eclipse.OptML/inputs/System.res")
    processModel = Process("../MDE/Process/model/process.ecore", "../MDE/org.eclipse.OptML/inputs/Reg3D.process")
    classModel = ClassModel(UML, "../MDE/org.eclipse.OptML/inputs/classM.uml")
    featureModel = FModel("../MDE/featuremodel.metamodel/org.eclipse.featuremodel.metamodel/models/featuremodel.ecore", "../MDE/org.eclipse.OptML/inputs/registration.featuremodel")
    optimalityModel = Optimization("../MDE/Optimization/model/optimal.ecore", "../MDE/org.eclipse.OptML/inputs/reg3D.optimal")

    mopp = MoPP()

    mopp.input(Scheduler, solver='SCIP', verbose=1, time_cutoff=10000)
    mopp.append(classModel)
    mopp.append(featureModel)
    mopp.append(platformModel)
    # featureModel.requires(classModel)
    processModelID = mopp.append(processModel)

    processModel.requires(classModel)
    processModel.requires(featureModel)
    # mopp.append(optimalityModel)

    # from .ModelDecorator import Model
    # print(Model.__ALL__)

    optimizer = GlobalOptimizer(optimalityModel, 100, 10)

    OptMLFramework.registerProcessModel(processModelID, "createSchedulerNAddTasks")
    framework = OptMLFramework(mopp, optimizer)
    framework.exec()

    # mopp.run()
    # output = mopp.output

    # print(classModel)

    # print(f"{len(mopp.output[0])} number of instances has been successfully generated!!")

    # scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
    #
    # scheduler.add_tasks_in_bundle(*tasks.values())
    #
    # scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO, scheduler.get_taskset())
    #
    # scheduler.set_scheduling_window_start_time(Time(0))
    # scheduler.set_scheduling_window_duration(Time(25))
    #
    #
    # purpose, objective = Mini(), ObjectiveLateness()
    # scheduler.set_scheduling_objective(purpose, objective)
    #
    # print('I am here!!!')
    # schedules = output.schedule_tasks()
    # for schedule in schedules:
    #     schedule.plot_schedule()
