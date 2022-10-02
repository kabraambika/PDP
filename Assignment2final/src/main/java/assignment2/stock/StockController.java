package assignment2.stock;

import assignment2.enums.ProductCategory;
import assignment2.exceptions.QuantityExceededException;
import assignment2.inventory.InventoryImpl;
import assignment2.products.AbstractProduct;
import assignment2.products.GroceryProduct;
import assignment2.products.HouseholdProduct;
import java.util.ArrayList;
import java.util.List;

public class StockController {

  private static InventoryImpl inventory = InventoryImpl.getInstance();

  public StockController() {}

  public static boolean hasSimilarProduct(AbstractProduct product, Double qty) {
    if(product.getProductCategory().equals(ProductCategory.GROCERY)) {
      return hasSimilarGroceryProduct(product, qty, inventory.getGroceryStockItems());
    }
    else {
      return hasSimilarHouseholdProduct(product, qty, inventory.getHouseholdStockItems());
    }
  }

  private static boolean hasSimilarGroceryProduct(AbstractProduct product, Double qty, List<StockItem> stockItems) {
    GroceryProduct groceryProductInCart = (GroceryProduct) product;
    for(StockItem item : stockItems) {
      GroceryProduct groceryProduct = (GroceryProduct) item.getProduct();
      return validateSimilarProduct(product, qty, item) && groceryProduct.getWeight() >= groceryProductInCart.getWeight();
    }
    return false;
  }

  private static boolean hasSimilarHouseholdProduct(AbstractProduct product, Double qty, List<StockItem> stockItems) {
    HouseholdProduct householdProductInCart = (HouseholdProduct) product;
    for(StockItem item : stockItems) {
      HouseholdProduct householdProduct = (HouseholdProduct) item.getProduct();
      return validateSimilarProduct(product, qty, item) && householdProduct.getUnitsPerPackage() >= householdProductInCart.getUnitsPerPackage();
    }
    return false;
  }

  private static boolean validateSimilarProduct(AbstractProduct product, Double qty, StockItem item) {
    return item.getProduct().getProductType().equals(product.getProductType()) && item.getQuantity() >= qty && item.getProduct().getPrice() <= product.getPrice();
  }

  public static AbstractProduct getSimilarProduct(AbstractProduct product, Double qty) {
    if(product.getProductCategory().equals(ProductCategory.GROCERY)) {
      return getSimilarProduct(product, qty, inventory.getGroceryStockItems());
    }
    else {
      return getSimilarProduct(product, qty, inventory.getHouseholdStockItems());
    }
  }

  private static AbstractProduct getSimilarProduct(AbstractProduct product, Double qty, List<StockItem> stockItems) {
    for(StockItem item : stockItems) {
      if(item.getProduct().getProductType().equals(product.getProductType()) && item.getQuantity() >= qty) {
        return item.getProduct();
      }
    }
    return null;
  }

  public static boolean isProductPresent(AbstractProduct product, Double qty) {
    if(product.getProductCategory().equals(ProductCategory.GROCERY)) {
      return isProductPresent(product, qty, inventory.getGroceryStockItems());
    }
    else {
      return isProductPresent(product, qty, inventory.getHouseholdStockItems());
    }
  }

  private static boolean isProductPresent(AbstractProduct product, Double qty, List<StockItem> stockItems) {
    boolean isProductPresent = Boolean.FALSE;
    for(StockItem item : stockItems) {
      isProductPresent = item.getProduct().equals(product) && item.getQuantity() >= qty;
    }
    return isProductPresent;
  }

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
      if(item.getProduct().equals(product)) {
        try{
          if(validateItem(item, product, qty)) {
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
    }
    return Boolean.FALSE;
  }

  private static boolean validateItem(StockItem item, AbstractProduct product, Double qty) {
    return item.getProduct().equals(product) && Double.compare(item.getQuantity(), qty) >= 0;
  }
}
