package assignment1.problem1;

/**
 * Exception thrown when deposit object is not valid
 */
public class InvalidDepositException extends RuntimeException {

  /**
   * @param message Message shown if customer deposit are invalid
   */
  public InvalidDepositException(String message) {
    super(message);
  }
}
