package assignment1.problem3;

import static assignment1.problem3.TaxCalculatorConstants.GRP_INCOME_90000;
import static assignment1.problem3.TaxCalculatorConstants.GRP_MAX_INTEREST;
import static assignment1.problem3.TaxCalculatorConstants.GRP_MIN_INTEREST;
import static assignment1.problem3.TaxCalculatorConstants.GRP_RET_CONT;
import static assignment1.problem3.TaxCalculatorConstants.HEALTH_RET_CON;
import static assignment1.problem3.TaxCalculatorConstants.MAX_CHILD_DEDUCT;
import static assignment1.problem3.TaxCalculatorConstants.MAX_CHILD_EXP;
import static assignment1.problem3.TaxCalculatorConstants.MIN_EARN_INCOME;
import static assignment1.problem3.TaxCalculatorConstants.ZERO_TAX_INCOME;

import java.util.Objects;

/**
 * A kind of tax filer, extends Abstract tax filer
 * @author Ambika Kabra, kabraambika19
 */
public abstract class GroupFiler extends AbstractTaxFiler {

  /**
   * MIN_VAL 0 constant
   */
  private static final Double MIN_VAL = 0.0;
  private Integer numDependent;
  private Integer numChild;
  private Double childCareExp;
  private Double depCareExp;

  /**
   * Constructor of GroupFiler class
   * @param taxID                   a unique tax filer identifier, represented as a String
   * @param contactInfo             represented as a ContactInfo, a custom class
   * @param lastYrEarning           Last year earnings, represented as a Double
   * @param totalTaxPaid     Total income tax already paid, represented as a Double
   * @param mortIntPaid    Mortgage interest paid, represented as a Double
   * @param propertyIntPaid    Property taxes paid, represented as a Double
   * @param studLoanPaid Student loan and tuition paid, represented as a Double
   * @param retSavAccount    Contributions made to a retirement savings account, represented as
   *                                a Double
   * @param healthAccount        Contributions made to a health savings account, represented as a
   *                                Double
   * @param donationContrib   Charitable donations and contributions, represented as a Double
   * @param numChild        Number of minor children, represented as an Integer
   * @param numDependent      Number of dependents, represented as an Integer
   * @param childCareExp       Childcare expenses, represented as a Double
   * @param depCareExp   Dependent-care expenses, represented as a Double
   */
  protected GroupFiler(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortIntPaid, Double propertyIntPaid,
      Double studLoanPaid, Double retSavAccount, Double healthAccount,
      Double donationContrib, Integer numDependent,
      Integer numChild, Double childCareExp, Double depCareExp) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount,
        donationContrib);
    this.numChild = numChild;
    this.numDependent = numDependent;
    this.childCareExp = childCareExp;
    this.depCareExp = depCareExp;
  }

  /**
   * @return this.numDependent
   */
  public Integer getNumDependent() {
    return this.numDependent;
  }

  /**
   * @return this.numChild
   */
  public Integer getNumChild() {
    return this.numChild;
  }

  /**
   * @return this.childCareExp
   */
  public Double getChildCareExp() {
    return this.childCareExp;
  }

  /**
   * @return this.depCareExp
   */
  public Double getDepCareExp() {
    return this.depCareExp;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    GroupFiler that = (GroupFiler) obj;
    return Objects.equals(this.getNumDependent(), that.getNumDependent())
        && Objects.equals(this.getNumChild(), that.getNumChild()) && Objects.equals(
        this.getChildCareExp(), that.getChildCareExp()) && Objects.equals(this.getDepCareExp(),
        that.getDepCareExp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getNumDependent(), this.getNumChild(), this.getChildCareExp(),
        getDepCareExp());
  }

  @Override
  public String toString() {
    return "GroupFiler{" +
        "numDependent=" + this.getNumDependent() +
        ", numChild=" + this.getNumChild() +
        ", childCareExp=" + this.getChildCareExp() +
        ", depCareExp=" + this.getDepCareExp() +
        '}';
  }

  /**
   * Calculate current taxable income for group and individual tax filers by subtracting the retirement and health savings deduction
   * @param currentTaxAmt basic taxable income
   * @return current taxable income after reduction for any tax filer
   */
  protected Double calculateTaxOnHealthRetirement(Double currentTaxAmt) {

    Double healthRetSav = this.getHealthAccount() + this.getRetSavAccount();

    healthRetSav = healthRetSav * GRP_RET_CONT;

    if (healthRetSav > HEALTH_RET_CON) {
      healthRetSav = HEALTH_RET_CON;
    }

    if(healthRetSav > currentTaxAmt) {
      return ZERO_TAX_INCOME;
    } else {
      return currentTaxAmt - healthRetSav;
    }
  }

  /**
   * Calculate current taxable income for group tax filers by subtracting the Childcare deduction.
   * @param currentTaxAmt current taxable income for group tax files after reduction of mortgage interest and property tax deduction
   * @return current taxable income after reduction for group tax filers
   */
  protected Double calculateTaxIncomeAfterChildcare(Double currentTaxAmt){
    Double newTaxAmt = currentTaxAmt;
    if(lastYrEarning < MIN_EARN_INCOME && this.getChildCareExp() > MAX_CHILD_EXP){
      newTaxAmt -= MAX_CHILD_DEDUCT;
    }

    return newTaxAmt;
  }

  /**
   * @param currentTaxAmt current taxable income for previous reduction
   * @return the tax amount is calculated by taking the resulting taxable income
   */
  protected Double calculateFinalTaxableIncome(Double currentTaxAmt){
    Double taxAmount = MIN_VAL;

    if (currentTaxAmt <= GRP_INCOME_90000) {
      taxAmount = currentTaxAmt * GRP_MIN_INTEREST;
    } else {
      taxAmount = currentTaxAmt * GRP_MAX_INTEREST;
    }

    return taxAmount;
  }
}
