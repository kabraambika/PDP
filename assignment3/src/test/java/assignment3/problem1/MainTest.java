package assignment3.problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
  private String[] argsTest;
  public Main mainClassTest;
  @BeforeEach
  void setUp() {
    argsTest = new String[] {"--letter-template", "src/test/resources/letter-template.txt",
        "--email", "--email-template", "src/test/resources/email-template.txt",
        "--output-dir", "src/test/resources/mainLettersAndEmails",
        "--csv-file", "src/test/resources/insurance-company-members.csv",
        "--letter"};
    mainClassTest = new Main();
  }

  @Test
  void main() {
    Main.main(argsTest);
  }
}