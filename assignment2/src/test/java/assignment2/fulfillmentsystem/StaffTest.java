package assignment2.fulfillmentsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import assignment2.fulfillmentsystem.Receipt;
import assignment2.fulfillmentsystem.Staff;
import assignment2.inventory.Inventory;
import assignment2.pickupsystem.Customer;
import assignment2.pickupsystem.CustomerDetails;
import assignment2.pickupsystem.CustomerName;
import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.Cheese;
import assignment2.products.IProduct;
import assignment2.products.Manufacturer;
import assignment2.products.Shampoo;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {
  private Staff testStaff;

  @BeforeEach
  void setUp() {
    testStaff = new Staff();
  }

  @Test
  void getFinalGroceryProducts() {
    assertEquals(new HashMap<AbstractGrocery, Double>(), testStaff.getFinalGroceries());
  }

  @Test
  void getFinalHouseholdProducts() {
    assertEquals(new HashMap<AbstractHousehold, Double>(), testStaff.getFinalHouseholds());
  }

  @Test
  void getOutOfStockProducts() {
    assertEquals(new HashMap<IProduct, Double>(), testStaff.getOutStockProducts());
  }

  @Test
  void getAgeRestrictedProducts() {
    assertEquals(new HashMap<IProduct, Double>(), testStaff.getRemovedProducts());
  }

  @Test
  void fulfillOrder_processOrder_Grocery() {
    AbstractGrocery cheese = new Cheese(new Manufacturer("Mac"), "Mac cheese", 10.0, 0, 5.0);
    AbstractGrocery swissCheese = new Cheese(new Manufacturer("Swiss"), "swiss cheese", 10.0, 0, 5.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(cheese, 2.0);
    inventory.addNewProduct(swissCheese, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(cheese);
    amy.addProduct(cheese);
    amy.addProduct(swissCheese);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Grocery_MinimumAge() {
    AbstractGrocery cheese = new Cheese(new Manufacturer("Mac"), "Mac cheese", 10.0, 0, 5.0);
    AbstractGrocery swissCheese = new Cheese(new Manufacturer("Swiss"), "swiss cheese", 10.0, 12, 5.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(cheese, 2.0);
    inventory.addNewProduct(swissCheese, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(cheese);
    amy.addProduct(cheese);
    amy.addProduct(swissCheese);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Grocery_ReplaceCheese() {
    AbstractGrocery cheese = new Cheese(new Manufacturer("Mac"), "Mac cheese", 10.0, 0, 5.0);
    AbstractGrocery swissCheese = new Cheese(new Manufacturer("Swiss"), "swiss cheese", 10.0, 12, 5.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(cheese, 2.0);
    inventory.addNewProduct(swissCheese, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(cheese);
    amy.addProduct(swissCheese);
    inventory.decreaseGroceryStock(swissCheese, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Grocery_ReplaceCheese_notQty() {
    AbstractGrocery cheese = new Cheese(new Manufacturer("Mac"), "Mac cheese", 10.0, 0, 5.0);
    AbstractGrocery swissCheese = new Cheese(new Manufacturer("Swiss"), "swiss cheese", 10.0, 12, 5.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(cheese, 1.0);
    inventory.addNewProduct(swissCheese, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(cheese);
    amy.addProduct(swissCheese);
    inventory.decreaseGroceryStock(swissCheese, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Grocery_noReplaceCheese_notQty() {
    AbstractGrocery swissCheese = new Cheese(new Manufacturer("Swiss"), "swiss cheese", 10.0, 12, 5.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(swissCheese, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(swissCheese);
    inventory.decreaseGroceryStock(swissCheese, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    AbstractHousehold headAndShoulders = new Shampoo(new Manufacturer("P&G"), "headAndShoulders", 12.0, 0, 1);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    inventory.addNewProduct(headAndShoulders, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(garnier);
    amy.addProduct(headAndShoulders);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household_SimilarShampoo() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    AbstractHousehold headAndShoulders = new Shampoo(new Manufacturer("P&G"), "headAndShoulders", 12.0, 0, 1);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    inventory.addNewProduct(headAndShoulders, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(garnier);
    inventory.decreaseHouseholdStock(garnier, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household_SimilarShampoo_NotQty() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    AbstractHousehold headAndShoulders = new Shampoo(new Manufacturer("P&G"), "headAndShoulders", 12.0, 0, 1);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    inventory.addNewProduct(headAndShoulders, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(headAndShoulders);
    amy.addProduct(garnier);
    inventory.decreaseHouseholdStock(garnier, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household_SimilarShampoo_NotAvailable() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(garnier);
    inventory.decreaseHouseholdStock(garnier, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household_MinimumAge() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    AbstractHousehold headAndShoulders = new Shampoo(new Manufacturer("P&G"), "headAndShoulders", 12.0, 12, 1);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    inventory.addNewProduct(headAndShoulders, 1.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(garnier);
    inventory.decreaseHouseholdStock(garnier, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }

  @Test
  void fulfillOrder_processOrder_Household_SimilarProduct_hasQty() {
    AbstractHousehold garnier = new Shampoo(new Manufacturer("P&G"), "Garnier", 12.0, 0, 1);
    AbstractHousehold headAndShoulders = new Shampoo(new Manufacturer("P&G"), "headAndShoulders", 12.0, 0, 1);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewProduct(garnier, 1.0);
    inventory.addNewProduct(headAndShoulders, 2.0);

    Customer amy = new Customer(new CustomerDetails(new CustomerName("amy", "", ""), 1));
    amy.addProduct(headAndShoulders);
    amy.addProduct(garnier);
    inventory.decreaseHouseholdStock(garnier, 1.0);
    Staff st = new Staff();
    st.fulfillOrder(amy);
    Receipt amyReceipt = st.processOrder(amy);
  }
}