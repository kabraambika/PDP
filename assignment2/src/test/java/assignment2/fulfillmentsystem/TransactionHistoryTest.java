package assignment2.fulfillmentsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.fulfillmentsystem.Receipt;
import assignment2.fulfillmentsystem.TransactionHistory;
import assignment2.pickupsystem.Customer;
import assignment2.pickupsystem.CustomerDetails;
import assignment2.pickupsystem.CustomerName;
import assignment2.products.IProduct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionHistoryTest {
  private TransactionHistory history;
  @BeforeEach
  void setUp() {
    history = new TransactionHistory();
  }

  @Test
  void getTransactions() {
    assertEquals(new HashMap<>(), history.getTransactions());
  }

  @Test
  void addTransactionsHistory() {
    Customer amy = new Customer(new CustomerDetails(new CustomerName("Amy", "", ""), 21));
    Receipt receipt = new Receipt(56.89, new HashMap<IProduct, Double>(), new HashMap<IProduct, Double>(), new HashMap<IProduct, Double>());
    history.addTransactionsHistory(amy, receipt);
    history.addTransactionsHistory(amy, receipt);
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(history.equals(history));
  }

  @Test
  void testEquals_null() {
    assertFalse(history.equals(null));
  }

  @Test
  void testEquals_type() {
    assertFalse(history.equals(new String("123")));
  }

  @Test
  void testEquals_Similar() {
    TransactionHistory dupHistory = new TransactionHistory();
    assertTrue(history.equals(dupHistory));
  }

  @Test
  void testHashCode() {
    Customer amy = new Customer(new CustomerDetails(new CustomerName("Amy", "", ""), 21));
    Receipt receipt = new Receipt(56.89, new HashMap<IProduct, Double>(), new HashMap<IProduct, Double>(), new HashMap<IProduct, Double>());
    history.addTransactionsHistory(amy, receipt);
    TransactionHistory dupHistory = new TransactionHistory();
    dupHistory.addTransactionsHistory(amy, receipt);
    int expHash = Objects.hash(dupHistory.getTransactions());

    assertEquals(expHash, history.hashCode());
  }

  @Test
  void testToString() {
    Map<Customer, List<Receipt>> expTrans = new HashMap<>();
    String expString = "TransactionHistory{" +
        "transactions=" + expTrans +
        '}';
    assertEquals(expString, history.toString());
  }
}