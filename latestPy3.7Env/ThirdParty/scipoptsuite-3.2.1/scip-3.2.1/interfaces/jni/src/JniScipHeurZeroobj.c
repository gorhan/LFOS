/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/*                                                                           */
/*                  This file is part of the program and library             */
/*         SCIP --- Solving Constraint Integer Programs                      */
/*                                                                           */
/*    Copyright (C) 2002-2016 Konrad-Zuse-Zentrum                            */
/*                            fuer Informationstechnik Berlin                */
/*                                                                           */
/*  SCIP is distributed under the terms of the ZIB Academic License.         */
/*                                                                           */
/*  You should have received a copy of the ZIB Academic License              */
/*  along with SCIP; see the file COPYING. If not email to scip@zib.de.      */
/*                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/**@file   JniScipHeurZeroobj.c
 * @ingroup PUBLICMETHODS
 * @brief  JNI SCIP heur zeroobj callable library
 * @author Stefan Heinz
 * @author Alexandra Kraft
 */

/*---+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8----+----9----+----0----+----1----+----2*/

#include "JniScipHeurZeroobj.h"
#include "def.h"

#include "scip/scip.h"
#include "scip/scipdefplugins.h"
#include "scip/heur_zeroobj.h"

#include <string.h>

/** main procedure of the zeroobj heuristic, creates and solves a sub-SCIP */
JNIEXPORT
void JNISCIPHEURZEROOBJ(applyZeroobj)(
   JNIEnv*               env,                /**< JNI environment variable */
   jobject               jobj,               /**< JNI class pointer */
   jlong                 jscip,              /**< SCIP data structure */
   jlong                 jheur,              /**< heuristic data structure */
   jintArray             jresult,            /**< result data structure */
   jdouble               jminimprove,        /**< factor by which zeroobj should at least improve the incumben */
   jlong                 jnnodes             /**< node limit for the subproblem */
   )
{
   SCIPerrorMessage("method applyZeroobj is not implemented yet (deprecated)\n");
   JNISCIP_CALL( SCIP_ERROR );
}

/** creates the zeroobj primal heuristic and includes it in SCIP */
JNIEXPORT
void JNISCIPHEURZEROOBJ(includeHeurZeroobj)(
   JNIEnv*               env,                /**< JNI environment variable */
   jobject               jobj,               /**< JNI class pointer */
   jlong                 jscip               /**< SCIP data structure */
   )
{
   SCIP* scip;

   /* convert JNI pointer into C pointer */
   scip = (SCIP*) (size_t) jscip;
   assert(scip != NULL);

   JNISCIP_CALL( SCIPincludeHeurZeroobj(scip) );
}