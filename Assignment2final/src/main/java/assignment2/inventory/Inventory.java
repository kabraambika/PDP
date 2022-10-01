package assignment2.inventory;

import assignment2.stock.StockItem;

public interface Inventory {
  void addStockItem(StockItem stockItem);

  Double getTotalRetailPrice();
}
