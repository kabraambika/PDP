package assignment4.problem1;

public class DirectoryDoesNotExistException extends RuntimeException {

  public DirectoryDoesNotExistException(String errMessage) {
    super(errMessage);
  }
}
