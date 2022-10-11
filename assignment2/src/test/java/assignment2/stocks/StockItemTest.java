package assignment2.stocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Beer;
import assignment2.products.Cheese;
import assignment2.products.Manufacturer;
import assignment2.products.Shampoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockItemTest {
  private StockItem<AbstractGrocery> testGroceryStock;
  private StockItem<AbstractHousehold> testHouseholdStock;
  private AbstractGrocery beer;
  private AbstractGrocery expBeer;
  private Manufacturer manufacturer;
  private AbstractHousehold shampoo;
  private AbstractHousehold expShampoo;
  private Manufacturer shampooManu;
  @BeforeEach
  void setUp() {
    manufacturer = new Manufacturer("Corona");
    beer = new Beer(manufacturer, "Corona light", 18.39, 21, 12.0);
    expBeer = new Beer(manufacturer, "Corona light", 18.39, 21, 12.0);
    shampooManu = new Manufacturer("P&G");
    shampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 1);
    expShampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 1);
    testGroceryStock = new StockItem<>(beer, 2.0);
    testHouseholdStock = new StockItem<>(null, 0.0);
  }

  @Test
  void getProduct() {
    assertEquals(expBeer, testGroceryStock.getProduct());
  }

  @Test
  void getQuantity() {
    assertEquals(2.0, testGroceryStock.getQuantity());
  }

  @Test
  void setProduct() {
    testHouseholdStock.setProduct(shampoo);
    assertEquals(expShampoo, testHouseholdStock.getProduct());
  }

  @Test
  void setQuantity() {
    testHouseholdStock.setQuantity(1.0);
    assertEquals(1.0, testHouseholdStock.getQuantity());
  }

  @Test
  void hasEnoughItems_MoreQuantity() {
    assertFalse(testGroceryStock.hasEnoughItems(beer, 100.0));
  }

  @Test
  void hasEnoughItems_one() {
    assertTrue(testGroceryStock.hasEnoughItems(beer));
  }

  @Test
  void hasEnoughItems_2Qty() {
    assertTrue(testGroceryStock.hasEnoughItems(beer, 2.0));
  }

  @Test
  void hasEnoughItems_DiffProd() {
    Cheese cheese = new Cheese(new Manufacturer("mac"), "mac cheese", 12.7, 0, 3.0);
    assertFalse(testGroceryStock.hasEnoughItems(cheese, 2.0));
  }

  @Test
  void testToString() {
    String expString = "StockItem{" +
        "product=" + expBeer +
        ", quantity=" + 2.0 +
        '}';
    assertEquals(expString, testGroceryStock.toString());
  }

  @Test
  void reduceQuantity_One() {
    testGroceryStock.reduceQuantity(beer, 1.0);
  }

  @Test
  void reduceQuantity_NoParameter() {
    testGroceryStock.reduceQuantity(beer);
  }

  @Test
  void reduceQuantity_DifferentProduct() {
    Cheese cheese = new Cheese(new Manufacturer("mac"), "mac cheese", 12.7, 0, 3.0);
    testGroceryStock.reduceQuantity(cheese);
  }

  @Test
  void reduceQuantity_InvalidQty() {
    try {
      QuantityExceededException ex = assertThrows(QuantityExceededException.class, () -> {
        testGroceryStock.reduceQuantity(beer, 100.0);
      });
    } catch (QuantityExceededException ex) {
      assertEquals("100.0 quantity needed is greater than quantity available 2.0", ex.getMessage());
    }
  }
}