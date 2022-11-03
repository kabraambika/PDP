package assignment3.problem1.exception;

/**
 * InvalidArgumentsException is a custom exception class for invalid arguments, this class extends Exception class
 * @author kabraambika19
 */
public class InvalidArgumentsException extends Exception {

  /**
   * Constructor of InvalidArgumentsException
   * @param errorMessage error message specified while throwing exception
   */
  public InvalidArgumentsException(String errorMessage) {
    super(errorMessage);
  }
}