package assignment2.problem1.pickupOrder;

import assignment2.problem1.products.Grocery;
import assignment2.problem1.products.Household;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

public class ShoppingCart implements IShoppingCart{
  private HashMap<Grocery, Double> groceryProductsInCart;
  private HashMap<Household, Double> householdProductsInCart;

  public ShoppingCart() {
    this.groceryProductsInCart = new HashMap<>();
    this.householdProductsInCart = new HashMap<>();
  }

  public HashMap<Grocery, Double> getGroceryProductsInCart() {
    return this.groceryProductsInCart;
  }

  public HashMap<Household, Double> getHouseholdProductsInCart() {
    return this.householdProductsInCart;
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
    return Objects.equals(this.getGroceryProductsInCart(), that.getGroceryProductsInCart())
        && Objects.equals(this.getHouseholdProductsInCart(), that.getHouseholdProductsInCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getGroceryProductsInCart(), this.getHouseholdProductsInCart());
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
        "groceryProductsInCart=" + this.getGroceryProductsInCart() +
        ", householdProductsInCart=" + this.getHouseholdProductsInCart() +
        '}';
  }

  @Override
  public Double totalCostOfCart() {
    Double totalCostOfHousehold = getTotalCostOfHousehold();
    Double totalCostOfGrocery = getTotalCostOfGrocery();
    return totalCostOfGrocery + totalCostOfHousehold;
  }

  private Double getTotalCostOfGrocery() {
    Double totalAmount = 0.0;

    for (Entry<Grocery, Double> entry : this.getGroceryProductsInCart().entrySet()) {
      Grocery product = entry.getKey();
      Double qty = entry.getValue();
      totalAmount += product.getPrice() * qty;
    }
    return totalAmount;
  }

  private Double getTotalCostOfHousehold() {
    Double totalAmount = 0.0;

    for (Entry<Household, Double> entry : this.getHouseholdProductsInCart().entrySet()) {
      Household product = entry.getKey();
      Double qty = entry.getValue();
      totalAmount += product.getPrice() * qty;
    }
    return totalAmount;
  }

  public void addProduct(Grocery groceryProduct, Double quantity) {
    this.getGroceryProductsInCart().put(groceryProduct, quantity);
  }

  public void addProduct(Household householdProduct, Double quantity) {
    this.getHouseholdProductsInCart().put(householdProduct, quantity);
  }
}
