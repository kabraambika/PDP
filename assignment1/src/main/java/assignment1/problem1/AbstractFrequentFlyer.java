package assignment1.problem1;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for Frequent flyer which implements interface IFrequentFlyer
 */
public abstract class AbstractFrequentFlyer implements IFrequentFlyer{

  /**
   * HashMap of all the frequent flyer customers stored as accountID and FrequentFlyerCustomer in pair
   */
  private Map<String, FrequentFlyerCustomer> customers = new HashMap<>();
  /**
   * Minimum Deposit amount 1000
   */
  private static final Double MIN_AMT = 1_000.0;
  /**
   * Maximum Deposit amount 10000
   */
  private static final Double MAX_AMT = 10_000.0;

  /**
   * Constructor of AbstractFrequentFlyer
   */
  protected AbstractFrequentFlyer() { }

  /**
   * Private function with returns list of customers
   * @return this.customers
   */
  private Map<String, FrequentFlyerCustomer> getCustomers() {
    return this.customers;
  }

  /**
   * Valid deposit amount and recipient
   * @param deposit Deposit consists of:
   *                Deposit amount that is in the range [1000 to 10000] miles.
   *                The information about the recipient unique account ID, and their name.
   * @return boolean , is valid amount or not and recipient exists or not
   */
  protected boolean validateDeposit(Deposit deposit) {
    boolean validAmount = validateDepositAmount(deposit.getDepositAmount());
    boolean validRecipient = isValidRecipient(deposit.getRecipientAccID(), deposit.getRecipientAccName());
    return validAmount && validRecipient;
  }

  /**
   * Validate deposit amount
   * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
   * @return boolean, whether amount in between the range or not
   */
  private boolean validateDepositAmount(Integer depositAmount) {
    return MIN_AMT <= depositAmount && depositAmount <= MAX_AMT;
  }
  /**
   * validate deposit recipient ID and name
   * @param rcptAccID recipient account ID, represented as String
   * @param recipientName recipient Name, represented as FrequentFlyerName
   * @return boolean, whether recipient is an existing customer or not and recipient name matches with saved name
   */
  private boolean isValidRecipient(String rcptAccID, FrequentFlyerName recipientName) {
    boolean isValidRcptID = isExistingCustomer(rcptAccID);
    boolean isValidRcptName =
        isValidRcptID && validateRecipientName(rcptAccID, recipientName);
    return isValidRcptID && isValidRcptName;
  }

  /**
   * check if account ID exists
   * @param accID Account ID
   * @return return whether this account ID exists in map of customers
   */
  protected boolean isExistingCustomer(String accID){
    return getCustomers().containsKey(accID);
  }
  /**
   * validate recipient name
   * @param rcptAccID recipient account ID, represented as String
   * @param recipientName recipient Name, represented as FrequentFlyerName
   * @return recipient name matches with saved name
   */
  private boolean validateRecipientName(String rcptAccID, FrequentFlyerName recipientName){
    FrequentFlyerCustomer recipient = getCustomers().get(rcptAccID);
    return recipient.getName().equals(recipientName);
  }

  /**
   * This method update the customer in map of all customers
   * @param customer Frequent flyer customer
   */
  protected void updateCustomer(FrequentFlyerCustomer customer){
    getCustomers().put(customer.getAccountID(), customer);
  }

  /**
   * This method deposits miles balance in recipient account and update the recipient customer in map of all customers
   * @param deposit Consists of deposit amount, recipient id, recipient name
   */
  protected void updateRecipientCustomer(Deposit deposit){
    FrequentFlyerCustomer recCustomer = getCustomers().get(deposit.getRecipientAccID());
    recCustomer.depositMilesBalance(deposit.getDepositAmount());
    updateCustomer(recCustomer);
  }
}
