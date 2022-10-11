package assignment2.stocks;

import assignment2.products.IProduct;

/**
 * StockItem is a generic class for all the subclasses of AbstractProduct. This generic class
 * extends Pair class which takes two objects. First one is T and second one is Double. This generic
 * class implements IStock interface. It contains the following information: A generic product,
 * represented as T Quantity, represented as Double, here quantity means The quantity of this
 * product that the supermarket has in stock.
 *
 * @param <T> Generic type of product, here T is upper bounded by AbstractProduct so only subClasses
 *            of AbstractProduct are allowed.
 */
public class StockItem<T extends IProduct> extends Pair<T, Double> implements IStock<T> {

  /**
   * @param first  product, represented as T generic type
   * @param second quantity, represented by Double
   */
  public StockItem(T first, Double second) {
    super(first, second);
  }

  /**
   * Getter for product, which returns first object of Pair
   *
   * @return product, represented as T generic type
   */
  public T getProduct() {
    return super.getFirst();
  }

  /**
   * Setter for first object in pair
   *
   * @param product Any product, represented as T generic type
   */
  public void setProduct(T product) {
    this.first = product;
  }

  /**
   * Getter of quantity, which returns second object of pair
   *
   * @return quantity, represented by Double
   */
  public Double getQuantity() {
    return super.getSecond();
  }

  /**
   * Setter for second object in pair
   *
   * @param quantity product quantity in stock, represented by Double
   */
  public void setQuantity(Double quantity) {
    this.second = quantity;
  }

  /**
   * @param product represented as generic type of product
   * @param qty     represented as Double, quantity of product needed by customer for purchase
   * @return boolean, checks whether product is similar or not and quantity required is less than
   * quantity present in stock
   */
  @Override
  public <T extends IProduct> boolean hasEnoughItems(T product, Double qty) {
    return product.equals(this.getProduct()) && this.validateQty(qty);
  }

  /**
   * This function reduces the quantity of product in the event of purchase. It contains try and
   * catch block for QuantityExceededException custom exception
   *
   * @param product represented as generic type of product
   * @param qty     Represented as Double, quantity of product purchased
   */
  @Override
  public void reduceQuantity(T product, Double qty) {
    if (product.equals(this.getProduct())) {
      if (validateQty(qty)) {
        Double reducedQty = this.getQuantity() - qty;
        this.setQuantity(reducedQty);
      } else {
        throw new QuantityExceededException(
            qty + " quantity needed is greater than quantity available " + this.getQuantity());
      }
    }
  }

  /**
   * @param qty product quantity purchased by customer
   * @return boolean, check if quantity in stock is greater than or equal to quantity needed by
   * customer
   */
  private boolean validateQty(Double qty) {
    return this.getQuantity() >= qty;
  }

  @Override
  public String toString() {
    return "StockItem{" +
        "product=" + this.getProduct() +
        ", quantity=" + this.getQuantity() +
        '}';
  }
}