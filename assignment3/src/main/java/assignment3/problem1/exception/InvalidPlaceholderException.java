package assignment3.problem1.exception;

/**
 * InvalidPlaceholderException is a custom exception class which extends Exception class.
 * InvalidPlaceholderException is thrown when there is no value provided in CSV file for placeholders in templates.
 * @author kabraambika19
 */
public class InvalidPlaceholderException extends Exception {

  /**
   * Constructor of InvalidPlaceholderException
   * @param errorMessage error message specified while throwing exception
   */
  public InvalidPlaceholderException(String errorMessage) {
    super(errorMessage);
  }
}
