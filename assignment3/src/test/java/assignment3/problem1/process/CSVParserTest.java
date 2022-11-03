package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVParserTest {
  private String testCSVPath;
  private CSVParser csvParserTest;
  @BeforeEach
  void setUp() throws IOException {
    testCSVPath = "src/test/resources/insurance-company-members.csv";
    csvParserTest = new CSVParser(testCSVPath);
  }

  @Test
  void testEquals() {
    assertTrue(csvParserTest.equals(csvParserTest));
  }

  @Test
  void testEquals_NULL() {
    assertFalse(csvParserTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(csvParserTest.equals(new String("test")));
  }

  @Test
  void testEquals_Same() throws IOException {
    CSVParser dupCSVParser = new CSVParser(testCSVPath);
    assertTrue(csvParserTest.equals(dupCSVParser));
  }

  @Test
  void testEquals_NotSame() throws IOException {
    CSVParser dupCSVParser = new CSVParser("src/test/resources/insurance-company-member.csv");
    assertFalse(csvParserTest.equals(dupCSVParser));
  }

  @Test
  void testHashCode() throws IOException {
    CSVParser dupCSVParser1 = new CSVParser("src/test/resources/insurance-company-one.csv");
    List<List<String>> expCSVData = new ArrayList<>();
    List<String> headers = new ArrayList<>();
    headers.add("first_name");
    headers.add("last_name");
    List<String> customerData = new ArrayList<>();
    customerData.add("James");
    customerData.add("Butt");
    expCSVData.add(headers);
    expCSVData.add(customerData);
    int hashExp = Objects.hash(expCSVData);
    assertEquals(hashExp, dupCSVParser1.hashCode());
  }
}