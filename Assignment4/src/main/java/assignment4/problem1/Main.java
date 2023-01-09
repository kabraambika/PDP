package assignment4.problem1;

/**
 * Main class
 *
 * @author vrindabisani and kabraambika19
 */
public class Main {

  /**
   * Main method
   *
   * @param args path to grammar directory
   * @throws InvalidInputException if user does not input directory path
   * @throws EmptyDirectoryException if user gives directory path which does not have grammar files
   * @throws DirectoryDoesNotExistException if directory does not exist
   */
  public static void main(String[] args)
      throws InvalidInputException, EmptyDirectoryException, DirectoryDoesNotExistException {
    if(args.length == 0){
      throw new InvalidInputException("Directory path not given");
    }
    CommandLineParser commandLineParser = new CommandLineParser();
    commandLineParser.start(args[0]);
  }
}
