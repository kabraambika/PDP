package assignment4.problem1;

/**
 * Throws exception if directory does not exist
 *
 * @author vrindabisani and kabraambika19
 */
public class DirectoryDoesNotExistException extends RuntimeException {

  /**
   * constructor
   *
   * @param errorMessage error message
   */
  public DirectoryDoesNotExistException(String errorMessage) {
    super(errorMessage);
  }
}
