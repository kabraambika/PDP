package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVReaderTest {
  private String csvPathTest;
  private List<String> testCSVLines;
  private CSVReader readerTest;

  @BeforeEach
  void setUp() throws IOException {
    csvPathTest = "src/test/resources/insurance-company-member.csv";
    readerTest = new CSVReader(csvPathTest);
    testCSVLines = new ArrayList<>();
    String line1 = """
    "first_name","last_name","company_name","address","city","county","state","zip","phone1","phone2","email","web"
    """;
    String line2 = """
        "James","Butt","Benton, John B Jr","6649 N Blue Gum St","New Orleans","Orleans","LA","70116","504-621-8927","504-845-1427","jbutt@gmail.com","http://www.bentonjohnbjr.com"
        """;
    testCSVLines.add(line1.trim());
    testCSVLines.add(line2.trim());
  }

  @Test
  void getCvsContent() {
    assertEquals(testCSVLines, readerTest.getCvsContent());
  }

  @Test
  void testEquals() {
    assertTrue(readerTest.equals(readerTest));
  }

  @Test
  void testEquals_Null() {
    assertFalse(readerTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(readerTest.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObj() throws IOException {
    CSVReader dupReader = new CSVReader(csvPathTest);
    assertTrue(readerTest.equals(dupReader));
  }

  @Test
  void testEquals_DiffCSVContent() throws IOException {
    CSVReader dupReader = new CSVReader("src/test/resources/insurance-company-members.csv");
    assertFalse(readerTest.equals(dupReader));
  }

  @Test
  void testHashCode() {
    int hasExp = Objects.hash(testCSVLines);
    assertEquals(hasExp, readerTest.hashCode());
  }

  @Test
  void testToString() {
    String expString = "CSVReader{" +
        "cvsContent=" + testCSVLines +
        '}';
    assertEquals(expString, readerTest.toString());
  }
}