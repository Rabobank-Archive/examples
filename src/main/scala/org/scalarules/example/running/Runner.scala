package org.scalarules.example.running

import org.scalarules.finance.nl._
import org.scalarules.engine.{Context, FactEngine}
import org.scalarules.example.ExampleDerivation
import org.scalarules.example.ExampleGlossary._
import org.scalarules.utils.PrettyPrinter

//scalastyle:off regex

/**
  * Example class to show how the Scala Rules engine can be called with the example
  * calculations defined in this project.
  */
object Runner {

  val initialContext: Context = Map(
    FlatTaxRate -> 45.procent,
    HealthCostReimbursementPercentage -> 75.procent,
    HealthCostReimbursementCeiling -> 2500.euro,
    TotalPrepaidTaxes -> 21000.euro
  )

  def main(args: Array[String]): Unit = {
    runCalculationsNormally
    runCalculationsWithTracing
  }

  private def runCalculationsNormally(): Unit = {
    println(
      """-----------------------------------------
        |Starting Default run of ExampleDerivation
        |-----------------------------------------
      """.stripMargin)

    val resultContext: Context = FactEngine.runNormalDerivations(initialContext, new ExampleDerivation().berekeningen)

    println("Results are: ")
    println(PrettyPrinter.printContext(resultContext))
  }

  private def runCalculationsWithTracing(): Unit = {
    println(
      """
        |---------------------------------------
        |Starting DEBUG run of ExampleDerivation
        |---------------------------------------
      """.stripMargin)

    val (resultContext, steps) = FactEngine.runDebugDerivations(initialContext, new ExampleDerivation().berekeningen)

    println(PrettyPrinter.printSteps(steps))

    println("Results are: ")
    println(PrettyPrinter.printContext(resultContext))
  }

}
