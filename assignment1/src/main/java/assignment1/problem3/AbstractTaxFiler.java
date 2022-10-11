package assignment1.problem3;

import static assignment1.problem3.TaxCalculatorConstants.*;

import java.util.Objects;

/**
 * Abstract class for each tax filer type, implemented TaxCalculator
 * @author Ambika Kabra, kabraambika19
 */
public abstract class AbstractTaxFiler implements TaxCalculator {

  /**
   * a unique tax filer identifier, represented as a String
   */
  protected String taxID;
  /**
   * represented as a ContactInfo, a custom class for tax filer contact information
   */
  protected  ContactInfo contactInfo;
  /**
   * Earning of Last year, represented as a Double
   */
  protected Double lastYrEarning;
  /**
   * Total income tax already paid, represented as a Double
   */
  protected Double totalTaxPaid;
  /**
   * Mortgage interest paid, represented as a Double
   */
  protected Double mortgageIntPaid;
  /**
   * Property taxes paid, represented as a Double
   */
  protected Double propertyIntPaid;
  /**
   * Student loan and tuition paid, represented as a Double
   */
  protected Double studLoanPaid;
  /**
   * Contributions made to a retirement savings account, represented as a Double
   */
  protected Double retSavAccount;
  /**
   * Contributions made to a health savings account, represented as a Double
   */
  protected Double healthAccount;
  /**
   * Charitable donations and contributions, represented as a Double
   */
  protected Double donationContrib;

  /**
   * @param taxID a unique tax filer identifier, represented as a String
   * @param contactInfo represented as a ContactInfo, a custom class
   * @param lastYrEarning Last year earnings, represented as a Double
   * @param totalTaxPaid Total income tax already paid, represented as a Double
   * @param mortgageIntPaid Mortgage interest paid, represented as a Double
   * @param propertyIntPaid Property taxes paid, represented as a Double
   * @param studLoanPaid Student loan and tuition paid, represented as a Double
   * @param retSavAccount Contributions made to a retirement savings account, represented as a Double
   * @param healthAccount Contributions made to a health savings account, represented as a Double
   * @param donationContrib Charitable donations and contributions, represented as a Double
   */
  public AbstractTaxFiler(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortgageIntPaid, Double propertyIntPaid,
      Double studLoanPaid, Double retSavAccount, Double healthAccount,
      Double donationContrib) {
    this.taxID = taxID;
    this.contactInfo = contactInfo;
    this.lastYrEarning = lastYrEarning;
    this.totalTaxPaid = totalTaxPaid;
    this.mortgageIntPaid = mortgageIntPaid;
    this.propertyIntPaid = propertyIntPaid;
    this.studLoanPaid = studLoanPaid;
    this.retSavAccount = retSavAccount;
    this.healthAccount = healthAccount;
    this.donationContrib = donationContrib;
  }

  /**
   * @return this.taxID
   */
  public String getTaxID() {
    return this.taxID;
  }

  /**
   * @return this.contactInfo
   */
  public ContactInfo getContactInfo() {
    return this.contactInfo;
  }

  /**
   * @return this.lastYrEarning
   */
  public Double getLastYrEarning() {
    return this.lastYrEarning;
  }

  /**
   * @return this.totalTaxPaid
   */
  public Double getTotalTaxPaid() {
    return this.totalTaxPaid;
  }

  /**
   * @return this.mortgageIntPaid
   */
  public Double getMortgageIntPaid() {
    return this.mortgageIntPaid;
  }

  /**
   * @return this.propertyIntPaid
   */
  public Double getPropertyIntPaid() {
    return this.propertyIntPaid;
  }

  /**
   * @return this.studLoanPaid
   */
  public Double getStudLoanPaid() {
    return this.studLoanPaid;
  }

  /**
   * @return this.retSavAccount
   */
  public Double getRetSavAccount() {
    return this.retSavAccount;
  }

  /**
   * @return this.healthAccount
   */
  public Double getHealthAccount() {
    return this.healthAccount;
  }

