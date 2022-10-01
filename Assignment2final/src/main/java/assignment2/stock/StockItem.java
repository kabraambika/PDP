package assignment2.stock;

import assignment2.products.AbstractProduct;
import java.util.Objects;

public class StockItem {
  private AbstractProduct product;
  private Double quantity;

  public StockItem(AbstractProduct product, Double quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public AbstractProduct getProduct() {
    return this.product;
  }

  public Double getQuantity() {
    return this.quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StockItem stockItem = (StockItem) o;
    return Objects.equals(getProduct(), stockItem.getProduct()) && Objects.equals(
        getQuantity(), stockItem.getQuantity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProduct(), getQuantity());
  }

  @Override
  public String toString() {
    return "StockItem{" +
        "product=" + getProduct() +
        ", quantity=" + getQuantity() +
        '}';
  }
}
