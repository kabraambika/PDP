package assignment2.stocks;

/**
 * This is a custom exception class which extends RuntimeException. this exception is thrown when
 * there are not enough items in stock.
 */
public class QuantityExceededException extends RuntimeException {

  /**
   * @param message error message shown to customer
   */
  public QuantityExceededException(String message) {
    super(message);
  }
}
