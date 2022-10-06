package assignment2.problem1.pickupOrder;

import assignment2.problem1.inventory.Inventory;
import assignment2.problem1.products.AbstractProduct;
import assignment2.problem1.products.Grocery;
import assignment2.problem1.products.Household;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class SupermarketStaff {
  private HashMap<Grocery, Double> finalGroceryProducts = new HashMap<>();
  private HashMap<Household, Double> finalHouseholdProducts = new HashMap<>();
  private HashMap<Grocery, Double> outOfStockGrocery = new HashMap<>();
  private HashMap<Household, Double> outOfStockHouseholdProduct = new HashMap<>();
  private Set<Grocery> removedGrocery = new HashSet<>();
  private Set<Household> removedHousehold = new HashSet<>();
  Inventory inventory = Inventory.getInstance();

  public void fulfillOrder(Customer customer) {
    HashMap<Grocery, Double> groceryProductsInCart = customer.getShoppingCart()
        .getGroceryProductsInCart();
    HashMap<Household, Double> householdProductsInCart = customer.getShoppingCart()
        .getHouseholdProductsInCart();

    this.prepareGroceryPickupOrder(groceryProductsInCart);
    this.prepareHouseholdPickupOrder(householdProductsInCart);

    this.removeOutOfStockGrocery();
    this.removeOutOfStockHousehold();
  }

  private void removeOutOfStockGrocery() {
    this.finalGroceryProducts.keySet().removeAll(this.outOfStockGrocery.keySet());
  }

  private void removeOutOfStockHousehold() {
    this.finalHouseholdProducts.keySet().removeAll(this.outOfStockHouseholdProduct.keySet());
  }

  public Receipt processOrder(Customer customer) {
    this.removeAgeRestrictedGroceryProducts(customer.getAge());
    this.removeAgeRestrictedHouseProducts(customer.getAge());

    inventory.decreaseGroceryItems(this.finalGroceryProducts);
    inventory.decreaseHouseholdItems(this.finalHouseholdProducts);

    Double totalPricePaid = this.getFinalAmountPaid();

    this.clearShoppingCart(customer);

    Receipt receipt =  createReceipt(totalPricePaid, this.finalGroceryProducts, this.finalHouseholdProducts, this.outOfStockGrocery, this.outOfStockHouseholdProduct, this.removedGrocery, this.removedHousehold);

    return receipt;
  }

  private Double getFinalAmountPaid() {
    Double totalCostOfHousehold = getTotalCostOfHousehold();
    Double totalCostOfGrocery = getTotalCostOfGrocery();
    return totalCostOfGrocery + totalCostOfHousehold;
  }

  private Double getTotalCostOfGrocery() {
    Double totalAmount = 0.0;

    for (Entry<Grocery, Double> entry : this.finalGroceryProducts.entrySet()) {
      Grocery product = entry.getKey();
      Double qty = entry.getValue();
      totalAmount += product.getPrice() * qty;
    }
    return totalAmount;
  }

  private Double getTotalCostOfHousehold() {
    Double totalAmount = 0.0;

    for (Entry<Household, Double> entry : this.finalHouseholdProducts.entrySet()) {
      Household product = entry.getKey();
      Double qty = entry.getValue();
      totalAmount += product.getPrice() * qty;
    }
    return totalAmount;
  }

  private Receipt createReceipt(Double totalPricePaid, HashMap<Grocery, Double> finalGroceryProducts, HashMap<Household, Double> finalHouseholdProducts, HashMap<Grocery, Double> outOfStockGrocery, HashMap<Household, Double> outOfStockHouseholdProduct, Set<Grocery> removedGrocery, Set<Household> removedHousehold) {
    HashMap<AbstractProduct, Double> products = new HashMap<>();
    products.putAll(finalGroceryProducts);
    products.putAll(finalHouseholdProducts);

    HashMap<AbstractProduct, Double> outOfStockProducts = new HashMap<>();
    outOfStockProducts.putAll(outOfStockGrocery);
    outOfStockProducts.putAll(outOfStockHouseholdProduct);

    Set<AbstractProduct> removedProducts = new HashSet<>();
    removedProducts.addAll(removedGrocery);
    removedProducts.addAll(removedHousehold);

    return new Receipt(totalPricePaid, products, outOfStockProducts, removedProducts);
  }

  private void clearShoppingCart(Customer customer) {
    customer.emptyShoppingCart();
  }

  private void removeAgeRestrictedHouseProducts(Integer customerAge) {
    this.finalHouseholdProducts.keySet().forEach(product -> {
      if(product.getMinimumAge() > customerAge) {
        this.removedHousehold.add(product);
      }
    });
    this.updateHouseholdProducts();
  }

  private void updateHouseholdProducts() {
    this.finalHouseholdProducts.keySet().removeAll(this.removedHousehold);
  }

  private void removeAgeRestrictedGroceryProducts(Integer customerAge) {
    this.finalGroceryProducts.keySet().forEach(product -> {
      if(product.getMinimumAge() > customerAge) {
        this.removedGrocery.add(product);
      }
    });

    this.updateGroceryProducts();
  }

  private void updateGroceryProducts() {
    this.finalGroceryProducts.keySet().removeAll(this.removedGrocery);
  }

  private void prepareHouseholdPickupOrder(HashMap<Household, Double> householdProductInCart) {
    householdProductInCart.forEach((product, quantity) -> {
      if(validateProduct(product, quantity)) {
        this.finalHouseholdProducts.put(product, quantity);
      }
      else {
        Household similarProduct  = substituteProduct(product, quantity);

        if(similarProduct == null) {
          this.outOfStockHouseholdProduct.put(product, quantity);
        }
        else {
          this.finalHouseholdProducts.put(similarProduct, quantity);
        }
      }
    });
  }

  private void prepareGroceryPickupOrder(HashMap<Grocery, Double> productsInCart) {
    productsInCart.forEach((product, quantity) -> {
      if(validateProduct(product, quantity)) {
        this.finalGroceryProducts.put(product, quantity);
      }
      else {
        Grocery similarProduct  = substituteProduct(product, quantity);

        if(similarProduct == null) {
          this.outOfStockGrocery.put(product, quantity);
        }
        else {
          this.finalGroceryProducts.put(similarProduct, quantity);
        }
      }
    });
  }

  private Household substituteProduct(Household product, Double quantity) {
    return this.inventory.getSimilarProduct(product, quantity);
  }

  private Grocery substituteProduct(Grocery product, Double quantity) {
    return this.inventory.getSimilarProduct(product, quantity);
  }

  private boolean validateProduct(Grocery product, Double quantity) {
    return this.inventory.isValidProduct(product, quantity);
  }

  private boolean validateProduct(Household product, Double quantity) {
    return this.inventory.isValidProduct(product, quantity);
  }
}
