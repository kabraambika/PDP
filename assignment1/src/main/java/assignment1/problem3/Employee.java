package assignment1.problem3;

/**
 * Employee is a class for individual tax filer type.
 * This class extends IndividualFiler class.
 * @author kabraambika19
 */
public class Employee extends IndividualFiler {

  /**
   * Constructor of Employee class
   * @param taxID           a unique tax filer identifier, represented as a String
   * @param contactInfo     represented as a ContactInfo, a custom class
   * @param lastYrEarning   Last year earnings, represented as a Double
   * @param totalTaxPaid    Total income tax already paid, represented as a Double
   * @param mortgageIntPaid Mortgage interest paid, represented as a Double
   * @param propertyIntPaid Property taxes paid, represented as a Double
   * @param studLoanPaid    Student loan and tuition paid, represented as a Double
   * @param retSavAccount   Contributions made to a retirement savings account, represented as a
   *                        Double
   * @param healthAccount   Contributions made to a health savings account, represented as a Double
   * @param donationContrib Charitable donations and contributions, represented as a Double
   */
  public Employee(String taxID, ContactInfo contactInfo, Double lastYrEarning, Double totalTaxPaid,
      Double mortgageIntPaid, Double propertyIntPaid, Double studLoanPaid, Double retSavAccount,
      Double healthAccount, Double donationContrib) {
    super(taxID, contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid,
        studLoanPaid, retSavAccount, healthAccount, donationContrib);
  }

  /**
   * Calculate tax amount for employee
   * @return tax amount of tax filer
   */
  @Override
  public Double calculateTaxes() {
    Double basicTaxIncome = super.calculateCurrentTaxable();
    Double taxableAfterRed = super.calculateTaxOnHealthRetirement(basicTaxIncome);
    Double taxableAfterMort = super.calculateTaxOnMortgagePropertyIn(taxableAfterRed);
    return super.calculateFinalTaxableIncome(taxableAfterMort);
  }
}
