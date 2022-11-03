package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import assignment3.problem1.InsuranceCompanyAutomation;
import assignment3.problem1.exception.InvalidArgumentsException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomatedFileWriterTest {
  private AutomatedFileWriter automationWriterTest;
  private String docContent;
  private List<AutomatedDocument> docs;
  private AutomatedDocument documentTest;
  @BeforeEach
  void setUp() throws IOException {
    docContent = """
    As you may have heard or read, last month we learned that criminals forced their way into our systems,\s
    and stole information about our customers. Late last week, as part of our ongoing investigation,\s
    we learned that the taken information includes names, mailing addresses, phone numbers or email addresses.
    """;
    documentTest = new AutomatedDocument(docContent);
    docs = new ArrayList<>();
    docs.add(documentTest);
    automationWriterTest = new AutomatedFileWriter(docs, "src/test/resources/unique");
  }

  @Test
  void createNewDirectoryTest() throws IOException {
    String randName = UUID.randomUUID().toString();
    AutomatedFileWriter automatedFileWriter = new AutomatedFileWriter(docs, "src/test/resources/"+randName);
  }
}