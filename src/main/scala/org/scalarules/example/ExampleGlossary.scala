package org.scalarules.example

import org.scalarules.finance.nl._
import org.scalarules.utils.Glossary

/**
  * Contains the facts as used in the ExampleDerivation class.
  */
object ExampleGlossary extends Glossary {

  val BaseIncome = defineFact[Bedrag]
  val TotalPrepaidTaxes = defineFact[Bedrag]
  val TotalPaidHealthCost = defineFact[Bedrag]

  val DefaultPaidHealthCost = defineFact[Bedrag]
  val DefaultMinimumOwedTaxes = defineFact[Bedrag]


  val FlatTaxRate = defineFact[Percentage]
  val HealthCostReimbursementPercentage = defineFact[Percentage]
  val HealthCostReimbursementCeiling = defineFact[Bedrag]


  val BaseIncomeTax = defineFact[Bedrag]
  val BaseHealthCosts = defineFact[Bedrag]
  val HealthCostEligibleForReimbursement = defineFact[Bedrag]
  val TaxesReducedByReimbursements = defineFact[Bedrag]
  val LegallyOwedTaxes = defineFact[Bedrag]

  val ActualHealthCostReimbursement = defineFact[Bedrag]

  // Note: these two definitions demonstrate that Facts can also be defined with an optional description.
  val TaxReturnAmount = defineFact[Bedrag]("Amount you should be receiving from your local Tax agency")
  val TaxDueAmount = defineFact[Bedrag]("Amount you are to be paying to your local Tax agency")

}
