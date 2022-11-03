package assignment3.problem1.commandline;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptionsTest {
  private EmailOption emailOptionTest;
  private LetterOption letterOptionTest;
  private Options optionsTest;
  @BeforeEach
  void setUp() {
    emailOptionTest = new EmailOption(Boolean.TRUE);
    letterOptionTest = new LetterOption(Boolean.TRUE);
    optionsTest = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/options",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    optionsTest.processArgs(args);
  }

  @Test
  void getOptionsWithValue() {
    Map<String, String> testMap = new HashMap<>();
    testMap.put("--letter-template", "src/test/resources/letter-template.txt");
    testMap.put("--email-template", "src/test/resources/email-template.txt");
    testMap.put("--output-dir", "src/test/resources/options");
    testMap.put("--csv-file", "src/test/resources/insurance-company-members.csv");
    assertEquals(testMap, optionsTest.getOptionsWithValue());
  }

  @Test
  void getEmailOption() {
    assertEquals(emailOptionTest, optionsTest.getEmailOption());
  }

  @Test
  void getLetterOption() {
    assertEquals(letterOptionTest, optionsTest.getLetterOption());
  }

  @Test
  void setLetterOption() {
    Options optionsTest1 = new Options();
    optionsTest1.setLetterOption(letterOptionTest);
    assertEquals(optionsTest1.getLetterOption(), optionsTest.getLetterOption());
  }

  @Test
  void setEmailOption() {
    Options optionsTest1 = new Options();
    optionsTest1.setEmailOption(emailOptionTest);
    assertEquals(optionsTest1.getEmailOption(), optionsTest.getEmailOption());
  }

  @Test
  void processArgs() {
    Options optionsTestValidArgs = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/options",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    optionsTestValidArgs.processArgs(args);
  }

  @Test
  void testEquals_self() {
    assertTrue(optionsTest.equals(optionsTest));
  }

  @Test
  void testEquals_null() {
    assertFalse(optionsTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(optionsTest.equals(new String("test")));
  }

  @Test
  void testEquals_similarObj() {
    Options dupOptionsTest = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/options",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    dupOptionsTest.processArgs(args);
    assertEquals(optionsTest, dupOptionsTest);
  }

  @Test
  void testEquals_similarObj_emailDisabled() {
    Options dupOptionsTest = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/options",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    dupOptionsTest.processArgs(args);
    assertNotEquals(optionsTest, dupOptionsTest);
  }

  @Test
  void testEquals_similarObj_letterDisabled() {
    Options dupOptionsTest = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/options",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        };
    dupOptionsTest.processArgs(args);
    assertNotEquals(optionsTest, dupOptionsTest);
  }

  @Test
  void testEquals_similarObj_HashMap() {
    Options dupOptionsTest = new Options();
    String[] args = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--letter"};
    dupOptionsTest.processArgs(args);
    assertNotEquals(optionsTest, dupOptionsTest);
  }
}