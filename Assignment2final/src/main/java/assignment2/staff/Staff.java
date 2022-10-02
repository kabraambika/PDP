package assignment2.staff;

import assignment2.customers.Customer;
import assignment2.customers.Receipt;
import assignment2.customers.ShoppingCart;
import assignment2.inventory.InventoryImpl;
import assignment2.products.AbstractProduct;
import assignment2.stock.StockController;
import java.util.HashMap;
import java.util.Map;

public class Staff {
  private ShoppingCart shoppingCart;
  InventoryImpl inventory;
  public Staff() {
    shoppingCart = ShoppingCart.getInstance();
    inventory = InventoryImpl.getInstance();
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

    updateShoppingCart(notAvailableProducts);

    similarProductList.forEach((product, qty) -> {
      shoppingCart.addProduct(product, qty);
    });
  }

  public Receipt processOrder(Customer customer) {
    verifyAgeRestrictedProduct(customer.getAge());
    updateInventory();
    Double totalPricePaid = shoppingCart.totalCost();
    Map<AbstractProduct, Double> cartItems = shoppingCart.getItems();
    Map<AbstractProduct, Double> outOfStockItems = shoppingCart.getItemsOutOfStock();
    Map<AbstractProduct, Double> ageRestrictedItems = shoppingCart.getItemsRemoved();
    return new Receipt(customer.getName(), customer.getAge(), totalPricePaid, cartItems, outOfStockItems, ageRestrictedItems);
  }

  private void updateInventory() {
    Map<AbstractProduct, Double> cartItems = shoppingCart.getItems();
    cartItems.forEach((product, qty) -> {
      inventory.decreaseQuantity(product, qty);
    });
  }

  private void verifyAgeRestrictedProduct(int customerAge) {
    Map<AbstractProduct, Double> cartItems = shoppingCart.getItems();
    Map<AbstractProduct, Double> removeFromCart = new HashMap<>();
    cartItems.forEach((product, qty) -> {
      if(customerAge < product.getAge()) {
        removeFromCart.put(product, qty);
      }
    });
    setRemovedItems(removeFromCart);
    updateShoppingCart(removeFromCart);
  }

  private void updateShoppingCart(Map<AbstractProduct, Double> removeFromCart) {
    shoppingCart.updateCart(removeFromCart);
  }

  private void setRemovedItems(Map<AbstractProduct, Double> removeFromCart) {
    removeFromCart.forEach((product, qty) -> {
      shoppingCart.setRestrictedItems(product, qty);
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
