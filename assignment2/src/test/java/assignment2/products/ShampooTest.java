package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShampooTest {
  private AbstractHousehold shampoo;
  private Shampoo expShampoo;
  private Manufacturer manufacturer;
  @BeforeEach
  void setUp() {
    manufacturer = new Manufacturer("P&G");
    shampoo = new Shampoo(manufacturer, "Head&Shoulders", 25.8, 0, 1);
    expShampoo = new Shampoo(manufacturer, "Head&Shoulders", 25.8, 0, 1);
  }

  @Test
  void getUnitsPerPackage() {
    assertEquals(1, shampoo.getUnitsPerPackage());
  }

  @Test
  void getManufacturer() {
    assertEquals(new Manufacturer("P&G"), shampoo.getManufacturer());
  }

  @Test
  void getProductName() {
    assertEquals("Head&Shoulders", shampoo.getProductName());
  }

  @Test
  void getPrice() {
    assertEquals(25.8, shampoo.getPrice());
  }

  @Test
  void getMinimumAge() {
    assertEquals(0, shampoo.getMinimumAge());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(expShampoo.equals(expShampoo));
  }

  @Test
  void testEquals_Object() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), "Head&Shoulders", 25.8, 0, 1);
    assertTrue(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_null() {
    assertFalse(shampoo.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(shampoo.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), "Head&Shoulders", 25.8, 0, 1);
    assertTrue(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_diffManu() {
    AbstractHousehold dupShampoo = new Shampoo(null, "Head&Shoulders", 25.8, 0, 1);
    assertFalse(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_diffName() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), null, 25.8, 0, 1);
    assertFalse(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_DiffPrice() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), "Head&Shoulders", 0.2, 0, 1);
    assertFalse(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_DiffAge() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), "Head&Shoulders", 25.8, 10, 1);
    assertFalse(dupShampoo.equals(shampoo));
  }

  @Test
  void testEquals_DiffUnits() {
    AbstractHousehold dupShampoo = new Shampoo(new Manufacturer("P&G"), "Head&Shoulders", 25.8, 0, 2);
    assertFalse(dupShampoo.equals(shampoo));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(Objects.hash(new Manufacturer("P&G"), "Head&Shoulders", 25.8, 0), 1);
    assertEquals(expHashcode, shampoo.hashCode());
  }

  @Test
  void testToString() {
    String expString = "AbstractHousehold{" +
        "manufacturer=" + manufacturer +
        ", productName='" + "Head&Shoulders" + '\'' +
        ", price=" + 25.8 +
        ", minimumAge=" + 0 +
        ", unitsPerPackage=" + 1 +
        '}';
    assertEquals(expString, shampoo.toString());
  }

  @Test
  void getProductType() {
    assertEquals("Shampoo", shampoo.getProductType());
  }
}