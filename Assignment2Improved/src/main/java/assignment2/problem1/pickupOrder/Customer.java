package assignment2.problem1.pickupOrder;

import java.util.Objects;

public class Customer {
  private Name name;
  private Integer age;
  private ShoppingCart shoppingCart;

  public Customer(Name name, Integer age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = new ShoppingCart();
  }

  public Customer(Name name, Integer age, ShoppingCart shoppingCart) {
    this.name = name;
    this.age = age;
    this.shoppingCart = shoppingCart;
  }

  public Name getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  public ShoppingCart getShoppingCart() {
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
    return Objects.equals(this.getName(), customer.getName()) && Objects.equals(
        this.getAge(), customer.getAge()) && Objects.equals(this.getShoppingCart(),
        customer.getShoppingCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.getAge(), this.getShoppingCart());
  }

  public Double getTotalCartCost() {
    return this.getShoppingCart().totalCostOfCart();
  }
  public void emptyShoppingCart() {
    this.shoppingCart = null;
  }
}
