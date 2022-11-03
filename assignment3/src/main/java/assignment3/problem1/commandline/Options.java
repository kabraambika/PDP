package assignment3.problem1.commandline;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Option class represents the option of arguments and values of options
 * @author kabraambika19
 */
public class Options {
  private EmailOption emailOption;
  private LetterOption letterOption;
  private Map<String, String> optionsWithValue;

  /**
   * Constructor of Options
   * Initialization for default values of options
   */
  public Options() {
    this.optionsWithValue = new HashMap<>();
    this.setDefaultValues();
  }

  /**
   * get map of options and its value
   * @return Map of String option and String value
   */
  public Map<String, String> getOptionsWithValue() {
    return this.optionsWithValue;
  }

  /**
   * Get instance of EmailOption
   * @return EmailOption
   */
  public EmailOption getEmailOption() {
    return this.emailOption;
  }

  /**
   * Gets Instance of LetterOption
   * @return LetterOption
   */
  public LetterOption getLetterOption() {
    return this.letterOption;
  }

  /**
   * Set instance of LetterOption to letterOption in class property
   * @param letterOption LetterOption instance
   */
  public void setLetterOption(LetterOption letterOption) {
    this.letterOption = letterOption;
  }

  /**
   * Set instance of EmailOption to emailOption in class property
   * @param emailOption EmailOption instance
   */
  public void setEmailOption(EmailOption emailOption) {
    this.emailOption = emailOption;
  }

  /**
   * Set default values to the class properties
   */
  private void setDefaultValues() {
    this.emailOption = new EmailOption(Boolean.FALSE);
    this.letterOption = new LetterOption(Boolean.FALSE);
    this.getOptionsWithValue().put(ArgConstants.LETTER_TEMPLATE, null);
    this.getOptionsWithValue().put(ArgConstants.EMAIL_TEMPLATE, null);
    this.getOptionsWithValue().put(ArgConstants.OUTPUT_DIR, null);
    this.getOptionsWithValue().put(ArgConstants.CSV_FILE, null);
  }

  /**
   * Add arguments according to input provided
   * @param args Array of String
   */
  void processArgs(String[] args) {
    int argLength = args.length;
    for(int index = 0; index < argLength; index++) {
      switch (args[index]) {
        case (ArgConstants.EMAIL) -> this.setEmailOption(new EmailOption(Boolean.TRUE));
        case (ArgConstants.EMAIL_TEMPLATE) -> {
          if(index + 1 < argLength) {
            addOptionValue(ArgConstants.EMAIL_TEMPLATE, args[index + 1]);
          }
        }
        case (ArgConstants.LETTER) -> this.setLetterOption(new LetterOption(Boolean.TRUE));
        case (ArgConstants.LETTER_TEMPLATE) -> {
          if(index + 1 < argLength) {
            addOptionValue(ArgConstants.LETTER_TEMPLATE, args[index + 1]);
          }
        }
        case (ArgConstants.OUTPUT_DIR) -> {
          if(index + 1 < argLength) {
            addOptionValue(ArgConstants.OUTPUT_DIR, args[index + 1]);
          }
        }
        case (ArgConstants.CSV_FILE) -> {
          if(index + 1 < argLength){
            addOptionValue(ArgConstants.CSV_FILE, args[index + 1]);
          }
        }
      }
    }
  }

  /**
   * Add option value and key
   * @param optionKey String, option name
   * @param optionValue, String option value
   */
  private void addOptionValue(String optionKey, String optionValue) {
    this.getOptionsWithValue().put(optionKey, optionValue);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Options options = (Options) obj;
    return Objects.equals(this.getEmailOption(), options.getEmailOption())
        && Objects.equals(this.getLetterOption(), options.getLetterOption())
        && Objects.equals(this.getOptionsWithValue(), options.getOptionsWithValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getEmailOption(), this.getLetterOption(), this.getOptionsWithValue());
  }

  @Override
  public String toString() {
    return "Options{" +
        "emailOption=" + this.getEmailOption() +
        ", letterOption=" + this.getLetterOption() +
        ", optionsWithValue=" + this.getOptionsWithValue() +
        '}';
  }
}
