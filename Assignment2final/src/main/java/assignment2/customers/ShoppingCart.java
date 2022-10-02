package assignment2.customers;
import assignment2.products.AbstractProduct;
import assignment2.stock.StockController;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {
  private Map<AbstractProduct, Double> items;
  private Map<AbstractProduct, Double> itemsOutOfStock;
  private Map<AbstractProduct, Double> itemsRemoved;
  private static ShoppingCart shoppingCart;
  private ShoppingCart() {
    this.items = new HashMap<>();
    this.itemsOutOfStock = new HashMap<>();
    this.itemsRemoved = new HashMap<>();
  }
  public static ShoppingCart getInstance() {
    if(shoppingCart == null) {
      shoppingCart = new ShoppingCart();
    }
    return shoppingCart;
  }

  public Map<AbstractProduct, Double> getItems() {
    return this.items;
  }

  public Map<AbstractProduct, Double> getItemsOutOfStock() {
    return itemsOutOfStock;
  }

  public Map<AbstractProduct, Double> getItemsRemoved() {
    return itemsRemoved;
  }

  public Double totalCost() {
    return getItems().entrySet().stream().mapToDouble(entity -> entity.getKey().getPrice() * entity.getValue()).sum();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShoppingCart that = (ShoppingCart) o;
    return Objects.equals(getItems(), that.getItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItems());
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
        "items=" + getItems() +
        ", totalCost=" + totalCost() +
        '}';
  }

  public void addProduct(AbstractProduct product) {
    addProduct(product, 1.0);
  }

  public void addProduct(AbstractProduct product, Double qty) {
    if(StockController.hasEnoughItems(product, qty)) {
      getItems().put(product, qty);
    }
  }

  public void setItemsOutOfStock(AbstractProduct product, Double qty) {
   getItemsOutOfStock().put(product, qty);
  }

  public void removeProductFromCart(AbstractProduct product) {
    getItems().remove(product);
  }

  public void updateCart(Map<AbstractProduct, Double> itemsRemoved) {
    getItems().keySet().removeAll(itemsRemoved.keySet());
  }

  public void setRestrictedItems(AbstractProduct product, Double qty) {
    getItemsRemoved().put(product, qty);
  }
}
