package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDataTest {
  private List<String> testHeaders = new ArrayList<>();
  private List<List<String>> testCustomerDetails = new ArrayList<>();
  private CustomerData testCustomerData;
  private List<List<String>> expCSVData;
  @BeforeEach
  void setUp() {
    expCSVData = new ArrayList<>();
    List<String> headers = new ArrayList<>();
    headers.add("first_name");
    headers.add("last_name");

    List<String> james = new ArrayList<>();
    james.add("James");
    james.add("Butt");

    List<String> amy = new ArrayList<>();
    amy.add("Amy");
    amy.add("Butt");

    expCSVData.add(headers);
    expCSVData.add(james);
    expCSVData.add(amy);

    testHeaders.addAll(headers);
    testCustomerDetails.add(james);
    testCustomerDetails.add(amy);

    testCustomerData = new CustomerData(expCSVData);
  }

  @Test
  void getHeaders() {
    assertEquals(testHeaders, testCustomerData.getHeaders());
  }

  @Test
  void getCustomerDetails() {
    assertEquals(testCustomerDetails, testCustomerData.getCustomerDetails());
  }

  @Test
  void testEquals() {
    assertTrue(testCustomerData.equals(testCustomerData));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testCustomerData.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testCustomerData.equals(new String("test")));
  }

  @Test
  void testEquals_SameObj() {
    CustomerData dupCustomerData = new CustomerData(expCSVData);
    assertTrue(testCustomerData.equals(dupCustomerData));
  }

  @Test
  void testEquals_DiffHeaders() {
    List<List<String>> dupCsvData = new ArrayList<>();
    List<String> headers = new ArrayList<>();
    List<String> james = new ArrayList<>();
    james.add("James");
    james.add("Butt");

    List<String> amy = new ArrayList<>();
    amy.add("Amy");
    amy.add("Butt");

    dupCsvData.add(headers);
    dupCsvData.add(james);
    dupCsvData.add(amy);
    CustomerData diffCustomerData = new CustomerData(dupCsvData);
    assertFalse(testCustomerData.equals(diffCustomerData));
  }

  @Test
  void testEquals_DiffDetails() {
    List<List<String>> dupCsvData = new ArrayList<>();
    List<String> headers = new ArrayList<>();
    headers.add("first_name");
    headers.add("last_name");

    List<String> amy = new ArrayList<>();
    amy.add("Amy");
    amy.add("Butt");

    dupCsvData.add(headers);
    dupCsvData.add(amy);
    CustomerData diffCustomerData = new CustomerData(dupCsvData);
    assertFalse(testCustomerData.equals(diffCustomerData));
  }

  @Test
  void testHashCode() {
    int hashExp = Objects.hash(testHeaders, testCustomerDetails);
    assertEquals(hashExp, testCustomerData.hashCode());
  }

  @Test
  void testToString() {
    String expString = "CustomerData{" +
        "headers=" + testHeaders +
        ", customerDetails=" + testCustomerDetails +
        '}';
    assertEquals(expString, testCustomerData.toString());
  }

  @Test
  void hasNext() {
    assertTrue(testCustomerData.hasNext());
  }

  @Test
  void hasNext_False() {
    testCustomerData.next();
    testCustomerData.next();
    assertFalse(testCustomerData.hasNext());
  }

  @Test
  void resetCustomerID() {
    testCustomerData.resetCustomerID();
  }
}