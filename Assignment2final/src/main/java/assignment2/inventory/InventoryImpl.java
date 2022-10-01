package assignment2.inventory;

import assignment2.enums.ProductCategory;
import assignment2.products.AbstractProduct;
import assignment2.stock.StockItem;
import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory{
  private List<StockItem> groceryStockItems;
  private List<StockItem> householdStockItems;

  public InventoryImpl() {
    this.groceryStockItems = new ArrayList<>();
    this.householdStockItems = new ArrayList<>();
  }

  public List<StockItem> getGroceryStockItems() {
    return groceryStockItems;
  }

  public List<StockItem> getHouseholdStockItems() {
    return householdStockItems;
  }

  @Override
  public Double getTotalRetailPrice() {
    Double groceriesTotalPrice = getListPrice(getGroceryStockItems());
    Double householdTotalPrice = getListPrice(getHouseholdStockItems());

    return groceriesTotalPrice + householdTotalPrice;
  }

  private Double getListPrice(List<StockItem> stockItemList) {
    return stockItemList.stream().mapToDouble((item) -> item.getProduct().getPrice()).sum();
  }

  @Override
  public void addStockItem(StockItem stockItem) {
    AbstractProduct product = stockItem.getProduct();
    if(product.getProductCategory().equals(ProductCategory.GROCERY)) {
      addGroceryStockItem(stockItem);
    }
    else {
      addHouseholdStockItem(stockItem);
    }
  }

  private void addHouseholdStockItem(StockItem stockItem) {
    boolean isExistingItem = updateExistingStockItem(stockItem, getHouseholdStockItems());
    if(!isExistingItem) {
      StockItem newItem = new StockItem(stockItem.getProduct(), 1.0);
      addNewHouseholdItem(newItem);
    }
  }

  private void addGroceryStockItem(StockItem stockItem) {
    boolean isExistingItem = updateExistingStockItem(stockItem, getGroceryStockItems());
    if(!isExistingItem) {
      StockItem newItem = new StockItem(stockItem.getProduct(), 1.0);
      addNewGroceryItem(newItem);
    }
  }
  private boolean updateExistingStockItem(StockItem stockItem, List<StockItem> stockItemList) {
    AbstractProduct itemProduct = stockItem.getProduct();
    for(StockItem item : stockItemList) {
      AbstractProduct stockProduct = item.getProduct();
      if(stockProduct.equals(itemProduct)) {
        StockItem updateExistingItem = new StockItem(stockProduct, item.getQuantity()+1.0);
        updateExistingList(item, updateExistingItem, stockItemList);
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  private void addNewGroceryItem(StockItem newItem) {
    addNewStockItem(newItem, getGroceryStockItems());
  }

  private void addNewHouseholdItem(StockItem newItem) {
    addNewStockItem(newItem, getHouseholdStockItems());
  }

  private void addNewStockItem(StockItem newItem, List<StockItem> stockItemList) {
    stockItemList.add(newItem);
  }

  private void updateExistingList(StockItem item, StockItem updateExistingItem,
      List<StockItem> stockItemList) {
    stockItemList.remove(item);
    stockItemList.add(updateExistingItem);
  }
}
