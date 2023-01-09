package assignment4.problem1;

/**
 * InvalidJSONFileException is thrown when a file is invalid according to given conditions:
 * if json file is not valid as conditions like, file extension is not json, file does not exist, is not a file or can not be read
 * InvalidJSONFileException is a custom RuntimeException.
 *
 * @author kabraambika19 and vrindabisani
 */
public class InvalidJSONFileException extends RuntimeException {

  /**
   * Constructor of InvalidJSONFileException
   *
   * @param errorMessage error message specified while throwing exception
   */
  public InvalidJSONFileException(String errorMessage) {
    super(errorMessage);
  }
}
