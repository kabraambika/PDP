package assignment2.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheeseTest {
  private AbstractGrocery cheese;
  @BeforeEach
  void setUp() {
    cheese = new Cheese(new Manufacturer("mac"), "mac cheese", 12.7, 0, 3.0);
  }

  @Test
  void getProductWeight() {
    assertEquals(3.0, cheese.getProductWeight());
  }

  @Test
  void getProductType() {
    assertEquals("Cheese", cheese.getProductType());
  }
}