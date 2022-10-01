package assignment2.customers;

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
}
