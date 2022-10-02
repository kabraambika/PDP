package assignment2.staff;

import assignment2.customers.ShoppingCart;
import assignment2.products.AbstractProduct;
import assignment2.stock.StockController;
import java.util.HashMap;
import java.util.Map;

public class Staff {
  private ShoppingCart shoppingCart;
  public Staff() {
    shoppingCart = ShoppingCart.getInstance();
  }

  public void gatherOrder() {
    Map<AbstractProduct, Double> cartItems = shoppingCart.getItems();
    Map<AbstractProduct, Double> similarProductList = new HashMap<>();
    Map<AbstractProduct, Double> outOfStockItems = new HashMap<>();
    Map<AbstractProduct, Double> notAvailableProducts = new HashMap<>();
    cartItems.forEach((product, qty) -> {
      if(!StockController.isProductPresent(product, qty)) {
        AbstractProduct similarProduct = substituteSimilarItem(product, qty);
        notAvailableProducts.put(product, qty);
        if(similarProduct == null) {
          outOfStockItems.put(product, qty);
        } else {
          similarProductList.put(similarProduct, qty);
        }
      }
    });

    outOfStockItems.forEach((product, qty) -> {
      shoppingCart.setItemsOutOfStock(product, qty);
    });

    shoppingCart.updateCart(notAvailableProducts);

    similarProductList.forEach((product, qty) -> {
      shoppingCart.addProduct(product, qty);
    });
  }

  private AbstractProduct substituteSimilarItem(AbstractProduct product, Double qty) {
    if(StockController.hasSimilarProduct(product, qty)) {
       return StockController.getSimilarProduct(product, qty);
    }
    else {
      return null;
    }
  }
}
