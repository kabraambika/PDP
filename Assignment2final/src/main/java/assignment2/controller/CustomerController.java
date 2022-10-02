package assignment2.controller;

import assignment2.customers.Customer;
import assignment2.exceptions.QuantityExceededException;
import assignment2.products.AbstractProduct;
import assignment2.view.CustomerView;

public class CustomerController {
  private Customer customer;

  public CustomerController(Customer customer) {
    this.customer = customer;
    CustomerView.showAllProducts();
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void addProductInCart(AbstractProduct product) {
    getCustomer().getShoppingCart().addProduct(product);
  }

  public void addProductInCart(AbstractProduct product, Double qty) {
    getCustomer().getShoppingCart().addProduct(product, qty);
  }
}
