package assignment3.problem1.process;

import assignment3.problem1.exception.InvalidPlaceholderException;
import java.util.ArrayList;
import java.util.List;

/**
 * AutoDocumentProcessor is a class used for document processing and generation by replacing placeholders
 * This class implements interface IDocumentProcessor
 * @author kabraambika19
 */
public class AutoDocumentProcessor implements IDocumentProcessor {

  /**
   * List of documents of type AutomatedDocument
   */
  private List<AutomatedDocument> outputFiles;

  /**
   * Constructor of AutoDocumentProcessor
   * Process template and all customers data
   * @param template Represented by ITemplate, provides templateContent and list of placeholders
   * @param customerData Represented by CustomerData, provides data of all customers
   * @throws InvalidPlaceholderException InvalidPlaceholderException is thrown when there is no value provided in CSV file for placeholders in templates.
   */
  public AutoDocumentProcessor(ITemplate template, CustomerData customerData)
      throws InvalidPlaceholderException {
    this.outputFiles = new ArrayList<>();
    this.processInputs(template, customerData);
    customerData.resetCustomerID();
  }

  /**
   * Gets the list of documents, type AutomatedDocument
   * @return this.outputFiles
   */
  @Override
  public List<AutomatedDocument> getOutputFiles() {
    return this.outputFiles;
  }

  /**
   * This private method does mapping of each customer data with header and creates AutomatedDocument for each customer
   * @param template Represented by ITemplate, provides templateContent and list of placeholders
   * @param customerData Represented by CustomerData, provides data of all customers
   * @throws InvalidPlaceholderException InvalidPlaceholderException is thrown when there is no value provided in CSV file for placeholders in templates.
   */
  private void processInputs(ITemplate template, CustomerData customerData)
      throws InvalidPlaceholderException {
    while(customerData.hasNext()){
      CustomerFieldMapping mapping = new CustomerFieldMapping(customerData.getHeaders(), customerData.next());
      List<String> templatePlaceholders = template.getPlaceholders();
      AutomatedDocument document = getAutomatedDocument(templatePlaceholders, mapping, template.getTemplateContent());
      this.getOutputFiles().add(document);
    }
  }

  /**
   * This helper method generates AutomatedDocument after replacing placeholder with respective value
   * @param templatePlaceholders template placeholders in List of String
   * @param mapping Represented as CustomerFieldMapping object, provides mapping of header with customer data
   * @param templateContent template content as String
   * @return AutomatedDocument instance
   * @throws InvalidPlaceholderException InvalidPlaceholderException is thrown when there is no value provided in CSV file for placeholders in templates.
   */
  private AutomatedDocument getAutomatedDocument(List<String> templatePlaceholders, CustomerFieldMapping mapping, String templateContent)
      throws InvalidPlaceholderException {
    String documentContent = templateContent;
    for(String placeholder : templatePlaceholders) {
      String placeholderValue = getPlaceholderValueMapping(placeholder, mapping);
      if(placeholderValue == null) {
        throw new InvalidPlaceholderException("There is no value available for " + placeholder + " placeholder in CSV file");
      }
      String placeholderRegex = "\\[\\[" + placeholder + "\\]\\]";
      documentContent = documentContent.replaceAll(placeholderRegex, placeholderValue);
    }
    return new AutomatedDocument(documentContent);
  }

  /**
   * Gets value of placeholder from mapping
   * @param placeholder placeholder string
   * @param mapping Represented as CustomerFieldMapping object, provides mapping of header with customer data
   * @return String, value of placeholder
   */
  private String getPlaceholderValueMapping(String placeholder, CustomerFieldMapping mapping) {
    return mapping.getHeaderValue(placeholder);
  }
}
