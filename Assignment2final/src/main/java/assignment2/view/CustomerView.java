package assignment2.view;

import assignment2.inventory.InventoryImpl;

public class CustomerView {
  public static void showAllProducts() {
    System.out.println("Grocery Products are : "+ InventoryImpl.getInstance().getGroceryStockItems().toString() + " and Household Products are: " + InventoryImpl.getInstance().getHouseholdStockItems().toString());
  }
}
