package assignment2.fulfillmentsystem;

/**
 * Customer can single or more grocery and AbstractHousehold products in cart, if not a valid
 * product and quantity given then InvalidQuantityException exception will be thrown
 */
public class InvalidQuantityException extends RuntimeException {

  /**
   * @param message error message
   */
  public InvalidQuantityException(String message) {
    super(message);
  }
}
