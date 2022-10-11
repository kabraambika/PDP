package assignment1.problem3;

import java.util.Objects;

/**
 * A kind of tax filer, extends Abstract tax filer
 * @author Ambika Kabra, kabraambika19
 */
public class GroupFiler extends AbstractTaxFiler{
  private GroupFilerType grpFilerType;
  private Integer numDependent;
  private Integer numChild;
  private Double childCareExp;
  private Double depCareExp;

  /**
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
   * @param grpFilerType          Type of group file, represented as a GroupFilerType enum
   * @param numChild        Number of minor children, represented as an Integer
   * @param numDependent      Number of dependents, represented as an Integer
   * @param childCareExp       Childcare expenses, represented as a Double
   * @param depCareExp   Dependent-care expenses, represented as a Double
   */
  public GroupFiler(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortIntPaid, Double propertyIntPaid,
      Double studLoanPaid, Double retSavAccount, Double healthAccount,
      Double donationContrib, GroupFilerType grpFilerType, Integer numDependent,
      Integer numChild, Double childCareExp, Double depCareExp) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount,
        donationContrib);
    this.grpFilerType = grpFilerType;
    this.numChild = numChild;
    this.numDependent = numDependent;
    this.childCareExp = childCareExp;
    this.depCareExp = depCareExp;
  }

  /**
   * @return this.grpFilerType
   */
  public GroupFilerType getGrpFilerType() {
    return this.grpFilerType;
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
    return getGrpFilerType() == that.getGrpFilerType() && Objects.equals(getNumDependent(),
        that.getNumDependent()) && Objects.equals(getNumChild(), that.getNumChild())
        && Objects.equals(getChildCareExp(), that.getChildCareExp())
        && Objects.equals(getDepCareExp(), that.getDepCareExp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getGrpFilerType(), getNumDependent(), getNumChild(),
        getChildCareExp(), getDepCareExp());
  }

  @Override
  public String toString() {
    return "GroupFiler{" +
        "grpFilerType=" + getGrpFilerType() +
        ", numDependent=" + getNumDependent() +
        ", numChild=" + getNumChild() +
        ", childCareExp=" + getChildCareExp() +
        ", depCareExp=" + getDepCareExp() +
        '}';
  }

  /**
   * @return Tax amount of current group tax filer
   */
  @Override
  public Double calculateTaxes() {
    Double basicIncome = calculateCurrentTaxable();
    Double taxableAfterRed = calculateTaxOnHealthRetirement(basicIncome, Boolean.TRUE);
    Double taxableAfterMort = calculateTaxOnMortgagePropertyIn(taxableAfterRed);
    Double taxableAfterCare = calculateTaxIncomeAfterChildcare(taxableAfterMort, this.getChildCareExp());
    return calculateFinalTaxableIncome(taxableAfterCare, Boolean.TRUE);
  }
}
