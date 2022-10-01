package assignment2.customers;

import assignment2.products.AbstractProduct;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
  private Map<AbstractProduct, Integer> items;
  private static ShoppingCart shoppingCart;
  private ShoppingCart() {
    this.items = new HashMap<>();
  }
  public static ShoppingCart getInstance() {
    if(shoppingCart == null) {
      shoppingCart = new ShoppingCart();
    }
    return shoppingCart;
  }

  public Double totalCost() {
    return items.entrySet().stream().mapToDouble(entity -> entity.getKey().getPrice() * entity.getValue()).sum();
  }
}
