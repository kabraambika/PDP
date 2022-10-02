package assignment2.customers;

import assignment2.products.AbstractProduct;
import java.util.Map;
import java.util.Objects;

public class Receipt {
  Name name;
  Integer age;
  Double totalPricePaid;
  Map<AbstractProduct, Double> cartItems;
  Map<AbstractProduct, Double> outOfStockItems;
  Map<AbstractProduct, Double> ageRestrictedItems;

  public Receipt(Name name, Integer age, Double totalPricePaid, Map<AbstractProduct, Double> cartItems, Map<AbstractProduct, Double> outOfStockItems, Map<AbstractProduct, Double> ageRestrictedItems) {
    this.name = name;
    this.age = age;
    this.totalPricePaid = totalPricePaid;
    this.cartItems = cartItems;
    this.outOfStockItems = outOfStockItems;
    this.ageRestrictedItems = ageRestrictedItems;
  }

  public Name getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  public Double getTotalPricePaid() {
    return this.totalPricePaid;
  }

  public Map<AbstractProduct, Double> getCartItems() {
    return this.cartItems;
  }

  public Map<AbstractProduct, Double> getOutOfStockItems() {
    return this.outOfStockItems;
  }

  public Map<AbstractProduct, Double> getAgeRestrictedItems() {
    return this.ageRestrictedItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Receipt receipt = (Receipt) o;
    return Objects.equals(getName(), receipt.getName()) && Objects.equals(
        getAge(), receipt.getAge()) && Objects.equals(getTotalPricePaid(),
        receipt.getTotalPricePaid()) && Objects.equals(getCartItems(),
        receipt.getCartItems()) && Objects.equals(getOutOfStockItems(),
        receipt.getOutOfStockItems()) && Objects.equals(getAgeRestrictedItems(),
        receipt.getAgeRestrictedItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge(), getTotalPricePaid(), getCartItems(),
        getOutOfStockItems(), getAgeRestrictedItems());
  }

  @Override
  public String toString() {
    return "Receipt{" +
        "name=" + getName() +
        ", age=" + getAge() +
        ", totalPricePaid=" + getTotalPricePaid() +
        ", cartItems=" + getCartItems() +
        ", outOfStockItems=" + getOutOfStockItems() +
        ", ageRestrictedItems=" + getAgeRestrictedItems() +
        '}';
  }
}
