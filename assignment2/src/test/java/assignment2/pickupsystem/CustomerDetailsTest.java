package assignment2.pickupsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDetailsTest {
  private CustomerDetails testCustomerDetails;
  private CustomerName testName;
  private CustomerName expName;
  @BeforeEach
  void setUp() {
    testName = new CustomerName("Amy", "J", "Brown");
    expName = new CustomerName("Amy", "J", "Brown");
    testCustomerDetails = new CustomerDetails(testName, 21);
  }

  @Test
  void testInvalidAgeException() {
    assertThrows(InvalidAgeException.class, () -> {
      CustomerDetails details = new CustomerDetails(testName, -21);
    });
  }
  @Test
  void getName() {
    assertEquals(expName, testCustomerDetails.getName());
  }

  @Test
  void getAge() {
    assertEquals(21, testCustomerDetails.getAge());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCustomerDetails.equals(testCustomerDetails));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testCustomerDetails.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testCustomerDetails.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    CustomerDetails dupCustomerDetails = new CustomerDetails(testName, 21);
    assertTrue(testCustomerDetails.equals(dupCustomerDetails));
  }

  @Test
  void testEquals_DiffName() {
    CustomerDetails dupCustomerDetails = new CustomerDetails(null, 21);
    assertFalse(testCustomerDetails.equals(dupCustomerDetails));
  }

  @Test
  void testEquals_DiffAge() {
    CustomerDetails dupCustomerDetails = new CustomerDetails(testName, 20);
    assertFalse(testCustomerDetails.equals(dupCustomerDetails));
  }


  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(expName, 21);
    assertEquals(expHashcode, testCustomerDetails.hashCode());
  }

  @Test
  void testToString() {
    String expString = "CustomerDetails{" +
        "customerName=" + expName.toString() +
        ", age=" + 21 +
        '}';
    assertEquals(expString, testCustomerDetails.toString());
  }
}