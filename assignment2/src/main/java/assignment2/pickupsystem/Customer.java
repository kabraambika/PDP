package assignment2.pickupsystem;

import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import java.util.Objects;

/**
 * Customer class provides information of a person name, age and shoppingCart.
 *
 * @author kabraambika19
 */
public class Customer {

  /**
   * Constant for single quantity
   */
  private static final Double SINGLE_QUANTITY = 1.0;
  /**
   * Customer details provides information : name, age of customer, represented as CustomerDetails
   */
  private CustomerDetails customerDetails;
  /**
   * shoppingCart represented by ShoppingCart object
   */
  private ShoppingCart shoppingCart;

  /**
   * Constructor of Customer Creates a new shopping shoppingCart for customer
   *
   * @param customerDetails Customer details provides information : name, age of customer,
   *                        represented as CustomerDetails
   */
  public Customer(CustomerDetails customerDetails) {
    this.customerDetails = customerDetails;
    this.shoppingCart = new ShoppingCart();
  }

  /**
   * Getter for customerDetails property
   *
   * @return this.customerDetails, represented as CustomerDetails
   */
  public CustomerDetails getCustomerDetails() {
    return this.customerDetails;
  }

  /**
   * Getter for shoppingCart property
   *
   * @return this.shoppingCart
   */
  public ShoppingCart getCart() {
    return this.shoppingCart;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    return Objects.equals(this.getCustomerDetails(), customer.getCustomerDetails())
        && Objects.equals(this.getCart(), customer.getCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getCustomerDetails(), this.getCart());
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerDetails=" + this.getCustomerDetails() +
        ", shoppingCart=" + this.getCart() +
        '}';
  }

  /**
   * Add single product in shoppingCart
   *
   * @param grocery AbstractGrocery product, represented as AbstractGrocery
   */
  public void addProduct(AbstractGrocery grocery) {
    this.addProduct(grocery, SINGLE_QUANTITY);
  }

  /**
   * Add product with given quantity in shoppingCart
   *
   * @param grocery  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity product quantity needed to added in shoppingCart
   */
  public void addProduct(AbstractGrocery grocery, Double quantity) {
    this.getCart().addProductInCart(grocery, quantity);
  }

  /**
   * Add single product in shoppingCart
   *
   * @param household household product, represented as AbstractHousehold
   */
  public void addProduct(AbstractHousehold household) {
    this.addProduct(household, SINGLE_QUANTITY);
  }

  /**
   * Add product with given quantity in shoppingCart
   *
   * @param household household product, represented as AbstractHousehold
   * @param quantity  product quantity needed to added in shoppingCart
   */
  public void addProduct(AbstractHousehold household, Double quantity) {
    this.getCart().addProductInCart(household, quantity);
  }

  /**
   * this method set new shoppingCart for customer
   */
  public void resetCart() {
    this.shoppingCart = new ShoppingCart();
  }
}
