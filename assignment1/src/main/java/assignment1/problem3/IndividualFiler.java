package assignment1.problem3;
import java.util.Objects;

/**
 * A type of tax filer, IndividualFiler which extends AbstractTaxFiler
 * @author Ambika kabra, kabraambika19
 */
public class IndividualFiler extends AbstractTaxFiler{
  private IndividualFilerType indFilerType;

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
   * @param indFilerType     Type of Individual Filer, represented as an enum IndividualFilerType
   */
  public IndividualFiler(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortgageIntPaid, Double propertyIntPaid,
      Double studLoanPaid, Double retSavAccount, Double healthAccount,
      Double donationContrib, IndividualFilerType indFilerType) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount,
        donationContrib);
    this.indFilerType = indFilerType;
  }

  /**
   * @return this.indFilerType
   */
  public IndividualFilerType getIndFilerType() {
    return this.indFilerType;
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
    IndividualFiler that = (IndividualFiler) obj;
    return getIndFilerType() == that.getIndFilerType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getIndFilerType());
  }

  @Override
  public String toString() {
    return "IndividualFiler{" +
        "indFilerType=" + getIndFilerType() +
        '}';
  }

  /**
   * @return tax amount of current individual tax filer
   */
  @Override
  public Double calculateTaxes() {
    Double basicTaxIncome = calculateCurrentTaxable();
    Double taxableAfterRed = calculateTaxOnHealthRetirement(basicTaxIncome, Boolean.FALSE);
    Double taxableAfterMort = calculateTaxOnMortgagePropertyIn(taxableAfterRed);
    return calculateFinalTaxableIncome(taxableAfterMort, Boolean.FALSE);
  }
}
