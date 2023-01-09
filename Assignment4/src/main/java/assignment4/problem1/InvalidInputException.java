package assignment4.problem1;

/**
 * Throws exception if user inputs invalid input
 *
 * @author vrindabisani and kabraambika19
 */
public class InvalidInputException extends RuntimeException {

  /**
   * constructor
   *
   * @param errorMessage error message
   */
  public InvalidInputException(String errorMessage) {
    super(errorMessage);
  }
}
