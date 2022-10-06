package assignment2.problem1.pickupOrder;

import assignment2.problem1.products.AbstractProduct;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Receipt {
  private Double totalPricePaid;
  private HashMap<AbstractProduct, Double> productsReceived;
  private HashMap<AbstractProduct, Double> outOfStockProducts;
  private Set<AbstractProduct> removedProducts;

  public Receipt(Double totalPricePaid, HashMap<AbstractProduct, Double> productsReceived,
      HashMap<AbstractProduct, Double> outOfStockProducts, Set<AbstractProduct> removedProducts) {
    this.totalPricePaid = totalPricePaid;
    this.productsReceived = productsReceived;
    this.outOfStockProducts = outOfStockProducts;
    this.removedProducts = removedProducts;
  }

  public Double getTotalPricePaid() {
    return this.totalPricePaid;
  }

  public HashMap<AbstractProduct, Double> getProductsReceived() {
    return this.productsReceived;
  }

  public HashMap<AbstractProduct, Double> getOutOfStockProducts() {
    return this.outOfStockProducts;
  }

  public Set<AbstractProduct> getRemovedProducts() {
    return this.removedProducts;
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
    return Objects.equals(getTotalPricePaid(), receipt.getTotalPricePaid())
        && Objects.equals(getProductsReceived(), receipt.getProductsReceived())
        && Objects.equals(getOutOfStockProducts(), receipt.getOutOfStockProducts())
        && Objects.equals(getRemovedProducts(), receipt.getRemovedProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTotalPricePaid(), getProductsReceived(), getOutOfStockProducts(),
        getRemovedProducts());
  }

  @Override
  public String toString() {
    return "Receipt{" +
        "totalPricePaid=" + this.totalPricePaid +
        ", productsReceived=" + this.productsReceived +
        ", outOfStockProducts=" + this.outOfStockProducts +
        ", removedProducts=" + this.removedProducts +
        '}';
  }
}
