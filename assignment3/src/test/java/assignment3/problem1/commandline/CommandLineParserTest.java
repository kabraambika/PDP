package assignment3.problem1.commandline;

import static org.junit.jupiter.api.Assertions.*;

import assignment3.problem1.exception.InvalidArgumentsException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {
  private CommandLineParser parserTest;
  String[] args;
  String expCSVPath;
  String expOutputDir;
  String expEmailTemplate;
  String expLetterTemplate;
  String[] dupArgs;
  @BeforeEach
  void setUp() throws InvalidArgumentsException {
    expCSVPath = "src/test/resources/insurance-company-members.csv";
    expOutputDir = "letters";
    expEmailTemplate = "src/test/resources/email-template.txt";
    expLetterTemplate = "src/test/resources/letter-template.txt";
    args = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
        "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    dupArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
        "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    parserTest = new CommandLineParser(args);
  }

  @Test
  void getCsvFile() {
    assertTrue(expCSVPath.equals(parserTest.getCsvFile()));
  }

  @Test
  void getOutputDir() {
    assertTrue(expOutputDir.equals(parserTest.getOutputDir()));
  }

  @Test
  void getIsEmailOption() {
    assertTrue(parserTest.getIsEmailOption());
  }

  @Test
  void getIsLetterOption() {
    assertTrue(parserTest.getIsLetterOption());
  }

  @Test
  void getEmailTemplate() {
    assertTrue(expEmailTemplate.equals(parserTest.getEmailTemplate()));
  }

  @Test
  void getLetterTemplate() {
    assertTrue(expLetterTemplate.equals(parserTest.getLetterTemplate()));
  }

  @Test
  void getErrorMessages() {
    assertTrue(parserTest.getErrorMessages().toString().equals(""));
  }

  @Test
  void testInvalidArgument_OutputDirNotPresent() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt",
          "--csv-file", "src/test/resources/insurance-company-members.csv",
          "--letter"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_CSV_file_is_txt() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.txt",
          "--letter"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_CSV_file_Not_given() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "--letter"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_CSV_file_Not_found() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/company-members.csv",
          "--letter"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_email_option_missing() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv",
          "--letter"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_option_missing() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email","--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_email_option_missing() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email-template", "src/test/resources/email-template.txt",
          "--letter-template", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_email_template_option_missing() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "src/test/resources/email-template.txt",
          "--letter", "src/test/resources/letter-template.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_email_template_extension_not_txt() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template","src/test/resources/email-template.csv",
          "--letter", "--letter-template","src/test/resources/letter-template.csv", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_email_template_extension_missing() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template","src/test/resources/email-template.csv",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_email_template_file_not_found() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template","src/test/resources/email.txt",
          "--letter", "--letter-template","src/test/resources/letter.txt", "--output-dir", "letters",
          "--csv-file", "src/test/resources/insurance-company-members.csv"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_CSV_file_missing_last() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--email", "--email-template","src/test/resources/email.txt",
          "--letter", "--letter-template","src/test/resources/letter.txt", "--output-dir", "letters",
          "--csv-file"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_letter_file_missing_last() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--output-dir", "letters","--email", "--email-template","src/test/resources/email.txt",
          "--csv-file","src/test/resources/insurance-company-members.csv", "--letter", "--letter-template"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_email_file_missing_last() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--letter", "--letter-template","src/test/resources/letter.txt",
          "--output-dir", "letters",
          "--csv-file","src/test/resources/insurance-company-members.csv", "--email", "--email-template"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testInvalidArgument_output_missing_last() {
    assertThrows(InvalidArgumentsException.class, ()-> {
      String[] invalidArgs = new String[] {"--letter", "--letter-template","src/test/resources/letter.txt",
          "--email", "--email-template","src/test/resources/email.txt",
          "--csv-file","src/test/resources/insurance-company-members.csv", "--output-dir"};
      CommandLineParser invalidParser = new CommandLineParser(invalidArgs);
    });
  }

  @Test
  void testEquals() {
    try {
      CommandLineParser dupParser = new CommandLineParser(dupArgs);
      assertTrue(dupParser.equals(parserTest));
    } catch (InvalidArgumentsException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_itself() {
    assertTrue(parserTest.equals(parserTest));
  }

  @Test
  void testEquals_NULL() {
    assertFalse(parserTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(parserTest.equals(new String("test")));
  }

  @Test
  void testHashCode() {
    Options argOptions = new Options();
    argOptions.processArgs(args);
    int hashTest = Objects.hash(argOptions, "");
    assertEquals(hashTest, parserTest.hashCode());
  }

  @Test
  void testToString() {
    Options argOptions = new Options();
    argOptions.processArgs(args);
    String expString = "CommandLineParser{" +
        "options=" + argOptions +
        ", errorMessages=" + "" +
        '}';
    assertEquals(expString, parserTest.toString());
  }
}