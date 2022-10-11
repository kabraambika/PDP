package Lab3.problem4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CivilianTest {
  private Civilian civilian;
  @BeforeEach
  void setUp() {
    civilian = new Farmer(new Name("Amy", "Brown"), 12, 123.3);

  }

  @Test
  void getName() {
    assertEquals(new Name("Amy", "Brown"), civilian.getName());
  }

  @Test
  void getAge() {
    assertEquals(12, civilian.getAge());
  }

  @Test
  void testEquals() {
    assertEquals(123.3, civilian.getWealth());
  }

  @Test
  void testHashCode() {
  }

  @Test
  void testToString() {
  }

  @Test
  void getWealth() {
  }

  @Test
  void increaseWealth() {
  }

  @Test
  void decreaseWealth() {
  }
}