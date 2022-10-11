package assignment2.pickupsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Beer;
import assignment2.products.Manufacturer;
import assignment2.products.Shampoo;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
  private ShoppingCart testShoppingCart;
  private AbstractGrocery beer1;
  private Manufacturer manufacturer1;
  private Manufacturer shampooManu1;
  private AbstractHousehold shampoo1;

  @BeforeEach
  void setUp() {
    manufacturer1 = new Manufacturer("Corona");
    beer1 = new Beer(manufacturer1, "Corona light", 18.39, 21, 12.0);
    shampooManu1 = new Manufacturer("P&G");
    shampoo1 = new Shampoo(shampooManu1, "Head&Shoulders", 25.8, 0, 2);
    testShoppingCart = new ShoppingCart();
  }

  @Test
  void getGroceryProducts() {
    assertEquals(new HashMap<>(), testShoppingCart.getGroceryProducts());
  }

  @Test
  void getHouseholdProducts() {
    assertEquals(new HashMap<>(), testShoppingCart.getHouseholdProducts());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testShoppingCart.equals(testShoppingCart));
  }

  @Test
  void testEquals_null() {
    assertFalse(testShoppingCart.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testShoppingCart.equals(new String("test")));
  }

  @Test
  void testHashCode() {
    ShoppingCart shoppingCart1 = new ShoppingCart();
    shoppingCart1.addProductInCart(shampoo1);
    ShoppingCart shoppingCart2 = new ShoppingCart();
    shoppingCart2.addProductInCart(shampoo1);

    assertEquals(shoppingCart1.hashCode(), shoppingCart2.hashCode());
  }

  @Test
  void testToString() {
    Map<AbstractGrocery, Double> testGroceryProducts = new HashMap<>();
    Map<AbstractHousehold, Double> testHouseholdProducts = new HashMap<>();
    String expString = "ShoppingCart{" +
        "groceryProducts=" + testGroceryProducts +
        ", householdProducts=" + testHouseholdProducts +
        '}';
    assertEquals(expString, testShoppingCart.toString());
  }

  @Test
  void addProductInCart_OneGrocery() {
    testShoppingCart.addProductInCart(beer1);
    testShoppingCart.addProductInCart(beer1);
  }

  @Test
  void getTotalCost() {
    assertEquals(0.0, testShoppingCart.getTotalCost());
  }

  @Test
  void addProductInCart_MoreGrocery() {
    testShoppingCart.addProductInCart(beer1, 1.0);
  }

  @Test
  void addProductInCart_OneHousehold() {
    testShoppingCart.addProductInCart(shampoo1);
    testShoppingCart.addProductInCart(shampoo1);
  }

  @Test
  void addProductInCart_MoreHousehold() {
    testShoppingCart.addProductInCart(shampoo1, 1.0);
  }

  @Test
  void addProductInCartGrocery_InvalidQty() {
    testShoppingCart.addProductInCart(shampoo1, 100.0);
  }

  @Test
  void addProductInCartHousehold_InvalidQty() {
    testShoppingCart.addProductInCart(beer1, 100.0);
  }
}