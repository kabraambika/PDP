package assignment2.stocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PairTest {
  private Pair<Integer, Integer> pair;
  private Pair<Integer, Integer> expPair;
  @BeforeEach
  void setUp() {
    pair = new Pair<>(1, 2);
  }

  @Test
  void getFirst() {
    assertEquals(1, pair.getFirst());
  }

  @Test
  void getSecond() {
    assertEquals(2, pair.getSecond());
  }

  @Test
  void testEquals_SimilarObject() {
    assertTrue(pair.equals(pair));
  }

  @Test
  void testEquals_DiffNull() {
    assertFalse(pair.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(pair.equals(new String("test")));
  }

  @Test
  void testEquals_DiffFirst() {
    expPair = new Pair<>(2, 2);
    assertFalse(pair.equals(expPair));
  }

  @Test
  void testEquals_DiffSecond() {
    expPair = new Pair<>(1, 3);
    assertFalse(pair.equals(expPair));
  }
  @Test
  void testEquals_Object() {
    expPair = new Pair<>(1, 2);
    assertTrue(pair.equals(expPair));
  }


  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(1, 2);
    assertEquals(expHashcode, pair.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Pair{" +
        "first=" + 1 +
        ", second=" + 2 +
        '}';
    assertEquals(expString, pair.toString());
  }
}