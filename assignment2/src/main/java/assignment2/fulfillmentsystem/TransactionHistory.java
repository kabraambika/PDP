package assignment2.fulfillmentsystem;

import assignment2.pickupsystem.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class keeps online pickup orders history. A map is used for each customer a list of receipts
 * is stored.
 *
 * @author kabraambika19
 */
public class TransactionHistory {

  private Map<Customer, List<Receipt>> transactions;

  /**
   * Constructor of class TransactionHistory, internally initializing a transactions map
   */
  public TransactionHistory() {
    this.transactions = new HashMap<>();
  }

  /**
   * @return this.transactions
   */
  public Map<Customer, List<Receipt>> getTransactions() {
    return this.transactions;
  }

  /**
   * Add an entry in map of transactions, if customer is already exists then add receipt in its list
   * of receipts
   *
   * @param customer Supermarket customer, represented as Customer
   * @param receipt  represented as Receipt
   */
  public void addTransactionsHistory(Customer customer, Receipt receipt) {
    if (!this.getTransactions().containsKey(customer)) {
      this.getTransactions().put(customer, new ArrayList<>());
    }
    List<Receipt> receiptList = this.getTransactions().get(customer);
    receiptList.add(receipt);
    this.getTransactions().put(customer, receiptList);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TransactionHistory that = (TransactionHistory) obj;
    return Objects.equals(this.getTransactions(), that.getTransactions());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getTransactions());
  }

  @Override
  public String toString() {
    return "TransactionHistory{" +
        "transactions=" + this.getTransactions() +
        '}';
  }

}
