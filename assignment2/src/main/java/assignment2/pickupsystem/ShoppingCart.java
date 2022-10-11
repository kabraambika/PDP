package assignment2.pickupsystem;

import assignment2.fulfillmentsystem.InvalidQuantityException;
import assignment2.inventory.Inventory;
import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * ShoppingCart class keeps track of products added by customer
 */
public class ShoppingCart {

  private static final Double SINGLE_QUANTITY = 1.0;
  /**
   * Constant for minimum amount = 0
   */
  private static final Double MIN_AMOUNT = 0.0;
  private Map<AbstractGrocery, Double> groceryProducts;
  private Map<AbstractHousehold, Double> householdProducts;
  private Inventory inventory;

  /**
   * Constructor of cart
   */
  public ShoppingCart() {
    this.groceryProducts = new HashMap<>();
    this.householdProducts = new HashMap<>();
    this.inventory = Inventory.getInstance();
  }

  /**
   * Getter of Map of grocery Products
   *
   * @return this.groceryProducts
   */
  public Map<AbstractGrocery, Double> getGroceryProducts() {
    return this.groceryProducts;
  }

  /**
   * Getter of Map of household Products
   *
   * @return this.householdProducts
   */
  public Map<AbstractHousehold, Double> getHouseholdProducts() {
    return this.householdProducts;
  }

  /**
   * helper method adds grocery product in Map of grocery products, if already present increase
   * quantity
   *
   * @param product AbstractGrocery product, represented as AbstractGrocery
   * @param qty     quantity of grocery product added
   */
  private void addProduct(AbstractGrocery product, Double qty) {
    Double finalQty = qty;
    if (this.getGroceryProducts().containsKey(product)) {
      finalQty += this.getGroceryProducts().get(product);
    }
    this.getGroceryProducts().put(product, finalQty);
  }

  /**
   * helper method adds household product in Map of household products, if already present increase
   * quantity
   *
   * @param product household product, represented as AbstractHousehold
   * @param qty     quantity of household product added
   */
  private void addProduct(AbstractHousehold product, Double qty) {
    Double finalQty = qty;
    if (this.getHouseholdProducts().containsKey(product)) {
      finalQty += this.getHouseholdProducts().get(product);
    }
    this.getHouseholdProducts().put(product, finalQty);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ShoppingCart shoppingCart = (ShoppingCart) obj;
    return Objects.equals(this.getGroceryProducts(), shoppingCart.getGroceryProducts())
        && Objects.equals(this.getHouseholdProducts(), shoppingCart.getHouseholdProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getGroceryProducts(), this.getHouseholdProducts());
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
        "groceryProducts=" + this.getGroceryProducts() +
        ", householdProducts=" + this.getHouseholdProducts() +
        '}';
  }

  /**
   * Total cost of cart
   *
   * @return Double
   */
  public Double getTotalCost() {
    return this.getGroceryTotal() + this.getHouseholdTotal();
  }

  /**
   * Helper method to get total cost of grocery products
   *
   * @return Double
   */
  private Double getGroceryTotal() {
    Double totalAmt = MIN_AMOUNT;
    for (Entry<AbstractGrocery, Double> productEntry : this.getGroceryProducts().entrySet()) {
      totalAmt += productEntry.getKey().getPrice() * productEntry.getValue();
    }
    return totalAmt;
  }

  /**
   * Helper method to get total cost of household products
   *
   * @return Double
   */
  private Double getHouseholdTotal() {
    Double totalAmt = MIN_AMOUNT;
    for (Entry<AbstractHousehold, Double> productEntry : this.getHouseholdProducts().entrySet()) {
      totalAmt += productEntry.getKey().getPrice() * productEntry.getValue();
    }
    return totalAmt;
  }

  /**
   * Customer can add grocery product in cart with given inputs, if not a valid input than
   * InvalidQuantityException exception will be thrown
   *
   * @param product  AbstractGrocery product
   * @param quantity Double, quantity of product
   */
  public void addProductInCart(AbstractGrocery product, Double quantity) {
    try {
      if (inventory.validateProductQty(product, quantity)) {
        this.addProduct(product, quantity);
      } else {
        throw new InvalidQuantityException(
            quantity + " quantity needed for product " + product.getProductName()
                + " is not available in stock !");
      }
    }
    catch(InvalidQuantityException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * Customer can add single grocery product in cart, if not a valid input then
   * InvalidQuantityException exception will be thrown
   *
   * @param product AbstractGrocery product
   */
  public void addProductInCart(AbstractGrocery product) {
    this.addProductInCart(product, SINGLE_QUANTITY);
  }

  /**
   * Customer can add household product in cart with given inputs, if not a valid input then
   * InvalidQuantityException exception will be thrown
   *
   * @param product  AbstractHousehold product
   * @param quantity Double, quantity of product
   */
  public void addProductInCart(AbstractHousehold product, Double quantity) {
    try {
      if (inventory.validateProductQty(product, quantity)) {
        this.addProduct(product, quantity);
      } else {
        throw new InvalidQuantityException(
            quantity + " quantity needed for product " + product.getProductName()
                + " is not available in stock !");
      }
    }
    catch(InvalidQuantityException exception) {
      System.out.println(exception.getMessage());
    }
  }

  /**
   * Customer can add single household product in cart, if not a valid input than
   * InvalidQuantityException exception will be thrown
   *
   * @param product household product
   */
  public void addProductInCart(AbstractHousehold product) {
    this.addProductInCart(product, SINGLE_QUANTITY);
  }
}
