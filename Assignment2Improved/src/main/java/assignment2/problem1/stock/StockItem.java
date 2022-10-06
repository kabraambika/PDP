package assignment2.problem1.stock;
import java.util.Objects;

/**
 * StockItem is an abstract class and implements IStock interface.
 * This provides information of product's quantity.
 * @author kabraambika19
 */
public abstract class StockItem implements IStock{
  protected Double quantity;

  /**
   * @param quantity The quantity of this product that the supermarket has in stock, represented as a Double
   */
  protected StockItem(Double quantity) {
    this.quantity = quantity;
  }

  /**
   * Getter of quantity property
   * @return this.quantity
   */
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
    return Objects.equals(this.getQuantity(), stockItem.getQuantity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getQuantity());
  }

  @Override
  public String toString() {
    return "StockItem{" +
        "quantity=" + this.getQuantity() +
        '}';
  }

  /**
   * @param quantity quantity needed to purchase a product
   * @return represented as a Boolean, true if stock has greater than or equal to quantity needed, false if stock has less quantity than quantity needed
   */
  @Override
  public Boolean hasEnoughItemsInStock(Double quantity) {
    return this.getQuantity() >= quantity;
  }
  /**
   * @param quantity quantity of product which is needed to be reduced from current quantity of
   *                 product
   */
  @Override
  public void reduceQuantity(Double quantity) {
    this.quantity -= quantity;
  }

  /**
   * @param quantity product quantity which needed to be added
   */
  public void increaseQuantity(Double quantity) {
    this.quantity += quantity;
  }
}
