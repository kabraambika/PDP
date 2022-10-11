package Lab3.problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressTest {
  private Address testAddress;
  @BeforeEach
  void setUp() {
    testAddress = new Address("500", "Seattle", "98121", "WA", "USA");
  }

  @Test
  void getStreetNumber() {
    assertEquals("500", testAddress.getStreetNumber());
  }

  @Test
  void getCity() {
    assertEquals("Seattle", testAddress.getCity());
  }

  @Test
  void getZipCode() {
    assertEquals("98121", testAddress.getZipCode());
  }

  @Test
  void getState() {
    assertEquals("WA", testAddress.getState());
  }

  @Test
  void getCountry() {
    assertEquals("USA", testAddress.getCountry());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testAddress.equals(testAddress));
  }

  @Test
  void testEquals_null() {
    assertFalse(testAddress.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testAddress.equals(new String("test")));
  }

  @Test
  void testEquals_DiffStreetNumber() {
    assertFalse(testAddress.equals(new Address(null, "Seattle", "98121", "WA", "USA")));
  }

  @Test
  void testEquals_DiffCity() {
    assertFalse(testAddress.equals(new Address("500", null, "98121", "WA", "USA")));
  }

  @Test
  void testEquals_DiffCode() {
    assertFalse(testAddress.equals(new Address("500", "Seattle", null, "WA", "USA")));
  }

  @Test
  void testEquals_DiffState() {
    assertFalse(testAddress.equals(new Address("500", "Seattle", "98121", null, "USA")));
  }

  @Test
  void testEquals_DiffCountry() {
    assertFalse(testAddress.equals(new Address("500", "Seattle", "98121", "WA", null)));
  }

  @Test
  void testHashCode() {
    int expHashCode = Objects.hash("500", "Seattle", "98121", "WA", "USA");
    assertEquals(expHashCode, testAddress.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Address{" +
        "streetNumber='" + "500" + '\'' +
        ", city='" + "Seattle" + '\'' +
        ", zipCode='" + "98121" + '\'' +
        ", state='" + "WA" + '\'' +
        ", country='" + "USA" + '\'' +
        '}';
    assertEquals(expString, testAddress.toString());
  }

  @Test
  void setCity() {
    testAddress.setCity("Boston");
    assertEquals("Boston", testAddress.getCity());
  }

  @Test
  void setZipCode() {
    testAddress.setZipCode("02206");
    assertEquals("02206", testAddress.getZipCode());
  }

  @Test
  void setState() {
    testAddress.setState("Massachusetts");
    assertEquals("Massachusetts", testAddress.getState());
  }

  @Test
  void setCountry() {
    testAddress.setCountry("India");
    assertEquals("India", testAddress.getCountry());
  }

  @Test
  void setStreetNumber() {
    testAddress.setStreetNumber("225");
    assertEquals("225", testAddress.getStreetNumber());
  }
}