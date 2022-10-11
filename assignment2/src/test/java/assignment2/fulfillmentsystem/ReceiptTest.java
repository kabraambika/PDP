package assignment2.fulfillmentsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.fulfillmentsystem.Receipt;
import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Beer;
import assignment2.products.Cheese;
import assignment2.products.IProduct;
import assignment2.products.Manufacturer;
import assignment2.products.Shampoo;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTest {
  private AbstractGrocery cheese;
  private AbstractHousehold shampoo;
  private AbstractGrocery beer;
  private Receipt receipt;
  private Double testTotalPricePaid;
  private Map<IProduct, Double> testProductsReceived = new HashMap<>();
  private Map<IProduct, Double> testOutOfStockProducts = new HashMap<>();
  private Map<IProduct, Double> testRemovedProducts = new HashMap<>();

  private Map<IProduct, Double> expProductsReceived = new HashMap<>();
  private Map<IProduct, Double> expOutOfStockProducts = new HashMap<>();
  private Map<IProduct, Double> expRemovedProducts = new HashMap<>();
  @BeforeEach
  void setUp() {
    cheese = new Cheese(new Manufacturer("mac"), "mac cheese", 12.7, 0, 3.0);
    beer = new Beer(null, "Corona light", 18.39, 21, 12.0);
    shampoo = new Shampoo(null, "Head&Shoulders", 25.8, 0, 1);
    testProductsReceived.put(cheese, 1.0);
    testOutOfStockProducts.put(shampoo, 1.0);
    testRemovedProducts.put(beer, 1.0);

    expProductsReceived.put(cheese, 1.0);
    expOutOfStockProducts.put(shampoo, 1.0);
    expRemovedProducts.put(beer, 1.0);
    receipt = new Receipt(56.89, testProductsReceived, testOutOfStockProducts, testRemovedProducts);
  }

  @Test
  void getTotalPricePaid() {
    assertEquals(56.89, receipt.getTotalPricePaid());
  }

  @Test
  void getProductsReceived() {
    assertEquals(expProductsReceived, receipt.getProductsReceived());
  }

  @Test
  void getOutOfStockProducts() {
    assertEquals(expOutOfStockProducts, receipt.getOutStockProducts());
  }

  @Test
  void getRemovedProducts() {
    assertEquals(expRemovedProducts, receipt.getRemovedProducts());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(receipt.equals(receipt));
  }

  @Test
  void testEquals_null() {
    assertFalse(receipt.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(receipt.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    Receipt dupReceipt = new Receipt(56.89, expProductsReceived, expOutOfStockProducts, expRemovedProducts);
    assertTrue(receipt.equals(dupReceipt));
  }

  @Test
  void testEquals_DiffTotal() {
    Receipt dupReceipt = new Receipt(56.00, expProductsReceived, expOutOfStockProducts, expRemovedProducts);
    assertFalse(receipt.equals(dupReceipt));
  }

  @Test
  void testEquals_DiffReceived() {
    Receipt dupReceipt = new Receipt(56.89, expOutOfStockProducts, expOutOfStockProducts, expRemovedProducts);
    assertFalse(receipt.equals(dupReceipt));
  }

  @Test
  void testEquals_DiffOutOfStock() {
    Receipt dupReceipt = new Receipt(56.89, expProductsReceived, expProductsReceived, expRemovedProducts);
    assertFalse(receipt.equals(dupReceipt));
  }

  @Test
  void testEquals_DiffRemoved() {
    Receipt dupReceipt = new Receipt(56.89, expProductsReceived, expOutOfStockProducts, expOutOfStockProducts);
    assertFalse(receipt.equals(dupReceipt));
  }

  @Test
  void testHashCode() {
    int expHash = Objects.hash(56.89, expProductsReceived, expOutOfStockProducts, expRemovedProducts);
    assertEquals(expHash, receipt.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Receipt{" +
        "totalPricePaid=" + 56.89 +
        ", productsReceived=" + expProductsReceived +
        ", outStockProducts=" + expOutOfStockProducts +
        ", removedProducts=" + expRemovedProducts +
        '}';
    assertEquals(expString, receipt.toString());
  }
}