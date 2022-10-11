package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractGroceryTest {
  private AbstractGrocery cheese;
  private AbstractGrocery salmon;
  @BeforeEach
  void setUp() {
    cheese = new Cheese(new Manufacturer("swiss"), "swiss cheese", 13.0, 0, 12.0);
    salmon = new Salmon(new Manufacturer("Whole foods"), "Salmon", 10.0, 0, 10.0);
  }

  @Test
  void getProductWeight() {
    assertEquals(12.0, cheese.getProductWeight());
  }
}