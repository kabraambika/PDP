package assignment2.stock;

import assignment2.enums.ProductCategory;
import assignment2.exceptions.QuantityExceededException;
import assignment2.inventory.InventoryImpl;
import assignment2.products.AbstractProduct;
import java.util.ArrayList;
import java.util.List;

public class StockController {

  private static InventoryImpl inventory = InventoryImpl.getInstance();

  public StockController() {}

  public boolean hasEnoughItems(AbstractProduct product) {
    return hasEnoughItems(product, 1.0);
  }
  public static boolean hasEnoughItems(AbstractProduct product, Double qty) {
    if(product.getProductCategory().equals(ProductCategory.GROCERY)) {
      return hasEnoughItems(product, qty, inventory.getGroceryStockItems());
    }
    else {
      return hasEnoughItems(product, qty, inventory.getHouseholdStockItems());
    }
  }
  private static boolean hasEnoughItems(AbstractProduct product, Double qty,
      List<StockItem> stockItems) {
    for(StockItem item : stockItems) {
      try{
        if(item.getProduct().equals(product) && item.getQuantity() >= qty) {
          return Boolean.TRUE;
        }
        else {
          throw new QuantityExceededException(qty + " quantity needed is greater than available quantity " + item.getQuantity());
        }
      }
      catch(QuantityExceededException ex) {
        ex.printStackTrace();
      }
    }
    return false;
  }
  public void decreaseQuantity(AbstractProduct product, Double quantity){
//    for(StockItem item : itemList) {
//      if(item.getProduct().equals(product)) {
//        StockItem updatedStockItem = new StockItem(item.getProduct(), item.getQuantity() - quantity);
//        itemList.remove(item);
//        itemList.add(updatedStockItem);
//        break;
//      }
//    }
  }


  public void decreaseQuantity(AbstractProduct product){
    decreaseQuantity(product, 1.0);
  }
}
