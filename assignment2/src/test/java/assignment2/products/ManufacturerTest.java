package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManufacturerTest {
  private Manufacturer testManufacturer;
  @BeforeEach
  void setUp() {
    testManufacturer = new Manufacturer("Bounty");
  }

  @Test
  void getManufacturerName() {
    assertEquals("Bounty", testManufacturer.getManufacturerName());
  }

  @Test
  void testEquals_Object() {
    assertTrue(testManufacturer.equals(testManufacturer));
  }

  @Test
  void testEquals_null() {
    assertFalse(testManufacturer.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testManufacturer.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    Manufacturer expManufacturer = new Manufacturer("Bounty");
    assertTrue(expManufacturer.equals(testManufacturer));
  }

  @Test
  void testEquals_DifferentName() {
    Manufacturer expManufacturer = new Manufacturer("Brandy");
    assertFalse(expManufacturer.equals(testManufacturer));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash("Bounty");
    assertEquals(expHashcode, testManufacturer.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Manufacturer{" +
        "manufacturerName='" + "Bounty" + '\'' +
        '}';
    assertEquals(expString, testManufacturer.toString());
  }
}