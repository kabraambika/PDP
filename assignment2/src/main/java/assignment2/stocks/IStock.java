package assignment2.stocks;

import assignment2.products.IProduct;

/**
 * IStock contains the contract for StockItem. This interface will need to support the following
 * functionality for stock Check if there are enough items in stock to complete a purchase. Reduce
 * the quantity of the item in the event of a purchase. You should not allow a purchase to go ahead
 * if there are not enough items in stock
 *
 * @param <T> Generic type of Product as T is upper bounded by AbstractProduct
 * @author kabraambika19
 */
public interface IStock<T extends IProduct> {

  /**
   * Constant for single quantity
   */
  Double SINGLE_QTY = 1.0;

  /**
   * @param product represented as generic type of product
   * @param <T>     for generic product type upper bounded by IProduct
   * @return Boolean, Check if there are more than one item in stock to complete a purchase
   */
  default <T extends IProduct> boolean hasEnoughItems(T product) {
    return this.hasEnoughItems(product, SINGLE_QTY);
  }

  /**
   * @param product represented as generic type of product
   * @param <T>     for generic product type upper bounded by IProduct
   * @param qty     represented as Double, quantity of product needed by customer for purchase
   * @return Boolean, Check if there are more than quantity needed by customer in stock to complete
   * a purchase
   */
  <T extends IProduct> boolean hasEnoughItems(T product, Double qty);

  /**
   * Reduce single quantity of product in stock in the event of purchase
   *
   * @param product represented as generic type of product
   */
  default void reduceQuantity(T product) {
    this.reduceQuantity(product, SINGLE_QTY);
  }

  /**
   * Reduce given quantity of product as input from the stock in the event of purchase
   *
   * @param product represented as generic type of product
   * @param qty     Represented as Double, quantity of product purchased
   */
  void reduceQuantity(T product, Double qty);
}
