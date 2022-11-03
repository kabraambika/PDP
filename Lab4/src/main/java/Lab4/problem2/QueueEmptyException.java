package Lab4.problem2;

/**
 * Exception class thrown when empty queue and extends RuntimeException
 */
public class QueueEmptyException extends RuntimeException {

  /**
   * Constructor
   * @param error error message
   */
  public QueueEmptyException(String error) {
    super(error);
  }
}
