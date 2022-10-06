package assignment2.problem1.inventory;

import assignment2.problem1.stock.GroceryStockItem;
import assignment2.problem1.stock.HouseholdStockItem;

public interface InterfaceInventory {
  void addNewStockItem(GroceryStockItem groceryStockItem);
  void addNewStockItem(HouseholdStockItem householdStockItem);
  Double getTotalRetailInStock();
}
