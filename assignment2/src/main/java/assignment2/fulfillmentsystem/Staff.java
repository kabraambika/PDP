package assignment2.fulfillmentsystem;

import assignment2.inventory.Inventory;
import assignment2.pickupsystem.Customer;
import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.IProduct;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Supermarket Staff performs the online pickup order fulfillment and processing. supermarket staff
 * fulfill the order by gathering all the items in the cart ready for pickup. sometimes items that
 * were in stock when the customer placed their order are out of stock by the time the order is
 * fulfilled. In this case, the supermarket will substitute the original item. Once all the items in
 * the shopping cart and any necessary substitutions have been gathered the order is processed and a
 * receipt is returned summarizing the order.
 *
 * @author kabraambika19
 */
public class Staff {

  /**
   * Constant for minimum amount
   */
  private static final Double MIN_AMOUNT = 0.0;
  private Map<AbstractGrocery, Double> finalGroceries;
  private Map<AbstractHousehold, Double> finalHouseholds;
  private Map<IProduct, Double> outStockProducts;
  private Map<IProduct, Double> removedProducts;
  private Inventory inventorySystem;

  /**
   * Constructor of Staff class
   */
  public Staff() {
    this.inventorySystem = Inventory.getInstance();
    this.finalGroceries = new HashMap<>();
    this.finalHouseholds = new HashMap<>();
    this.outStockProducts = new HashMap<>();
    this.removedProducts = new HashMap<>();
  }

  /**
   * @return this.finalGroceries
   */
  public Map<AbstractGrocery, Double> getFinalGroceries() {
    return this.finalGroceries;
  }

  /**
   * @return this.finalHouseholds
   */
  public Map<AbstractHousehold, Double> getFinalHouseholds() {
    return this.finalHouseholds;
  }

  /**
   * @return this.outStockProducts
   */
  public Map<IProduct, Double> getOutStockProducts() {
    return this.outStockProducts;
  }

  /**
   * @return this.removedProducts
   */
  public Map<IProduct, Double> getRemovedProducts() {
    return this.removedProducts;
  }

  /**
   * This method fulfill the order by gathering all the items in the cart ready for pickup
   *
   * @param customer Customer instance
   */
  public void fulfillOrder(Customer customer) {
    Map<AbstractGrocery, Double> groceryCart = customer.getCart().getGroceryProducts();
    Map<AbstractHousehold, Double> householdCart = customer.getCart().getHouseholdProducts();

    this.fulfillGroceryOrder(groceryCart);
    this.fulfillHouseholdOrder(householdCart);
  }

  /**
   * By this method, Once all the items in the shopping cart and any necessary substitutions have
   * been gathered the order is processed, which involves the following steps. a. Any items the
   * customer is not old enough to buy are removed from the cart. b. The quantities of all stock
   * items purchased are updated in the system. c. The customer shopping cart is emptied. d. A
   * receipt is returned summarizing the order.
   *
   * @param customer Customer instance
   * @return Receipt
   */
  public Receipt processOrder(Customer customer) {
    this.removeGroceryProducts(customer.getCustomerDetails().getAge());
    this.removeHouseholdProducts(customer.getCustomerDetails().getAge());
    this.updateInventoryQuantity();
    this.clearCustomerCart(customer);
    return this.summarizeOrder();
  }

  private Receipt summarizeOrder() {
    Map<IProduct, Double> productsReceived = this.addAllProducts();
    Double totalPricePaid = this.getTotalPricePaid(productsReceived);
    Map<IProduct, Double> outStockProducts = this.getOutStockProducts();
    Map<IProduct, Double> removedProducts = this.getRemovedProducts();
    return new Receipt(totalPricePaid, productsReceived, outStockProducts, removedProducts);
  }

  private Map<IProduct, Double> addAllProducts() {
    Map<IProduct, Double> productsReceived = new HashMap<>();
    productsReceived.putAll(this.getFinalGroceries());
    productsReceived.putAll(this.getFinalHouseholds());
    return productsReceived;
  }

  private Double getTotalPricePaid(Map<IProduct, Double> productsReceived) {
    Double totalAmt = MIN_AMOUNT;
    for (Entry<IProduct, Double> productEntry : productsReceived.entrySet()) {
      IProduct product = productEntry.getKey();
      Double qty = productEntry.getValue();
      totalAmt += product.getPrice() * qty;
    }
    return totalAmt;
  }

  private void clearCustomerCart(Customer customer) {
    customer.resetCart();
  }

  private void updateInventoryQuantity() {
    this.updateGroceryInventory();
    this.updateHouseholdInventory();
  }

  private void updateGroceryInventory() {
    for (Entry<AbstractGrocery, Double> productEntry : this.getFinalGroceries().entrySet()) {
      AbstractGrocery product = productEntry.getKey();
      Double qty = productEntry.getValue();
      this.inventorySystem.decreaseGroceryStock(product, qty);
    }
  }

  private void updateHouseholdInventory() {
    for (Entry<AbstractHousehold, Double> productEntry : this.getFinalHouseholds().entrySet()) {
      AbstractHousehold product = productEntry.getKey();
      Double qty = productEntry.getValue();
      this.inventorySystem.decreaseHouseholdStock(product, qty);
    }
  }

