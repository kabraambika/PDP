package assignment2.products;

/**
 * This custom class exception is thrown when minimum age to purchase a product is given less than
 * zero while creating any product in system. This exception throws RuntimeException
 *
 * @author kabraambika19
 */
public class InvalidMinimumAgeException extends RuntimeException {

  /**
   * Constructor of exception
   *
   * @param message error message shown while throwing exception
   */
  public InvalidMinimumAgeException(String message) {
    super(message);
  }
}
