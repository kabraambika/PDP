package assignment1.problem1;

import java.util.Objects;

/**
 * A frequent flyer is an individual with:
 * A unique account ID, which is a 12-character long String
 * A name, consisting of first, middle and last name
 * An email address, and miles balance
 * @author Ambika Kabra, kabraambika19
 */
public class FrequentFlyerCustomer extends AbstractFrequentFlyer {
  private String accountID;
  private FrequentFlyerName name;
  private String email;
  private MilesBalance milesBalance;
  /**
   * Minimum Deposit amount 1000
   */
  private static final int MIN_AMT = 1_000;
  /**
   * Maximum Deposit amount 10000
   */
  private static final int MAX_AMT = 10_000;
  /**
   * @param accountID A unique account ID, which is a 12-character long String
   * @param name A name, consisting of first, middle and last name
   * @param email An email address
   * @param milesBalance A miles balance
   */
  public FrequentFlyerCustomer(String accountID, FrequentFlyerName name, String email,
      MilesBalance milesBalance) throws InvalidCustomerException {
    super();
    if(this.validateCustomer(accountID, name)) {
      this.accountID = accountID;
      this.name = name;
      this.email = email;
      this.milesBalance = milesBalance;
    }
    else {
      throw new InvalidCustomerException("Invalid customer details !");
    }

  }

  /**
   * @param accountID String, Frequent flyer account id
   * @param name FrequentFlyerName object
   * @return isValidAccountID - has 12 char or not and ID shouldn't be existing and has characters only
   *         and hasValidName - has either first name, middle name or last name
   */
  private boolean validateCustomer(String accountID, FrequentFlyerName name) {
    boolean isValidAccountID = this.validAccountID(accountID);
    boolean hasValidName = this.validName(name);

    return isValidAccountID && hasValidName;
  }

  /**
   * @param name FrequentFlyerName object
   * @return has either first name, middle name or last name
   */
  private boolean validName(FrequentFlyerName name) {
    if(name == null) {
      return false;
    }

    Boolean hasFirstName = name.getFirstName().length() > 0;
    Boolean hasMidName = name.getMiddleName().length() > 0;
    Boolean hasLastName = name.getLastName().length() > 0;
    return hasFirstName || hasMidName || hasLastName;
  }

  /**
   * @param accountID A unique account ID, which is a 12-character long String.
   * @return has 12 char or not and ID shouldn't be existing and has characters only
   */
  private boolean validAccountID(String accountID) {
    boolean has12CharLen = accountID != null && accountID.length() == 12;
    boolean doesIDExists = isExistingCustomer(accountID);
    return has12CharLen && !doesIDExists;
  }

  /**
   * @return this.accountID
   */
  public String getAccountID() {
    return this.accountID;
  }

  /**
   * @return this.name
   */
  public FrequentFlyerName getName() {
    return this.name;
  }
  /**
   * @return this.email
   */
  public String getEmail() {
    return this.email;
  }
  /**
   * @return this.milesBalance
   */
  public MilesBalance getMilesBalance() {
    return this.milesBalance;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    FrequentFlyerCustomer that = (FrequentFlyerCustomer) obj;
    return Objects.equals(getAccountID(), that.getAccountID()) && Objects.equals(
        getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail())
        && Objects.equals(getMilesBalance(), that.getMilesBalance());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAccountID(), getName(), getEmail(), getMilesBalance());
  }

  @Override
  public String toString() {
    return "FrequentFlyerCustomer{" +
        "accountID='" + getAccountID() + '\'' +
        ", name=" + getName() +
        ", email='" + getEmail() + '\'' +
        ", milesBalance=" + getMilesBalance() +
        '}';
  }

  /**
   * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
   */
  @Override
  public void depositMilesBalance(Integer depositAmount) {

      if(MIN_AMT <=  depositAmount && depositAmount <= MAX_AMT){
        MilesBalance existingMiles = getMilesBalance();
        int totalMileAvl = existingMiles.getTotalMileAvl() + depositAmount;
        int milesEarnCurrYr = existingMiles.getMilesEarnCurrYr() + depositAmount;
        int mileExpCurrYr = existingMiles.getMileExpCurrYr() + depositAmount;

        updateMilesBalance(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
      }
      else {
        throw new InvalidDepositException("Invalid deposit amount!");
      }
  }

  /**
   * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
   */
  @Override
  public void withdrawMilesBalance(Integer depositAmount) {
    if(depositAmount > 0){
      MilesBalance existingMiles = getMilesBalance();
      int totalMileAvl = existingMiles.getTotalMileAvl() - depositAmount;
      int milesEarnCurrYr = existingMiles.getMilesEarnCurrYr() - depositAmount;
      int mileExpCurrYr = existingMiles.getMileExpCurrYr() - depositAmount;

      updateMilesBalance(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
    }
  }

  /**
   * @param deposit Deposit consists of: Deposit amount that is in the range [1000 to 10000] miles.
   *                The information about the recipient unique account ID, and their name.
   */
  @Override
  public void transferMiles(Deposit deposit) throws InvalidDepositException{
    if(deposit != null && hasCustomerAmount(deposit.getDepositAmount()) && validateDeposit(deposit)){
      updateDetails(deposit);
      updateRecipientCustomer(deposit);
    }
    else {
      throw new InvalidDepositException("Invalid deposit either amount or recipient information!");
    }
  }

  /**
   * @param depositAmount miles balances want to transfer to another flyer customer
   * @return has balance or not
   */
  private boolean hasCustomerAmount(Integer depositAmount) {
    return getMilesBalance() != null && depositAmount != null && getMilesBalance().getTotalMileAvl() >= depositAmount;
  }

  /**
   * @param deposit Deposit consists of:
   *                Deposit amount that is in the range [1000 to 10000] miles.
   *                The information about the recipient unique account ID, and their name.
   */
  private void updateDetails(Deposit deposit){
    this.withdrawMilesBalance(deposit.getDepositAmount());
    updateCustomer(this);
  }
  /**
   * Updates the miles balance for this customer
   * @param totalMileAvl An integer value, representing total miles available
   * @param milesEarnCurrYr An integer value, representing miles earned this year,
   * @param mileExpCurrYr An integer value, representing miles expiring by the end of this calendar year.
   */
  private void updateMilesBalance(int totalMileAvl, int milesEarnCurrYr, int mileExpCurrYr){
    this.milesBalance = new MilesBalance(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
  }
}
