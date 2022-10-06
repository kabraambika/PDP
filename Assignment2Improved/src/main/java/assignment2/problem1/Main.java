package assignment2.problem1;

import assignment2.problem1.inventory.Inventory;
import assignment2.problem1.pickupOrder.Customer;
import assignment2.problem1.pickupOrder.CustomerController;
import assignment2.problem1.pickupOrder.Name;
import assignment2.problem1.pickupOrder.OrderHistory;
import assignment2.problem1.pickupOrder.Receipt;
import assignment2.problem1.pickupOrder.SupermarketStaff;
import assignment2.problem1.products.Cheese;
import assignment2.problem1.products.Grocery;
import assignment2.problem1.products.Household;
import assignment2.problem1.products.PaperTowel;
import assignment2.problem1.products.Shampoo;
import assignment2.problem1.stock.GroceryStockItem;
import assignment2.problem1.stock.HouseholdStockItem;

public class Main {

  public static void main(String[] args) {
    Grocery cheese = new Cheese(new Manufacturer("MAC"), "MAC cheese", 12.0, 0, 3.0);
    GroceryStockItem groceryStockItem = new GroceryStockItem(cheese, 2.0);

    Household paperTowel = new PaperTowel(new Manufacturer("Bounty"), "Bounty essentials", 5.79, 0, 10);
    Household shampoo = new Shampoo(new Manufacturer("Garnier"), "Garnier shampoo", 20.0, 30, 1);
    HouseholdStockItem householdStockItem = new HouseholdStockItem(shampoo, 10.0);
    HouseholdStockItem paperStockItem = new HouseholdStockItem(paperTowel, 1.0);

    Inventory inventory = Inventory.getInstance();
    inventory.addNewStockItem(groceryStockItem);
    inventory.addNewStockItem(householdStockItem);
    inventory.addNewStockItem(paperStockItem);
    System.out.println("Inventory total cost :: " + inventory.getTotalRetailInStock());

    Customer ambika = new Customer(new Name("Ambika", "J", "Kabra"), 28);
    CustomerController ambikaController = new CustomerController(ambika);
    System.out.println(ambikaController.viewAllProducts());
    ambikaController.addProductInCart(cheese, 2.0);
    ambikaController.addProductInCart(shampoo, 2.0);
    ambikaController.addProductInCart(paperTowel);

    Customer john = new Customer(new Name("John", "J", "Brown"), 38);
    CustomerController johnController = new CustomerController(john);
    System.out.println(johnController.viewAllProducts());
    johnController.addProductInCart(cheese, 2.0);
    johnController.addProductInCart(shampoo, 2.0);
    johnController.addProductInCart(paperTowel);

    System.out.println("before" + ambika.getTotalCartCost());
    SupermarketStaff staff = new SupermarketStaff();
    staff.fulfillOrder(john);
    System.out.println("After fulfill for customer 1" + john.getTotalCartCost());
    Receipt johnRcpt = staff.processOrder(john);
    System.out.println(johnRcpt.toString());


    staff.fulfillOrder(ambika);
    System.out.println("After fulfill for customer " + ambika.getTotalCartCost());
    Receipt ambikaRcpt = staff.processOrder(ambika);
    System.out.println(ambikaRcpt.toString());

    OrderHistory history = new OrderHistory();

    history.addTransaction(ambika, ambikaRcpt);
    history.addTransaction(john, johnRcpt);

    System.out.println(history);
  }
}
