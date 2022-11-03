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
   * Constructor of class FrequentFlyerCustomer
   * @param accountID A unique account ID, which is a 12-character long String
   * @param name A name, consisting of first, middle and last name
   * @param email An email address
   * @param milesBalance A miles balance
   * @throws InvalidCustomerException if account ID is not unique then this exception is thrown
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
   * validate customer account id and name
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
   * validate customer name
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
   * Valid account id for customer as if unique or not
   * @param accountID A unique account ID, which is a 12-character long String.
   * @return has 12 char or not and ID shouldn't be existing and has characters only
   */
  private boolean validAccountID(String accountID) {
    boolean has12CharLen = accountID != null && accountID.length() == 12;
    boolean doesIDExists = isExistingCustomer(accountID);
    return has12CharLen && !doesIDExists;
  }

  /**
   * getter of accountID
   * @return this.accountID
   */
  public String getAccountID() {
    return this.accountID;
  }

  /**
   * getter of name
   * @return this.name
   */
  public FrequentFlyerName getName() {
    return this.name;
  }
  /**
   * getter of email
   * @return this.email
   */
  public String getEmail() {
    return this.email;
  }
  /**
   * getter of milesBalance
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
   * Deposit miles balance with given deposit amount of miles balance
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
   * Withdraw deposit amount from sender
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
   * Transfer deposit amount with given deposit information
   * @param deposit Deposit consists of: Deposit amount that is in the range [1000 to 10000] miles.
   *                The information about the recipient unique account ID, and their name.
   * @throws InvalidDepositException if deposit is null or sender is not depositing amount in range or doesn't has amount,
   *                                 exception will be thrown
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
   * check if customer [Sender] has amount equal miles balance to transfer deposit
   * @param depositAmount miles balances want to transfer to another flyer customer
   * @return has balance or not
   */
  private boolean hasCustomerAmount(Integer depositAmount) {
    return getMilesBalance() != null && depositAmount != null && getMilesBalance().getTotalMileAvl() >= depositAmount;
  }

  /**
   * Update miles balance of sender
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
