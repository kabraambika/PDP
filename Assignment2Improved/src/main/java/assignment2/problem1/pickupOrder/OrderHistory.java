package assignment2.problem1.pickupOrder;

import assignment2.problem1.pickupOrder.Customer;
import assignment2.problem1.pickupOrder.Receipt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OrderHistory {
  private HashMap<Customer, List<Receipt>> transactions;

  public OrderHistory(HashMap<Customer, List<Receipt>> transactions) {
    this.transactions = transactions;
  }

  public OrderHistory() {
    this.transactions = new HashMap<>();
  }

  public HashMap<Customer, List<Receipt>> getTransactions() {
    return this.transactions;
  }

  public void addTransaction(Customer customer, Receipt receipt) {
    if(!isExistingCustomer(customer)) {
      this.getTransactions().put(customer, new ArrayList<Receipt>());
    }
    updateTransactions(customer, receipt);
  }

  private void updateTransactions(Customer customer, Receipt receipt) {
    List<Receipt> receipts = this.getTransactions().get(customer);
    receipts.add(receipt);
    this.getTransactions().put(customer, receipts);
  }

  private boolean isExistingCustomer(Customer customer) {
    return this.getTransactions().containsKey(customer);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderHistory that = (OrderHistory) o;
    return Objects.equals(getTransactions(), that.getTransactions());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTransactions());
  }

  @Override
  public String toString() {
    return "OrderHistory{" +
        "transactions=" + transactions +
        '}';
  }

}
