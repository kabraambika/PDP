package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractHouseholdTest {
  private AbstractHousehold paperTowel;
  @BeforeEach
  void setUp() {
    paperTowel = new PaperTowel(new Manufacturer("Bounty"), "Bounty", 12.3, 0, 3);
  }

  @Test
  void getManufacturer() {
    assertEquals(new Manufacturer("Bounty"), paperTowel.getManufacturer());
  }

}