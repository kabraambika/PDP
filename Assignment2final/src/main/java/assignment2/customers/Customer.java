package assignment2.customers;

import java.util.Objects;

public class Customer {
  private Name name;
  private Integer age;
  private ShoppingCart shoppingCart;

  public Customer(Name name, Integer age) {
    this.name = name;
    this.age = age;
    this.shoppingCart = ShoppingCart.getInstance();
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(getName(), customer.getName()) && Objects.equals(
        getAge(), customer.getAge()) && Objects.equals(getShoppingCart(),
        customer.getShoppingCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge(), getShoppingCart());
  }

  @Override
  public String toString() {
    return "Customer{" +
        "name=" + name +
        ", age=" + age +
        ", shoppingCart=" + shoppingCart +
        '}';
  }
}
