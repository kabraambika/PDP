package Lab3.problem4;

/**
 * If the provided value for age is outside of the range [0, 128], you should throw a custom-
 * built IncorrectAgeRangeException exception.
 */
public class IncorrectAgeRangeException extends RuntimeException {

  /**
   * @param message error message
   */
  public IncorrectAgeRangeException(String message) {
    super(message);
  }
}