  /**
   * @return this.donationContrib;
   */
  public Double getDonationContrib() {
    return this.donationContrib;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractTaxFiler that = (AbstractTaxFiler) obj;
    return Objects.equals(getTaxID(), that.getTaxID()) && Objects.equals(getContactInfo(),
        that.getContactInfo()) && Objects.equals(getLastYrEarning(), that.getLastYrEarning())
        && Objects.equals(getTotalTaxPaid(), that.getTotalTaxPaid())
        && Objects.equals(getMortgageIntPaid(), that.getMortgageIntPaid())
        && Objects.equals(getPropertyIntPaid(), that.getPropertyIntPaid())
        && Objects.equals(getStudLoanPaid(), that.getStudLoanPaid())
        && Objects.equals(getRetSavAccount(), that.getRetSavAccount())
        && Objects.equals(getHealthAccount(), that.getHealthAccount())
        && Objects.equals(getDonationContrib(), that.getDonationContrib());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTaxID(), getContactInfo(), getLastYrEarning(), getTotalTaxPaid(),
        getMortgageIntPaid(),
        getPropertyIntPaid(), getStudLoanPaid(), getRetSavAccount(), getHealthAccount(),
        getDonationContrib());
  }

  @Override
  public String toString() {
    return "AbstractTaxFiler{" +
        "taxID='" + getTaxID() + '\'' +
        ", contactInfo=" + getContactInfo() +
        ", lastYrEarning=" + getLastYrEarning() +
        ", totalTaxPaid=" + getTotalTaxPaid() +
        ", mortgageIntPaid=" + getMortgageIntPaid() +
        ", propertyIntPaid=" + getPropertyIntPaid() +
        ", studLoanPaid=" + getStudLoanPaid() +
        ", retSavAccount=" + getRetSavAccount() +
        ", healthAccount=" + getHealthAccount() +
        ", donationContrib=" + getDonationContrib() +
        '}';
  }

  /**
   * Get basic taxable income by subtracting the amount of income taxes already paid from their last year earnings
   * @return basic taxable income
   */
  protected Double calculateCurrentTaxable(){
    return this.getLastYrEarning() - getTotalTaxPaid();
  }

  /**
   * Calculate current taxable income for group and individual tax filers by subtracting the retirement and health savings deduction
   * @param currentTaxAmt basic taxable income
   * @param isGroup : group-tax filer or not
   * @return current taxable income after reduction for any tax filer
   */
  protected Double calculateTaxOnHealthRetirement(Double currentTaxAmt, Boolean isGroup) {

    Double healthRetSav = this.getHealthAccount() + this.getRetSavAccount();

    if(isGroup){
      healthRetSav = healthRetSav * GRP_RET_CONT;

      if (healthRetSav > HEALTH_RET_CON) {
        healthRetSav = HEALTH_RET_CON;
      }
    } else {
      healthRetSav = healthRetSav * IND_POINT_7;
    }

    if(healthRetSav > currentTaxAmt) {
      return ZERO_TAX_INCOME;
    } else {
      return currentTaxAmt - healthRetSav;
    }
  }

  /**
   * Calculate current taxable income for group and individual tax filers by subtracting the mortgage interest and property tax deduction.
   * @param currentTaxAmt current taxable income after reduction for any tax filer after reduction of retirement and health savings deduction
   * @return current taxable income after reduction for all tax filers
   */
  protected Double calculateTaxOnMortgagePropertyIn(Double currentTaxAmt){

    Double proMrgPaid = this.getPropertyIntPaid() + this.getMortgageIntPaid();
    Double newTaxAmt = currentTaxAmt;
    if(this.getLastYrEarning() < MIN_EARN_MORT && proMrgPaid > MORT_PRO_CONT){
      newTaxAmt -= MORT_PRO_DEDUCT;
    }

    if(newTaxAmt < ZERO_TAX_INCOME){
      newTaxAmt = ZERO_TAX_INCOME;
    }

    return newTaxAmt;
  }

  /**
   * Calculate current taxable income for group tax filers by subtracting the Childcare deduction.
   * @param currentTaxAmt current taxable income for group tax files after reduction of mortgage interest and property tax deduction
   * @param childCareExp Childcare expenses, represented as a Double
   * @return current taxable income after reduction for group tax filers
   */
  protected Double calculateTaxIncomeAfterChildcare(Double currentTaxAmt, Double childCareExp){
    Double newTaxAmt = currentTaxAmt;
    if(lastYrEarning < MIN_EARN_INCOME && childCareExp > MAX_CHILD_EXP){
      newTaxAmt -= MAX_CHILD_DEDUCT;
    }

    return newTaxAmt;
  }

  /**
   * @param currentTaxAmt current taxable income for previous reduction
   * @param isGroup group-tax filer or not
   * @return the tax amount is calculated by taking the resulting taxable income
   */
  protected Double calculateFinalTaxableIncome(Double currentTaxAmt, Boolean isGroup){

    Double taxAmount = null;

    if(isGroup) {
      if (currentTaxAmt <= GRP_INCOME_90000) {
        taxAmount = currentTaxAmt * GRP_MIN_INTEREST;
      } else {
        taxAmount = currentTaxAmt * GRP_MAX_INTEREST;
      }
    } else {
      if (currentTaxAmt <= IND_INCOME_55000) {
        taxAmount = currentTaxAmt * IND_MIN_INTEREST;
      } else {
        taxAmount = currentTaxAmt * IND_MAX_INTEREST;
      }
    }
    return taxAmount;
  }
}
