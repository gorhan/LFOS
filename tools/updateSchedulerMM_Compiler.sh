#!/bin/bash

SCHEDULER_MM_SRC_DIR=~/workspace/Scheduler
SCHEDULER_MM_DEST_DIR=~/workspace/LFOS/SchedulerMM/

COMPILER_SRC_DIR=~/runtime-EclipseApplication/Scheduler2Python
COMPILER_DEST_DIR=~/workspace/LFOS/SchedulerCompiler/

# echo "$SCHEDULER_MM_SRC_DIR/*"
cp -rvf "$SCHEDULER_MM_SRC_DIR"/* "$SCHEDULER_MM_DEST_DIR"
cp -rvf "$COMPILER_SRC_DIR"/* "$COMPILER_DEST_DIR"
