package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaperTowelTest {
  private AbstractHousehold paperTowel;
  @BeforeEach
  void setUp() {
    paperTowel = new PaperTowel(new Manufacturer("wipes"), "wipes", 13.9, 0, 1);
  }

  @Test
  void getManufacturer() {
    assertEquals(new Manufacturer("wipes"), paperTowel.getManufacturer());
  }

  @Test
  void getProductType() {
    assertEquals("Paper towel", paperTowel.getProductType());
  }
}