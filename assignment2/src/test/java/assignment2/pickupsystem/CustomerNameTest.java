package assignment2.pickupsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerNameTest {
  private CustomerName testName;
  @BeforeEach
  void setUp() {
    testName = new CustomerName("Amy", "J", "Brown");
  }

  @Test
  void getFirstName() {
    assertEquals("Amy", testName.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("J", testName.getMiddleName());
  }

  @Test
  void getMiddleName() {
    assertEquals("Brown", testName.getLastName());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testName.equals(testName));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testName.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testName.equals(new String("ambika")));
  }

  @Test
  void testEquals_DiffFirst() {
    CustomerName dupName = new CustomerName("", "J", "Brown");
    assertFalse(testName.equals(dupName));
  }

  @Test
  void testEquals_DiffMiddle() {
    CustomerName dupName = new CustomerName("Amy", "", "Brown");
    assertFalse(testName.equals(dupName));
  }

  @Test
  void testEquals_DiffLast() {
    CustomerName dupName = new CustomerName("Amy", "J", "");
    assertFalse(testName.equals(dupName));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash("Amy", "J", "Brown");
    assertEquals(expHashcode, testName.hashCode());
  }

  @Test
  void testToString() {
    String expString = "CustomerName{" +
        "firstName='" + "Amy" + '\'' +
        "middleName='" + "J" + '\'' +
        ", lastName='" + "Brown" + '\'' +
        '}';
    assertEquals(expString, testName.toString());
  }
}