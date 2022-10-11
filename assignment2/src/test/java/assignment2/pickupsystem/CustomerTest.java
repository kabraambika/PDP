package assignment2.pickupsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment2.inventory.Inventory;
import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Beer;
import assignment2.products.Manufacturer;
import assignment2.products.Shampoo;
import java.util.Objects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
  private CustomerDetails testCustomerDetails;
  private CustomerDetails expCustomerDetails;
  private Customer testCustomer;
  private static Inventory inventory;
  private static AbstractGrocery beer;
  private static Manufacturer manufacturer;
  private static Manufacturer shampooManu;
  private static AbstractHousehold shampoo;

  @BeforeAll
  static void addInventory() {
    manufacturer = new Manufacturer("Corona");
    beer = new Beer(manufacturer, "Corona light", 18.39, 21, 12.0);
    shampooManu = new Manufacturer("P&G");
    shampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 2);
    inventory = Inventory.getInstance();
    inventory.addNewProduct(beer, 5.0);
    inventory.addNewProduct(shampoo, 5.0);
  }

  @BeforeEach
  void setUp() {
    testCustomerDetails = new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 21);
    expCustomerDetails = new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 21);
    testCustomer = new Customer(testCustomerDetails);
  }

  @Test
  void getCustomerDetails() {
    assertEquals(expCustomerDetails, testCustomer.getCustomerDetails());
  }

  @Test
  void getCart() {
    assertEquals(new ShoppingCart(), testCustomer.getCart());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCustomer.equals(testCustomer));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testCustomer.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testCustomer.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    Customer dupCustomer = new Customer(new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 21));
    assertTrue(testCustomer.equals(dupCustomer));
  }

  @Test
  void testEquals_DiffName() {
    Customer dupCustomer = new Customer(new CustomerDetails(new CustomerName("Amy", "J", ""), 21));
    assertFalse(testCustomer.equals(dupCustomer));
  }

  @Test
  void testEquals_diffAge() {
    Customer dupCustomer = new Customer(new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 28));
    assertFalse(testCustomer.equals(dupCustomer));
  }

  @Test
  void testHashCode() {
    int expHash = Objects.hash(new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 21), new ShoppingCart());
    assertEquals(expHash, testCustomer.hashCode());
  }

  @Test
  void testToString() {
    CustomerDetails details = new CustomerDetails(new CustomerName("Amy", "J", "Brown"), 21);
    ShoppingCart expShoppingCart = new ShoppingCart();
    String expString = "Customer{" +
        "customerDetails=" + details.toString() +
        ", shoppingCart=" + expShoppingCart.toString() +
        '}';
    assertEquals(expString, testCustomer.toString());
  }

  @Test
  void addProduct_OneGrocery() {
    Manufacturer manufacturer1 = new Manufacturer("Corona");
    Beer beer1 = new Beer(manufacturer1, "Corona light", 18.39, 21, 12.0);
    testCustomer.addProduct(beer1);
  }

  @Test
  void addProduct_OneHousehold() {
    Manufacturer dupManu = new Manufacturer("P&G");
    Shampoo dupShampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 2);
    testCustomer.addProduct(dupShampoo);
  }

  @Test
  void testAddProduct_MoreThan1QtyGrocery() {
    Manufacturer manufacturer1 = new Manufacturer("Corona");
    Beer beer1 = new Beer(manufacturer1, "Corona light", 18.39, 21, 12.0);
    testCustomer.addProduct(beer1, 2.0);
  }

  @Test
  void addProduct_MoreThan1QtyHousehold() {
    Manufacturer dupManu = new Manufacturer("P&G");
    Shampoo dupShampoo = new Shampoo(shampooManu, "Head&Shoulders", 25.8, 0, 2);
    testCustomer.addProduct(dupShampoo, 2.0);
  }

  @Test
  void resetCart() {
    testCustomer.resetCart();
  }
}