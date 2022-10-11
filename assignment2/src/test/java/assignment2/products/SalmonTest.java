package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalmonTest {
  private Salmon salmon;
  @BeforeEach
  void setUp() {
    salmon = new Salmon(new Manufacturer("savvy"), "Salmon", 12.3, 0, 12.9);
  }

  @Test
  void testEquals() {
    assertTrue(salmon.equals(salmon));
  }

  @Test
  void getProductType() {
    assertEquals("Salmon", salmon.getProductType());
  }
}