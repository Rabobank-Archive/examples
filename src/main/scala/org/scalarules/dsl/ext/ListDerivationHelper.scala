package org.scalarules.dsl.ext

import org.scalarules.dsl.nl.grammar.{DslCondition, DslEvaluation}
import org.scalarules.engine.{Context, Evaluation}

import scala.language.implicitConversions

/**
  * This is and ad-hoc extension to the Scala Rules DSL. We will need to merge it into the DSL itself.
  * It allows the use of an ad-hoc List of Facts to be used where a single DslEvaluation of type List
  * is expected.
  */
object ListDerivationHelper {

  private[this] def constructDslEvaluation[A](dslEvals: List[DslEvaluation[A]]): DslEvaluation[List[A]] = {
    val condition: DslCondition = dslEvals.map(e => e.condition).foldLeft(DslCondition.emptyTrueCondition)((v, cond) => DslCondition.orCombineConditions(v, cond))
    val evaluation: Evaluation[List[A]] = new Evaluation[List[A]] {
      override def apply(c: Context): Option[List[A]] = {
        val values = dslEvals.map(e => e.evaluation.apply(c)).filter(option => option.isDefined)

        if (values.isEmpty) None else Some(values.map(option => option.get))
      }
    }

    new DslEvaluation[List[A]](condition, evaluation)
  }


  implicit def listOfEvalToEvalOfList[A](dslEvals: List[DslEvaluation[A]]): DslEvaluation[List[A]] = constructDslEvaluation(dslEvals)
  implicit def listOfConvertableToEvalToEvalOfList[A, B](dslEvals: List[B])(implicit ev: B => DslEvaluation[A]): DslEvaluation[List[A]] =
    constructDslEvaluation( dslEvals.map( e => ev(e) ) )

}
