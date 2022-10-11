package assignment2.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Beer;
import assignment2.products.Cheese;
import assignment2.products.Manufacturer;
import assignment2.products.PaperTowel;
import assignment2.products.Shampoo;
import assignment2.stocks.StockItem;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {
  private Inventory inventory;
  private Inventory expInventory;
  private StockItem<AbstractGrocery> testGroceryStock;
  private StockItem<AbstractHousehold> testHouseholdStock;
  private AbstractGrocery beer;
  private Manufacturer manufacturer;
  private Manufacturer shampooManu;
  private AbstractHousehold shampoo;

  @BeforeEach
  void setup(){
    manufacturer = new Manufacturer("Corona");
    beer = new Beer(manufacturer, "Corona light", 18.39, 21, 12.0);
    shampooManu = new Manufacturer("P&G");
    shampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 2);
    expInventory = null;
    inventory = Inventory.getInstance();
  }

  @Test
  void getInstance() {
    assertTrue(inventory.equals(inventory));
  }

  @Test
  void getInstance_Null() {
    assertEquals(inventory, Inventory.getInstance());
  }

  @Test
  void getInstance_NotNull() {
    assertNotEquals(inventory, expInventory);
  }

  @Test
  void getInstance_DiffInstance() {
    assertFalse(inventory.equals(expInventory));
  }

  @Test
  void addNewProduct_SingleBeer() {
    inventory.addNewProduct(beer);
  }

  @Test
  void addNewProduct_2beer() {
    inventory.addNewProduct(beer, 2.0);
  }

  @Test
  void addNewProduct_2Shampoo() {
    inventory.addNewProduct(shampoo, 2.0);
  }

  @Test
  void addNewProduct_Shampoo() {
    inventory.addNewProduct(shampoo);
  }

  @Test
  void validateProductQty_ExceedGroceryQuantity() {
    assertFalse(inventory.validateProductQty(beer, 100.0));
  }

  @Test
  void validateProductQty_ExceedHouseholdQuantity() {
    assertFalse(inventory.validateProductQty(shampoo, 100.0));
  }

  @Test
  void validateProductQty_GroceryQuantity() {
    assertFalse(inventory.validateProductQty(beer, 1.0));
  }

  @Test
  void validateProductQty_HouseholdQuantity() {
    assertTrue(inventory.validateProductQty(shampoo, 1.0));
  }

  @Test
  void similarProduct_GroceryDifferentPrice() {
    AbstractGrocery expBeer = new Beer(manufacturer, "Corona light", 10.39, 21, 12.0);
    assertEquals(null, inventory.similarProduct(expBeer, 1.0));
  }

  @Test
  void similarProduct_Grocery() {
    assertEquals(beer, inventory.similarProduct(beer, 1.0));
  }

  @Test
  void similarProduct_GroceryQtyExcess() {
    assertEquals(null, inventory.similarProduct(beer, 10.0));
  }

  @Test
  void similarProduct_GroceryDifferentProduct() {
    Cheese cheese = new Cheese(new Manufacturer("mac"), "mac cheese", 12.7, 0, 3.0);
    assertEquals(null, inventory.similarProduct(cheese, 10.0));
  }

  @Test
  void similarProduct_GroceryDifferentWeight() {
   AbstractGrocery expBeer = new Beer(manufacturer, "Corona light", 18.39, 21, 1.0);
    assertEquals(beer, inventory.similarProduct(expBeer, 1.0));
  }

  @Test
  void similarProduct_GroceryWeight() {
    AbstractGrocery expBeer = new Beer(manufacturer, "Corona light", 18.39, 21, 120.0);
    assertEquals(null, inventory.similarProduct(expBeer, 1.0));
  }

  @Test
  void similarProduct_Household() {
    assertEquals(shampoo, inventory.similarProduct(shampoo, 1.0));
  }

  @Test
  void similarProduct_HouseholdQtyExcess() {
    assertEquals(null, inventory.similarProduct(shampoo, 10.0));
  }

  @Test
  void similarProduct_HouseholdDifferentProduct() {
    AbstractHousehold paperTowel = new PaperTowel(new Manufacturer("wipes"), "wipes", 13.9, 0, 1);
    assertEquals(null, inventory.similarProduct(paperTowel, 10.0));
  }

  @Test
  void similarProduct_HouseholdDifferentPrice() {
    AbstractHousehold expShampoo = new Shampoo(shampooManu, "Head&Shoulders", 20.8, 0, 1);
    assertEquals(null, inventory.similarProduct(expShampoo, 1.0));
  }

  @Test
  void similarProduct_HouseholdDifferentUnits() {
    AbstractHousehold expShampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 10);
    assertEquals(null, inventory.similarProduct(expShampoo, 1.0));
  }

  @Test
  void decreaseGroceryStock_DifferentBeer() {
    AbstractGrocery expBeer = new Beer(manufacturer, "Corona light", 18.39, 21, 1.0);
    inventory.decreaseGroceryStock(expBeer, 1.0);
  }

  @Test
  void decreaseGroceryStock() {
    inventory.decreaseGroceryStock(beer, 1.0);
  }

  @Test
  void decreaseHouseholdStock() {
    inventory.decreaseHouseholdStock(shampoo, 1.0);
  }

  @Test
  void decreaseHouseholdStock_DiffHousehold() {
    AbstractHousehold expShampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 10);
    inventory.decreaseHouseholdStock(expShampoo, 1.0);
  }

  @Test
  void testHashCode() {
    List<StockItem<AbstractGrocery>> groceryItems = inventory.getGroceryStockItems();
    List<StockItem<AbstractHousehold>> householdItems = inventory.getHouseStockItems();
    int expHashcode = Objects.hash(groceryItems, householdItems);
    assertEquals(expHashcode, inventory.hashCode());
  }
}