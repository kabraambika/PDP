package assignment1.problem1;

/**
 * Exception thrown when customer details are not valid , validations is done for unique account ID and name only
 */
public class InvalidCustomerException extends RuntimeException {

  /**
   * Constructor
   * @param message Message shown when customer details are not valid
   */
  public InvalidCustomerException(String message) {
    super(message);
  }
}
