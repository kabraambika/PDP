/**
 * Represent name length exception for exceeding 15 characters
 */
public class NameLengthException extends RuntimeException {

  /**
   * serialization id to avoid serialization related bugs
   */
  public static final long serialVersionUID = 4328743;
  /**
   * NameLengthException constructor
   * @param message message shown for exception
   */
  public NameLengthException(String message) {
    super(message);
  }
}
