package assignment1.problem3;
import static assignment1.problem3.TaxCalculatorConstants.IND_INCOME_55000;
import static assignment1.problem3.TaxCalculatorConstants.IND_MAX_INTEREST;
import static assignment1.problem3.TaxCalculatorConstants.IND_MIN_INTEREST;
import static assignment1.problem3.TaxCalculatorConstants.IND_POINT_7;
import static assignment1.problem3.TaxCalculatorConstants.ZERO_TAX_INCOME;

import java.util.Objects;

/**
 * A type of tax filer, IndividualFiler which extends AbstractTaxFiler
 * @author Ambika kabra, kabraambika19
 */
public abstract class IndividualFiler extends AbstractTaxFiler{

  /**
   * MIN_VAL 0 constant
   */
  private static final Double MIN_VAL =0.0;

  /**
   * @param taxID                   a unique tax filer identifier, represented as a String
   * @param contactInfo             represented as a ContactInfo, a custom class
   * @param lastYrEarning           Last year earnings, represented as a Double
   * @param totalTaxPaid     Total income tax already paid, represented as a Double
   * @param mortgageIntPaid    Mortgage interest paid, represented as a Double
   * @param propertyIntPaid    Property taxes paid, represented as a Double
   * @param studLoanPaid Student loan and tuition paid, represented as a Double
   * @param retSavAccount    Contributions made to a retirement savings account, represented as
   *                                a Double
   * @param healthAccount        Contributions made to a health savings account, represented as a
   *                                Double
   * @param donationContrib   Charitable donations and contributions, represented as a Double
   */
  protected IndividualFiler(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortgageIntPaid, Double propertyIntPaid,
      Double studLoanPaid, Double retSavAccount, Double healthAccount,
      Double donationContrib) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount,
        donationContrib);
  }

  /**
   * Calculate current taxable income for group and individual tax filers by subtracting the retirement and health savings deduction
   * @param currentTaxAmt basic taxable income
   * @return current taxable income after reduction for any tax filer
   */
  protected Double calculateTaxOnHealthRetirement(Double currentTaxAmt) {
    Double healthRetSav = this.getHealthAccount() + this.getRetSavAccount();

    healthRetSav = healthRetSav * IND_POINT_7;

    if(healthRetSav > currentTaxAmt) {
      return ZERO_TAX_INCOME;
    } else {
      return currentTaxAmt - healthRetSav;
    }
  }

  /**
   * @param currentTaxAmt current taxable income for previous reduction
   * @return the tax amount is calculated by taking the resulting taxable income
   */
  protected Double calculateFinalTaxableIncome(Double currentTaxAmt){

    Double taxAmount = MIN_VAL;
    if (currentTaxAmt <= IND_INCOME_55000) {
      taxAmount = currentTaxAmt * IND_MIN_INTEREST;
    } else {
      taxAmount = currentTaxAmt * IND_MAX_INTEREST;
    }
    return taxAmount;
  }
}
