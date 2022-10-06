package assignment2.problem1.stock;

/**
 * IStock is an interface for StockItem which provides functions like :
 * hasEnoughItemsInStock definition: Check if there are enough items in stock to complete a purchase
 * reduceQuantity definition: Reduce the quantity of the item in the event of a purchase.
 * @author kabraambika19
 */
public interface IStock {

  /**
   * Reduce the quantity of the item in the event of a purchase.
   * @param quantity quantity of product which is needed to be reduced from current quantity of product
   */
  void reduceQuantity(Double quantity);

  /**
   * Check if there are enough items in stock to complete a purchase
   * @param quantity quantity needed to purchase a product
   * @return represented as a Boolean, true if stock has greater than or equal to quantity needed, false if stock has less quantity than quantity needed
   */
  Boolean hasEnoughItemsInStock(Double quantity);

  /**
   * @param quantity product quantity which needed to be added
   */
  void increaseQuantity(Double quantity);
}
