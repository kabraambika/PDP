package assignment3.problem1.commandline;

import assignment3.problem1.exception.InvalidArgumentsException;
import java.io.File;
import java.util.Map;
import java.util.Objects;

/**
 * CommandLineParser is used to read command line arguments and validate them
 * @author kabraambika19
 */
public class CommandLineParser implements ICommandLineParser {
  private Options options;
  private StringBuilder errorMessages;

  /**
   * Constructor of CommandLineParser
   * Validates the arguments and if errorMessage occurs then throws custom exception InvalidArgumentsException
   * @param args Arguments provided by user in commandline
   * @throws InvalidArgumentsException When arguments provided in commandline are not valid
   */
  public CommandLineParser(String[] args) throws InvalidArgumentsException {
    this.options = new Options();
    this.errorMessages = new StringBuilder();
    this.parseArguments(args);
  }

  /**
   * This private method does parsing of args and validate them, if error message found, Exception is thrown
   * @param args Arguments provided by user in commandline
   * @throws InvalidArgumentsException When arguments provided in commandline are not valid
   */
  private void parseArguments(String[] args) throws InvalidArgumentsException {
    if(this.validateArgsLength(args.length)) {
      this.processArgs(args);
    }
    else {
      this.getErrorMessages().append(ArgConstants.OPTION_ARGS);
    }
    if(!this.getErrorMessages().isEmpty()) {
      throw new InvalidArgumentsException(this.getErrorMessages() + ArgConstants.USAGE_MSG);
    }
  }

  /**
   * Gets the CSV file path provided in argument
   * @return String, path of CSV file
   */
  @Override
  public String getCsvFile() {
    return this.getArgsWithValue().get(ArgConstants.CSV_FILE);
  }

  /**
   * Gets the output directory path provided in arguments
   * @return String, path of output directory
   */
  @Override
  public String getOutputDir() {
    return this.getArgsWithValue().get(ArgConstants.OUTPUT_DIR);
  }

  /**
   * Gets email option is provided or not in argument
   * @return Boolean, true if --email option provided in arg, else false
   */
  @Override
  public Boolean getIsEmailOption() {
    return this.options.getEmailOption().getEmailSwitch();
  }

  /**
   * Gets letter option is provided or not in argument
   * @return Boolean, true if --letter option provided in arg, else false
   */
  @Override
  public Boolean getIsLetterOption() {
    return this.options.getLetterOption().getLetterSwitch();
  }

  /**
   * Get email-template path provided in argument
   * @return String, path of email-template
   */
  @Override
  public String getEmailTemplate() {
    return this.getArgsWithValue().get(ArgConstants.EMAIL_TEMPLATE);
  }

  /**
   * Get letter-template path provided in argument
   * @return String, path of letter-template
   */
  @Override
  public String getLetterTemplate() {
    return this.getArgsWithValue().get(ArgConstants.LETTER_TEMPLATE);
  }

  /**
   * Getter for map of arguments option with value
   * @return Map, Argument option String as key and Argument value as value of key
   */
  private Map<String, String> getArgsWithValue() {
    return this.options.getOptionsWithValue();
  }

  /**
   * Get error messages due to invalid arguments
   * @return StringBuilder object, this.errorMessages
   */
  public StringBuilder getErrorMessages() {
    return this.errorMessages;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CommandLineParser parser = (CommandLineParser) obj;
    return Objects.equals(this.options, parser.options) && Objects.equals(
        this.getErrorMessages().toString(), parser.getErrorMessages().toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.options, this.getErrorMessages().toString());
  }

  @Override
  public String toString() {
    return "CommandLineParser{" +
        "options=" + this.options +
        ", errorMessages=" + this.getErrorMessages().toString() +
        '}';
  }

  /**
   * This helper method set value to corresponding option of argument
   * @param args Arguments provided by user in commandline
   */
  private void processArgs(String[] args) {
    this.options.processArgs(args);
    this.validateArguments();
  }

  /**
   * This helper method validate the length of arguments
   * @param length length of args
   * @return Boolean, true if args length is greater than equal to 7 else false
   */
  private boolean validateArgsLength(int length) {
    return length >= ArgConstants.MIN_ARGS_LENGTH;
  }

