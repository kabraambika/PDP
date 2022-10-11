package assignment2.pickupsystem;

/**
 * This custom exception is thrown when a customer age is less than 0, extends RuntimeException
 *
 * @author kabraambika19
 */
public class InvalidAgeException extends RuntimeException {

  /**
   * @param message error message
   */
  public InvalidAgeException(String message) {
    super(message);
  }
}
