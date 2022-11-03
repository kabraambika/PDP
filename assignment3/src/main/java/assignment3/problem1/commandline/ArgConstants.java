package assignment3.problem1.commandline;

/**
 * ArgConstants is a class used for making constants related to Arguments used in system.
 * @author kabraambika19
 */
public class ArgConstants {

  /**
   * EMAIL constant for --email option in argument
   */
  public static final String EMAIL = "--email";
  /**
   * EMAIL_TEMPLATE constant for --email-template option in argument
   */
  public static final String EMAIL_TEMPLATE = "--email-template";
  /**
   * LETTER constant for --letter option in argument
   */
  public static final String LETTER = "--letter";
  /**
   * LETTER_TEMPLATE constant for --letter-template option in argument
   */
  public static final String LETTER_TEMPLATE = "--letter-template";
  /**
   * OUTPUT_DIR constant for --output-dir option in argument
   */
  public static final String OUTPUT_DIR = "--output-dir";
  /**
   * CSV_FILE constant for --csv-file option in argument
   */
  public static final String CSV_FILE = "--csv-file";
  /**
   * USAGE_MSG constant for providing help message to user
   */
  public static final String USAGE_MSG = """
      Usage:
      --email                        only generate email messages
      --letter                       only generate letter messages
      --email-template <file>        accepts a filename that holds the email template.
                                     Required if --email is used
      --letter-template <file>       accepts a filename that holds the letter template.
                                     Required if --letter is used
      --csv-file <path>              accept the name of the csv file to process
      --output-dir <path>            accepts the name of a folder, all output is placed in this folder
      Examples:
      --email --email-template email-template.txt --output-dir emails --csv-file customer.csv
      --letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv
      --csv-file customer.csv --email-template email-template.txt --output-dir emails --email
      """;
  /**
   * CSV_EXTENSION constant for csv file extension
   */
  public static final String CSV_EXTENSION = ".csv";

  /**
   * TXT_EXTENSION constant for txt file extension
   */
  public static final String TXT_EXTENSION = ".txt";
  /**
   * Error constant for No output directory provided.
   */
  public static final String NO_OUTPUT_DIR = "No output directory provided.\n";
  /**
   * Error constant for Provide --email or --letter in arguments for automation.
   */
  public static final String EMAIL_OR_LETTER = "Provide --email or --letter in arguments for automation.\n";
  /**
   * Error constant for Invalid arguments in commandline
   */
  public static final String OPTION_ARGS = "Invalid arguments in commandline.\n";
  /**
   * Error constant for Provide txt extension file for template.
   */
  public static final String TXT_EXTENSION_TEMPLATE = "Provide txt extension file for template.\n";
  /**
   * Error constant for --email provided but no --email-template given.
   */
  public static final String EMAIL_TEMPLATE_OPTION_MISSING = "--email provided but no --email-template given.\n";
  /**
   * Error constant for --letter provided but no --letter-template given
   */
  public static final String LETTER_TEMPLATE_OPTION_MISSING = "--letter provided but no --letter-template given\n";
  /**
   * Error constant for provide csv extension file for customer data.
   */
  public static final String CSV_FILE_EXTENSION = "Provide csv extension file for customer data.\n";
  /**
   * Error constant for --letter-template provided but no --letter given.
   */
  public static final String LETTER_OPTION_MISSING = "--letter-template provided but no --letter given.\n";
  /**
   * Error constant for --email-template provided but no --email given.
   */
  public static final String EMAIL_OPTION_MISSING = "--email-template provided but no --email given.\n";
  /**
   * Error string for file doesn't exists
   */
  public static final String FILE_NOT_EXIST = " file doesn't exists.\n";

  /**
   * Constant for default args length
   */
  public static final int MIN_ARGS_LENGTH = 7;

  /**
   * Private constructor of ArgConstants
   */
  private ArgConstants() {}
}