  private void removeGroceryProducts(Integer customerAge) {
    Map<AbstractGrocery, Double> removedGrocery = new HashMap<>();
    for (Entry<AbstractGrocery, Double> productEntry : this.getFinalGroceries().entrySet()) {
      AbstractGrocery product = productEntry.getKey();
      Double qty = productEntry.getValue();

      if (product.getMinimumAge() > customerAge) {
        this.addProductInRemovedProducts(product, qty);
        removedGrocery.put(product, qty);
      }
    }
    this.removeGroceryProduct(removedGrocery);
  }

  private void removeHouseholdProducts(Integer customerAge) {
    Map<AbstractHousehold, Double> ageRestrictedHousehold = new HashMap<>();
    for (Entry<AbstractHousehold, Double> productEntry : this.getFinalHouseholds().entrySet()) {
      AbstractHousehold product = productEntry.getKey();
      Double qty = productEntry.getValue();

      if (product.getMinimumAge() > customerAge) {
        this.addProductInRemovedProducts(product, qty);
        ageRestrictedHousehold.put(product, qty);
      }
    }
    this.removeHouseholdProduct(ageRestrictedHousehold);
  }

  private void removeGroceryProduct(Map<AbstractGrocery, Double> products) {
    this.getFinalGroceries().remove(products.keySet());
  }

  private void removeHouseholdProduct(Map<AbstractHousehold, Double> products) {
    this.getFinalHouseholds().remove(products.keySet());
  }

  private void addProductInRemovedProducts(IProduct product, Double qty) {
    this.getRemovedProducts().put(product, qty);
  }

  private void fulfillGroceryOrder(Map<AbstractGrocery, Double> groceryCart) {
    for (Entry<AbstractGrocery, Double> groceryEntry : groceryCart.entrySet()) {
      AbstractGrocery grocery = groceryEntry.getKey();
      Double qty = groceryEntry.getValue();

      if (this.inventorySystem.validateProductQty(grocery, qty)) {
        this.addProductInFinalOrder(grocery, qty);
      } else {
        this.substituteProduct(grocery, qty, groceryCart);
      }
    }
  }

  private void fulfillHouseholdOrder(Map<AbstractHousehold, Double> householdCart) {
    for (Entry<AbstractHousehold, Double> householdEntry : householdCart.entrySet()) {
      AbstractHousehold household = householdEntry.getKey();
      Double qty = householdEntry.getValue();

      if (this.inventorySystem.validateProductQty(household, qty)) {
        this.addProductInFinalOrder(household, qty);
      } else {
        this.substituteProduct(household, qty, householdCart);
      }
    }
  }

  private void substituteProduct(AbstractGrocery grocery, Double qty,
      Map<AbstractGrocery, Double> groceryCart) {
    AbstractGrocery similarGrocery = this.inventorySystem.similarProduct(grocery, qty);
    if (similarGrocery != null) {
      Double qtyInCustomerCart = groceryCart.getOrDefault(similarGrocery, MIN_AMOUNT);
      if (this.inventorySystem.validateProductQty(similarGrocery, qtyInCustomerCart + qty)) {
        this.addProductInFinalOrder(similarGrocery, qty);
      } else {
        this.addProductInOutOfStock(grocery, qty);
      }
    } else {
      this.addProductInOutOfStock(grocery, qty);
    }
  }

  private void substituteProduct(AbstractHousehold household, Double qty,
      Map<AbstractHousehold, Double> householdCart) {
    AbstractHousehold similarProduct = this.inventorySystem.similarProduct(household, qty);
    if (similarProduct == null) {
      this.addProductInOutOfStock(household, qty);
    } else {
      Double qtyInCustomerCart = householdCart.getOrDefault(similarProduct, MIN_AMOUNT);
      if (this.inventorySystem.validateProductQty(similarProduct, qtyInCustomerCart + qty)) {
        this.addProductInFinalOrder(similarProduct, qty);
      } else {
        this.addProductInOutOfStock(household, qty);
      }
    }
  }

  private void addProductInOutOfStock(AbstractGrocery grocery, Double qty) {
    this.getOutStockProducts().put(grocery, qty);
  }

  private void addProductInOutOfStock(AbstractHousehold household, Double qty) {
    this.getOutStockProducts().put(household, qty);
  }

  private void addProductInFinalOrder(AbstractGrocery grocery, Double qty) {
    if (this.getFinalGroceries().containsKey(grocery)) {
      Double prevQty = this.getFinalGroceries().get(grocery);
      this.getFinalGroceries().put(grocery, prevQty + qty);
    } else {
      this.getFinalGroceries().put(grocery, qty);
    }
  }

  private void addProductInFinalOrder(AbstractHousehold household, Double qty) {
    if (this.getFinalHouseholds().containsKey(household)) {
      Double prevQty = this.getFinalHouseholds().get(household);
      this.getFinalHouseholds().put(household, prevQty + qty);
    } else {
      this.getFinalHouseholds().put(household, qty);
    }
  }
}
