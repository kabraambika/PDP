package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractProductTest {
  private AbstractProduct testProduct;
  private Manufacturer testManufacturer;
  private Manufacturer expManufacturer;
  @BeforeEach
  void setUp() {
    testManufacturer = new Manufacturer("Bounty");
    expManufacturer = new Manufacturer("Bounty");
    testProduct = new PaperTowel(testManufacturer, "Bounty towels", 12.5, 0, 1);
  }

  @Test
  void getManufacturer() {
    assertEquals(expManufacturer, testProduct.getManufacturer());
  }

  @Test
  void testInvalidMinimumAgeException() {
    assertThrows(InvalidMinimumAgeException.class, ()-> {
      testProduct = new PaperTowel(testManufacturer, "Bounty towels", 12.5, -1, 1);
    }, "Minimum age for product should be greater than or equal to 0");
  }

  @Test
  void getProductName() {
    assertEquals("Bounty towels", testProduct.getProductName());
  }

  @Test
  void getPrice() {
    assertEquals(12.5, testProduct.getPrice());
  }

  @Test
  void getMinimumAge() {
    assertEquals(0, testProduct.getMinimumAge());
  }

  @Test
  void testEquals() {
    assertTrue(testProduct.equals(testProduct));
  }
}