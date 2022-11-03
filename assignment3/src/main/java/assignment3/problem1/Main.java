package assignment3.problem1;

import assignment3.problem1.exception.InvalidArgumentsException;
import assignment3.problem1.exception.InvalidPlaceholderException;
import java.io.IOException;

/**
 * Main is a main class to invoke automation according to parameters provided in main method.
 * @author kabraambika19
 */
public class Main {

  /**
   * Main method that needed to be invoked to run the application
   * @param args arrays of string as args provided by user in commandline
   */
  public static void main(String[] args) {
    try {
      InsuranceCompanyAutomation companyAutomation = new InsuranceCompanyAutomation(args);
      companyAutomation.startAutomationTool();
    }
    catch(InvalidArgumentsException | IOException | InvalidPlaceholderException argumentsException) {
      System.out.println(argumentsException.getMessage());
      argumentsException.printStackTrace();
    }
  }
}