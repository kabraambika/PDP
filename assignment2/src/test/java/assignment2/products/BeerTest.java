package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeerTest {
  private AbstractGrocery beer;
  private Manufacturer expManufacturer;
  private Manufacturer manufacturer;
  @BeforeEach
  void setUp() {
    manufacturer = new Manufacturer("Corona");
    expManufacturer = new Manufacturer("Corona");

    beer = new Beer(manufacturer, "Corona light", 18.39, 21, 12.0);
  }

  @Test
  void getProductWeight() {
    assertEquals(12.0, beer.getProductWeight());
  }

  @Test
  void getManufacturer() {
    assertEquals(expManufacturer, beer.getManufacturer());
  }

  @Test
  void getProductName() {
    assertEquals("Corona light", beer.getProductName());
  }

  @Test
  void getPrice() {
    assertEquals(18.39, beer.getPrice());
  }

  @Test
  void getMinimumAge() {
    assertEquals(21, beer.getMinimumAge());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(beer.equals(beer));
  }

  @Test
  void testEquals_null() {
    assertFalse(beer.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(beer.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    AbstractGrocery expBeer = new Beer(expManufacturer, "Corona light", 18.39, 21, 12.0);
    assertTrue(expBeer.equals(beer));
  }

  @Test
  void testEquals_DiffManu() {
    AbstractGrocery expBeer = new Beer(null, "Corona light", 18.39, 21, 12.0);
    assertFalse(expBeer.equals(beer));
  }

  @Test
  void testEquals_DiffName() {
    AbstractGrocery expBeer = new Beer(expManufacturer, "Corona extra", 18.39, 21, 12.0);
    assertFalse(expBeer.equals(beer));
  }

  @Test
  void testEquals_DifferentPrice() {
    AbstractGrocery expBeer = new Beer(expManufacturer, "Corona light", 20.00, 21, 12.0);
    assertFalse(expBeer.equals(beer));
  }

  @Test
  void testEquals_DiffAge() {
    AbstractGrocery expBeer = new Beer(expManufacturer, "Corona light", 18.39, 27, 12.0);
    assertFalse(expBeer.equals(beer));
  }

  @Test
  void testEquals_DiffWeight() {
    AbstractGrocery expBeer = new Beer(expManufacturer, "Corona light", 18.39, 21, null);
    assertFalse(expBeer.equals(beer));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(Objects.hash(expManufacturer, "Corona light", 18.39, 21), 12.0);
    assertEquals(expHashcode, beer.hashCode());
  }

  @Test
  void testToString() {
    String expString = "AbstractGrocery{" +
        "manufacturer=" + expManufacturer +
        ", productName='" + "Corona light" + '\'' +
        ", price=" + 18.39 +
        ", minimumAge=" + 21 +
        ", productWeight=" + 12.0 +
        '}';
    assertEquals(expString, beer.toString());
  }

  @Test
  void getProductType() {
    assertEquals("Beer", beer.getProductType());
  }
}