from .Models.Platform import Platform
from .Models.Process import Process
from .Models.FModel import FModel
from .Models.Class import ClassModel, UML

from .ModelProcPipeline import MoPP

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

if __name__ == "__main__":
    platform = Platform("../MDE/Platform/model/platformMM.ecore", "../MDE/org.eclipse.OptML/inputs/System.res")
    process = Process("../MDE/Process/model/process.ecore", "../MDE/org.eclipse.OptML/inputs/registration.process")
    classModel = ClassModel(UML, "../MDE/org.eclipse.OptML/inputs/classM.uml")
    featureModel = FModel("../MDE/featuremodel.metamodel/org.eclipse.featuremodel.metamodel/models/featuremodel.ecore",
                          "../MDE/org.eclipse.OptML/inputs/registration.featuremodel")

    mopp = MoPP()

    mopp.append(platform)
    mopp.append(process)
    mopp.append(classModel)
    mopp.append(featureModel)
    mopp.run()

    print(f"{len(mopp.output[0])} number of instances has been successfully generated!!")

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
    # schedules = scheduler.schedule_tasks()
    # for schedule in schedules:
    #     schedule.plot_schedule()
