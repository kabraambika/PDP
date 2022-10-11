package Lab3.problem4;

/**
 * If the provided wealth value is negative, you should throw a
 * custom-built IncorrectWealthValueException exception.
 */
public class IncorrectWealthValueException extends RuntimeException {

  /**
   * @param message error message
   */
  public IncorrectWealthValueException(String message) {
    super(message);
  }
}
