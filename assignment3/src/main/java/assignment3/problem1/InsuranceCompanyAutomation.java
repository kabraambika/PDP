package assignment3.problem1;

import assignment3.problem1.commandline.CommandLineParser;
import assignment3.problem1.exception.InvalidArgumentsException;
import assignment3.problem1.exception.InvalidPlaceholderException;
import assignment3.problem1.process.AutoDocumentProcessor;
import assignment3.problem1.process.AutomatedFileWriter;
import assignment3.problem1.process.CSVParser;
import assignment3.problem1.process.CustomerData;
import assignment3.problem1.process.IDocumentProcessor;
import assignment3.problem1.process.ITemplate;
import assignment3.problem1.process.Template;
import java.io.IOException;

/**
 * Helper class to parse the commandline arguments and generate automated files according to arguments.
 * @author kabraambika19
 */
public class InsuranceCompanyAutomation {
  private CommandLineParser parser;

  /**
   * Constructor of InsuranceCompanyAutomation class
   * @param args array of String, command line arguments
   * @throws InvalidArgumentsException Args are not compliant as expected
   */
  public InsuranceCompanyAutomation(String[] args) throws InvalidArgumentsException {
    this.parser = new CommandLineParser(args);
  }

  /**
   * Getter method for parser property
   * @return this.parse
   */
  public CommandLineParser getParser() {
    return this.parser;
  }

  /**
   * This method starts automation by parsing CSV file by reading CSV file, also separates header of csv and rest of data.
   * Reads template and replace placeholders with values of each customer generate document for each customer in output directory according to args.
   * @throws InvalidPlaceholderException when in template, there is a placeholder present whose value is not provided in csv file
   * @throws IOException While getting file, streaming file and reading if something goes wrong, exception is thrown
   */
  public void startAutomationTool()
      throws InvalidPlaceholderException, IOException {
    CSVParser csvParser = new CSVParser(this.getParser().getCsvFile());
    CustomerData customerData = new CustomerData(csvParser.getCsvData());

    if (this.getParser().getIsEmailOption()) {
      processFileGeneration(this.getParser().getEmailTemplate(), customerData);
    }

    if (this.getParser().getIsLetterOption()) {
      processFileGeneration(this.getParser().getLetterTemplate(), customerData);
    }
  }

  /**
   * The method reads template at once and stores list of placeholders and invoke helper method to generate files
   * @param templatePath Represented as String, path of template
   * @param customerData Represented as CustomerData,
   * @throws InvalidPlaceholderException when in template, there is a placeholder present whose value is not provided in csv file
   * @throws IOException While getting file, streaming file and reading if something goes wrong, exception is thrown
   */
  private void processFileGeneration(String templatePath, CustomerData customerData) throws IOException, InvalidPlaceholderException {
    ITemplate template = new Template(templatePath);
    generateFiles(template, customerData);
  }

  /**
   * This helper method is responsible for mapping header with individual customer data.
   * replacing template's placeholder by value of placeholder and writing document in output directory
   * @param template Represented as ITemplate object, consists of template content and placeholder list
   * @param customerData List of customer details and list of headers
   * @throws InvalidPlaceholderException when in template, there is a placeholder present whose value is not provided in csv file
   * @throws IOException While getting file, streaming file and reading if something goes wrong, exception is thrown
   */
  private void generateFiles(ITemplate template,
      CustomerData customerData)
      throws InvalidPlaceholderException, IOException {
    IDocumentProcessor processor = new AutoDocumentProcessor(template, customerData);
    AutomatedFileWriter fileWriter = new AutomatedFileWriter(processor.getOutputFiles(),
        this.getParser().getOutputDir());
  }
}