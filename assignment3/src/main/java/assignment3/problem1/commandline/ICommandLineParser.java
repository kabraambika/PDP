package assignment3.problem1.commandline;

/**
 * ICommandLineParser is an interface for commandline parser for getting required values of args
 * @author kabraambika19
 */
public interface ICommandLineParser {
  /**
   * Gets the CSV file path provided in argument
   * @return String, path of CSV file
   */
  String getCsvFile();

  /**
   * Gets the output directory path provided in arguments
   * @return String, path of output directory
   */
  String getOutputDir();

  /**
   * Gets email option is provided or not in argument
   * @return Boolean, true if --email option provided in arg, else false
   */
  Boolean getIsEmailOption();

  /**
   * Gets letter option is provided or not in argument
   * @return Boolean, true if --letter option provided in arg, else false
   */
  Boolean getIsLetterOption();

  /**
   * Get email-template path provided in argument
   * @return String, path of email-template
   */
  String getEmailTemplate();

  /**
   * Get letter-template path provided in argument
   * @return String, path of letter-template
   */
  String getLetterTemplate();
}
