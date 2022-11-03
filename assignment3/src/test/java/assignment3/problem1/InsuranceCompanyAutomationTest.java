package assignment3.problem1;

import static org.junit.jupiter.api.Assertions.*;

import assignment3.problem1.commandline.CommandLineParser;
import assignment3.problem1.exception.InvalidArgumentsException;
import assignment3.problem1.exception.InvalidPlaceholderException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsuranceCompanyAutomationTest {
  private String[] argsTest;
  private InsuranceCompanyAutomation automationTest;
  @BeforeEach
  void setUp() throws InvalidArgumentsException {
    argsTest = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/lettersAndEmails",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    automationTest = new InsuranceCompanyAutomation(argsTest);
  }

  @Test
  void getParser() throws InvalidArgumentsException {
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/lettersAndEmails",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    CommandLineParser parserExp = new CommandLineParser(args);
    assertEquals(parserExp, automationTest.getParser());
  }

  @Test
  void startAutomationTool() throws IOException, InvalidPlaceholderException {
    automationTest.startAutomationTool();
  }
  @Test
  void startAutomationTool_onlyLetters()
      throws InvalidPlaceholderException, InvalidArgumentsException, IOException {
    String[] letterArgs = new String[] {"--letter", "--letter-template", "src/test/resources/letter-template.txt",
        "--output-dir", "src/test/resources/letters",
        "--csv-file", "src/test/resources/insurance-company-members.csv"};
    InsuranceCompanyAutomation letterAutomation = new InsuranceCompanyAutomation(letterArgs);
    letterAutomation.startAutomationTool();
  }

  @Test
  void startAutomationTool_onlyEmails()
      throws InvalidPlaceholderException, InvalidArgumentsException, IOException {
    String[] emailArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/letters",
        "--csv-file", "src/test/resources/insurance-company-members.csv"};
    InsuranceCompanyAutomation emailAutomation = new InsuranceCompanyAutomation(emailArgs);
    emailAutomation.startAutomationTool();
  }

  @Test
  void testInvalidPlaceholderException() {
    String[] letterArgs = new String[] {"--letter", "--letter-template", "src/test/resources/letter-invalid-template.txt",
        "--output-dir", "src/test/resources/letters",
        "--csv-file", "src/test/resources/insurance-company-members.csv"};
    assertThrows(InvalidPlaceholderException.class, ()-> {
      InsuranceCompanyAutomation emailAutomation = new InsuranceCompanyAutomation(letterArgs);
      emailAutomation.startAutomationTool();
    });

  }
}