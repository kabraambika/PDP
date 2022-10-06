package assignment2.problem1.inventory;

import assignment2.problem1.products.Grocery;
import assignment2.problem1.products.Household;
import assignment2.problem1.stock.GroceryStockItem;
import assignment2.problem1.stock.HouseholdStockItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Inventory implements InterfaceInventory {
  private static Inventory inventory;
  List<GroceryStockItem> groceryStockItems;
  List<HouseholdStockItem> householdStockItems;

  public Inventory() {
    this.groceryStockItems = new ArrayList<>();
    this.householdStockItems = new ArrayList<>();
  }

  public static Inventory getInstance() {
    if(inventory == null) {
      inventory = new Inventory();
    }
    return inventory;
  }

  public List<GroceryStockItem> getGroceryStockItems() {
    return this.groceryStockItems;
  }

  public List<HouseholdStockItem> getHouseholdStockItems() {
    return this.householdStockItems;
  }

  private void addStockItem(GroceryStockItem item) {
    this.groceryStockItems.add(item);
  }

  private void addStockItem(HouseholdStockItem item) {
    this.householdStockItems.add(item);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) obj;
    return Objects.equals(this.getGroceryStockItems(), inventory.getGroceryStockItems())
        && Objects.equals(this.getHouseholdStockItems(), inventory.getHouseholdStockItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getGroceryStockItems(), getHouseholdStockItems());
  }

  @Override
  public String toString() {
    return "Inventory{" +
        "groceryStockItems=" + this.getGroceryStockItems() +
        ", householdStockItems=" + this.getHouseholdStockItems() +
        '}';
  }

  @Override
  public void addNewStockItem(GroceryStockItem newGroceryStockItem) {
    if(this.isProductInStock(newGroceryStockItem.getGroceryProduct())) {
      this.updateExistingStockItem(newGroceryStockItem);
    }
    else {
      this.addStockItem(newGroceryStockItem);
    }
  }

  private void updateExistingStockItem(GroceryStockItem newGroceryStockItem) {
    GroceryStockItem oldStockItem = null;
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      if(stockItem.getGroceryProduct().equals(newGroceryStockItem.getGroceryProduct())) {
        oldStockItem = stockItem;
        break;
      }
    }
    removeStockItem(oldStockItem);
    updateNewItemInList(newGroceryStockItem, oldStockItem.getQuantity());
  }

  private void updateNewItemInList(GroceryStockItem newGroceryStockItem, Double qty) {
    newGroceryStockItem.increaseQuantity(qty);
    addStockItem(newGroceryStockItem);
  }

  private void removeStockItem(GroceryStockItem oldStockItem) {
    this.getGroceryStockItems().remove(oldStockItem);
  }

  private boolean isProductInStock(Grocery newGroceryProduct) {
    Boolean isProductAvailable = Boolean.FALSE;
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      if(stockItem.getGroceryProduct().equals(newGroceryProduct)) {
        isProductAvailable = Boolean.TRUE;
        break;
      }
    }
    return isProductAvailable;
  }

  @Override
  public void addNewStockItem(HouseholdStockItem newHouseholdStockItem) {
    if(this.isProductInStock(newHouseholdStockItem.getHouseholdProduct())) {
      this.updateExistingStockItem(newHouseholdStockItem);
    }
    else {
      this.addStockItem(newHouseholdStockItem);
    }
  }

  private void updateExistingStockItem(HouseholdStockItem newHouseholdStockItem) {
    HouseholdStockItem oldStockItem = null;
    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      if(stockItem.getHouseholdProduct().equals(newHouseholdStockItem.getHouseholdProduct())) {
        oldStockItem = stockItem;
        break;
      }
    }
    removeStockItem(oldStockItem);
    updateNewItemInList(newHouseholdStockItem, oldStockItem.getQuantity());
  }

  private void removeStockItem(HouseholdStockItem oldStockItem) {
    this.getHouseholdStockItems().remove(oldStockItem);
  }

  private void updateNewItemInList(HouseholdStockItem newHouseholdStockItem, Double prevQuantity) {
    newHouseholdStockItem.increaseQuantity(prevQuantity);
    addStockItem(newHouseholdStockItem);
  }

  private boolean isProductInStock(Household newHouseholdProduct) {
    Boolean isProductAvailable = Boolean.FALSE;
    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      if(stockItem.getHouseholdProduct().equals(newHouseholdProduct)) {
        isProductAvailable = Boolean.TRUE;
        break;
      }
    }
    return isProductAvailable;
  }

  @Override
  public Double getTotalRetailInStock() {
    Double groceryTotalPrice = this.getGroceryTotalPrice();
    Double householdTotalPrice = this.getHouseholdTotalPrice();
    return groceryTotalPrice + householdTotalPrice;
  }

  private Double getGroceryTotalPrice() {
    Double totalAmount = 0.0;
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      totalAmount += stockItem.getGroceryProduct().getPrice() * stockItem.getQuantity();
    }

    return totalAmount;
  }

  private Double getHouseholdTotalPrice() {
    Double totalAmount = 0.0;
    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      totalAmount += stockItem.getHouseholdProduct().getPrice() * stockItem.getQuantity();
    }
    return totalAmount;
  }

  public boolean isValidProduct(Grocery groceryProduct, Double quantity) {
    boolean isValidProduct = Boolean.FALSE;
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      if(stockItem.getGroceryProduct().equals(groceryProduct) && stockItem.hasEnoughItemsInStock(quantity)) {
        isValidProduct = Boolean.TRUE;
        break;
      }
    }

    return isValidProduct;
  }

  public boolean isValidProduct(Household householdProduct, Double quantity) {
    boolean isValidProduct = Boolean.FALSE;

    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      if(stockItem.getHouseholdProduct().equals(householdProduct) && stockItem.hasEnoughItemsInStock(quantity)) {
        isValidProduct = Boolean.TRUE;
        break;
      }
    }

    return isValidProduct;
  }

  public Grocery getSimilarProduct(Grocery groceryProduct, Double quantity) {
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      Grocery currentProduct = stockItem.getGroceryProduct();
      if(isValidProductType(currentProduct, groceryProduct) &&
          stockItem.hasEnoughItemsInStock(quantity) &&
          isValidPrice(currentProduct, groceryProduct) &&
          isValidWeight(currentProduct, groceryProduct)) {
          return currentProduct;
      }
    }
    return null;
  }

  public Household getSimilarProduct(Household householdProduct, Double quantity) {
    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      Household currentProduct = stockItem.getHouseholdProduct();
      if(isValidProductType(currentProduct, householdProduct) &&
          stockItem.hasEnoughItemsInStock(quantity) &&
          isValidPrice(currentProduct, householdProduct) &&
          isValidUnitPerPackage(currentProduct, householdProduct)) {
          return currentProduct;
      }
    }
    return null;
  }

  private boolean isValidUnitPerPackage(Household currentProduct, Household householdProduct) {
    return currentProduct.getUnitsPerPackage() >= householdProduct.getUnitsPerPackage();
  }

  private boolean isValidWeight(Grocery currentProduct, Grocery groceryProduct) {
    return currentProduct.getProductWeight() >= groceryProduct.getProductWeight();
  }

  private boolean isValidPrice(Household currentProduct, Household householdProduct) {
    return currentProduct.getPrice() <= householdProduct.getPrice();
  }
  private boolean isValidPrice(Grocery currentProduct, Grocery groceryProduct) {
    return currentProduct.getPrice() <= groceryProduct.getPrice();
  }

  private boolean isValidProductType(Household currentProduct, Household householdProduct) {
    return currentProduct != householdProduct && currentProduct.getClass() == householdProduct.getClass();
  }
  private boolean isValidProductType(Grocery currentProduct, Grocery groceryProduct) {
    return currentProduct != groceryProduct && currentProduct.getClass() == groceryProduct.getClass();
  }

  public void decreaseGroceryItems(HashMap<Grocery, Double> groceryProducts) {
    groceryProducts.forEach((product, quantity) -> {
      decreaseStock(product, quantity);
    });
  }

  public void decreaseHouseholdItems(HashMap<Household, Double> householdProducts) {
    householdProducts.forEach((product, quantity) -> {
      decreaseStock(product, quantity);
    });
  }

  private void decreaseStock(Grocery product, Double quantity) {
    for(GroceryStockItem stockItem : this.getGroceryStockItems()) {
      if(stockItem.getGroceryProduct().equals(product)) {
        stockItem.reduceQuantity(quantity);
      }
    }
  }

  private void decreaseStock(Household product, Double quantity) {
    for(HouseholdStockItem stockItem : this.getHouseholdStockItems()) {
      if(stockItem.getHouseholdProduct().equals(product)) {
        stockItem.reduceQuantity(quantity);
      }
    }
  }
}
