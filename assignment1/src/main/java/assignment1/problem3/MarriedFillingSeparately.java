package assignment1.problem3;

/**
 * MarriedFillingSeparately is a class for Married, filling separately group filer.
 * This class is extending GroupFiler
 * @author Kabraambika19
 */
public class MarriedFillingSeparately extends GroupFiler {

  /**
   * Constructor of MarriedFillingSeparately class
   * @param taxID           a unique tax filer identifier, represented as a String
   * @param contactInfo     represented as a ContactInfo, a custom class
   * @param lastYrEarning   Last year earnings, represented as a Double
   * @param totalTaxPaid    Total income tax already paid, represented as a Double
   * @param mortIntPaid     Mortgage interest paid, represented as a Double
   * @param propertyIntPaid Property taxes paid, represented as a Double
   * @param studLoanPaid    Student loan and tuition paid, represented as a Double
   * @param retSavAccount   Contributions made to a retirement savings account, represented as a
   *                        Double
   * @param healthAccount   Contributions made to a health savings account, represented as a Double
   * @param donationContrib Charitable donations and contributions, represented as a Double
   * @param numDependent    Number of dependents, represented as an Integer
   * @param numChild        Number of minor children, represented as an Integer
   * @param childCareExp    Childcare expenses, represented as a Double
   * @param depCareExp      Dependent-care expenses, represented as a Double
   */
  public MarriedFillingSeparately(String taxID, ContactInfo contactInfo, Double lastYrEarning,
      Double totalTaxPaid, Double mortIntPaid, Double propertyIntPaid, Double studLoanPaid,
      Double retSavAccount, Double healthAccount, Double donationContrib, Integer numDependent,
      Integer numChild, Double childCareExp, Double depCareExp) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortIntPaid, propertyIntPaid,
        studLoanPaid,
        retSavAccount, healthAccount, donationContrib, numDependent, numChild, childCareExp,
        depCareExp);
  }

  /**
   * Calculate tax amount for married, filling separately group type
   * @return Tax amount, Double
   */
  @Override
  public Double calculateTaxes() {
    Double basicIncome = super.calculateCurrentTaxable();
    Double taxableAfterRed = super.calculateTaxOnHealthRetirement(basicIncome);
    Double taxableAfterMort = super.calculateTaxOnMortgagePropertyIn(taxableAfterRed);
    Double taxableAfterCare = super.calculateTaxIncomeAfterChildcare(taxableAfterMort);
    return super.calculateFinalTaxableIncome(taxableAfterCare);
  }
}
