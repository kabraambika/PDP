package assignment2.stock;

import assignment2.exceptions.QuantityExceededException;
import assignment2.products.AbstractProduct;
import java.util.ArrayList;
import java.util.List;

public class StockController {
  private List<StockItem> itemList;
  public StockController() {
    this.itemList = new ArrayList<>();
  }

  public void addStockItem(StockItem stockItem) {
    this.itemList.add(stockItem);
  }

  public void addStockItem(List<StockItem> stockItems) {
    this.itemList.addAll(stockItems);
  }

  public boolean hasEnoughItems(AbstractProduct product){
    return hasEnoughItems(product, 1.0);
  }

  public boolean hasEnoughItems(AbstractProduct product, Double qty){
    for(StockItem item : itemList) {
      if(item.getProduct().equals(product) && item.getQuantity() >= qty) {
        return Boolean.TRUE;
      }
      else {
        throw new QuantityExceededException(qty + " quantity needed is greater than available quantity " + item.getQuantity());
      }
    }
    return Boolean.FALSE;
  }

  public void decreaseQuantity(AbstractProduct product, Double quantity){
    for(StockItem item : itemList) {
      if(item.getProduct().equals(product)) {
        StockItem updatedStockItem = new StockItem(item.getProduct(), item.getQuantity() - quantity);
        itemList.remove(item);
        itemList.add(updatedStockItem);
        break;
      }
    }
  }

  public void decreaseQuantity(AbstractProduct product){
    decreaseQuantity(product, 1.0);
  }
}
