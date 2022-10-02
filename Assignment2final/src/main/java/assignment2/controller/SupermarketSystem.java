package assignment2.controller;

import assignment2.customers.Customer;
import assignment2.customers.Name;
import assignment2.customers.Receipt;
import assignment2.enums.ProductType;
import assignment2.inventory.InventoryImpl;
import assignment2.products.AbstractProduct;
import assignment2.products.GroceryProduct;
import assignment2.products.HouseholdProduct;
import assignment2.staff.Staff;
import assignment2.stock.StockItem;


public class SupermarketSystem {

  public static void main(String[] args) {
    AbstractProduct swissCheese = new GroceryProduct("Swiss", "Swiss cheese", 12.0, 0, ProductType.CHEESE, 5.0);
    AbstractProduct macCheese = new GroceryProduct("Mac", "mac cheese", 10.0, 0, ProductType.CHEESE, 2.0);
    AbstractProduct beer = new GroceryProduct("kings", "beer", 30.0, 25, ProductType.BEER, 200.0);
    AbstractProduct shampoo = new HouseholdProduct("P&G", "head and shoulder shampoo", 50.0, 0, ProductType.SHAMPOO, 1);
    StockItem cheeseStock = new StockItem(swissCheese, 2.0);
    StockItem shampooStock = new StockItem(shampoo, 10.0);
    StockItem macCheeseStock = new StockItem(macCheese, 1.0);
    StockItem beerStock = new StockItem(beer, 10.0);
    InventoryImpl inventory = InventoryImpl.getInstance();
    inventory.addStockItem(cheeseStock);
    inventory.addStockItem(cheeseStock);
    inventory.addStockItem(macCheeseStock);
    inventory.addStockItem(shampooStock);
    inventory.addStockItem(beerStock);

    System.out.println("Grocery :" + inventory.getGroceryStockItems().toString());
    System.out.println("Household :" + inventory.getHouseholdStockItems().toString());
    System.out.println("Total stock price: " + inventory.getTotalRetailPrice());
    Customer customer1 = new Customer(new Name("AMBIKA"), 21);

    CustomerController customerController = new CustomerController(customer1);
    customerController.addProductInCart(shampoo);
    customerController.addProductInCart(macCheese, 1.0);
    customerController.addProductInCart(beer, 2.0);
    System.out.println(customer1.getShoppingCart());
    inventory.decreaseQuantity(macCheese);
    Staff st = new Staff();
    st.gatherOrder();
    Receipt receipt = st.processOrder(customer1);
    System.out.println(receipt.toString());
    System.out.println("Grocery :" + inventory.getGroceryStockItems().toString());
    System.out.println("Household :" + inventory.getHouseholdStockItems().toString());
    System.out.println("Total stock price: " + inventory.getTotalRetailPrice());
  }

}
