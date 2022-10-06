package assignment2.problem1.pickupOrder;

import assignment2.problem1.inventory.Inventory;
import assignment2.problem1.products.Grocery;
import assignment2.problem1.products.Household;

public class CustomerController {
  private final Customer customer;
  public static final Double SINGLE_QUANTITY = 1.0;
  private Inventory inventory = Inventory.getInstance();

  public CustomerController(Customer customer) {
    this.customer = customer;
  }

  public String viewAllProducts() {
    return this.inventory.toString();
  }

  public void addProductInCart(Grocery groceryProduct) {
    addProductInCart(groceryProduct, SINGLE_QUANTITY);
  }

  public void addProductInCart(Grocery groceryProduct, Double quantity) {
    try {
      if(validateProduct(groceryProduct, quantity)) {
        customer.getShoppingCart().addProduct(groceryProduct, quantity);
      }
      else {
        throw new QuantityExceededException("You are trying to add more quantity than available quantity !");
      }
    }
    catch (QuantityExceededException ex) {
      ex.printStackTrace();
    }
  }

  public void addProductInCart(Household householdProduct) {
    addProductInCart(householdProduct, SINGLE_QUANTITY);
  }

  public void addProductInCart(Household householdProduct, Double quantity) {
    try {
      if(validateProduct(householdProduct, quantity)) {
        customer.getShoppingCart().addProduct(householdProduct, quantity);
      }
      else {
        throw new QuantityExceededException("You are trying to add more quantity than available quantity !");
      }
    }
    catch (QuantityExceededException ex) {
      ex.printStackTrace();
    }
  }

  private boolean validateProduct(Grocery groceryProduct, Double quantity) {
    return inventory.isValidProduct(groceryProduct, quantity);
  }
  private boolean validateProduct(Household householdProduct, Double quantity) {
    return inventory.isValidProduct(householdProduct, quantity);
  }
}
