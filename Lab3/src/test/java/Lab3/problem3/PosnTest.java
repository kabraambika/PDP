package Lab3.problem3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosnTest {
  private Posn posn1;
  @BeforeEach
  void setUp() {
    posn1 = new Posn(1, 2);
  }

  @Test
  void getX() {
    assertEquals(1, posn1.getX());
  }

  @Test
  void getY() {
    assertEquals(2, posn1.getY());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(posn1.equals(posn1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(posn1.equals(null));
  }

  @Test
  void testEquals_SimilarObject() {
    Posn posn2 = new Posn(1, 2);
    assertTrue(posn1.equals(posn2));
  }
  @Test
  void testEquals_DifferentObject() {
    String test = new String("test1");
    assertFalse(posn1.equals(test));
  }

  @Test
  void testEquals_DifferentX() {
    Posn posn2 = new Posn(null, 2);
    assertFalse(posn1.equals(posn2));
  }

  @Test
  void testEquals_DifferentY() {
    Posn posn2 = new Posn(1, null);
    assertFalse(posn1.equals(posn2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(1, 2);
    assertEquals(expectedHashCode, posn1.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Posn{" +
        "x=" + 1 +
        ", y=" + 2 +
        '}';
    assertEquals(expectedString, posn1.toString());
  }
}