  /**
   * This helper method validates all arguments
   */
  private void validateArguments() {
    this.hasEmailOrLetterOption();
    this.validateCSVFile();
    this.validateOutputDir();
    this.validateEmailTemplate();
    this.validateLetterTemplate();
  }

  /**
   * This helper method validates if email or letter option is provided
   * if both not provided, then add error in errorMessage
   */
  private void hasEmailOrLetterOption() {
    if(!this.getIsEmailOption() && !this.getIsLetterOption()){
      this.getErrorMessages().append(ArgConstants.EMAIL_OR_LETTER);
    }
  }

  /**
   * This helper methods validate email template option
   * if --email is true, --email-template is also provided,then validates txt extension of template and then validate to check if file exists, if not, adds error
   * if --email is true, --email-template is also provided, then txt extension is not provided then add error
   * if --email is true, --email-template is not provided, then add error
   * if --email is false, but --email-template is provided, then add error
   */
  private void validateEmailTemplate() {
    if(this.getIsEmailOption()) {
      if(this.getEmailTemplate() == null) {
        this.getErrorMessages().append(ArgConstants.EMAIL_TEMPLATE_OPTION_MISSING);
      }
      else {
        if(this.validateTxtExtension(this.getEmailTemplate())) {
          File template = new File(this.getEmailTemplate());
          if(this.fileDoesNotExists(template)) {
            this.getErrorMessages().append(this.getEmailTemplate()).append(ArgConstants.FILE_NOT_EXIST);
          }
        }
        else {
          this.getErrorMessages().append(ArgConstants.TXT_EXTENSION_TEMPLATE);
        }
      }
    }
    else {
      if(this.getEmailTemplate() != null) {
        this.getErrorMessages().append(ArgConstants.EMAIL_OPTION_MISSING);
      }
    }
  }

  /**
   * This helper methods validate letter template option
   * if --letter is true, --letter-template is also provided,then validates txt extension of template and then validate to check if file exists, if not, adds error
   * if --letter is true, --letter-template is also provided, then txt extension is not provided then add error
   * if --letter is true, --letter-template is not provided, then add error
   * if --letter is false, but --letter-template is provided, then add error
   */
  private void validateLetterTemplate() {
    if(this.getIsLetterOption()) {
      if(this.getLetterTemplate() == null) {
        this.getErrorMessages().append(ArgConstants.LETTER_TEMPLATE_OPTION_MISSING);
      }
      else {
        if(this.validateTxtExtension(this.getLetterTemplate())) {
          File template = new File(this.getLetterTemplate());
          if(this.fileDoesNotExists(template)) {
            this.getErrorMessages().append(this.getLetterTemplate()).append(ArgConstants.FILE_NOT_EXIST);
          }
        }
        else {
          this.getErrorMessages().append(ArgConstants.TXT_EXTENSION_TEMPLATE);
        }
      }
    }
    else {
      if(this.getLetterTemplate() != null) {
        this.getErrorMessages().append(ArgConstants.LETTER_OPTION_MISSING);
      }
    }
  }

  /**
   * this helper method checks if files does not exist and file is not directory and file cannot be read
   * @param fileTemplate template path
   * @return boolean
   */
  private boolean fileDoesNotExists(File fileTemplate) {
    return !fileTemplate.exists() && !fileTemplate.isFile() && !fileTemplate.canRead();
  }

  /**
   * This helper method check if path ends with .txt
   * @param templatePath file path, String
   * @return boolean
   */
  private boolean validateTxtExtension(String templatePath) {
    return templatePath.endsWith(ArgConstants.TXT_EXTENSION);
  }

  /**
   * This private method validates csv file path and file exists or not
   */
  private void validateCSVFile() {
    if(this.getCsvFile() != null && this.getCsvFile().endsWith(ArgConstants.CSV_EXTENSION)) {
      File csvFile = new File(this.getCsvFile());
      if (this.fileDoesNotExists(csvFile)) {
        this.getErrorMessages().append(this.getCsvFile()).append(ArgConstants.FILE_NOT_EXIST);
      }
    }
    else {
      this.getErrorMessages().append(ArgConstants.CSV_FILE_EXTENSION);
    }

  }

  /**
   * This helper method validates output directory
   */
  private void validateOutputDir() {
    if(this.getOutputDir() == null) {
      this.getErrorMessages().append(ArgConstants.NO_OUTPUT_DIR);
    }
  }
}
