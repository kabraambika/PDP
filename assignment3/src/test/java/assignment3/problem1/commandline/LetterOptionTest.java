package assignment3.problem1.commandline;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterOptionTest {
  private LetterOption letterOptionTest;
  @BeforeEach
  void setUp() {
    letterOptionTest = new LetterOption(Boolean.TRUE);
  }

  @Test
  void getLetterSwitch() {
    assertTrue(letterOptionTest.getLetterSwitch());
  }

  @Test
  void testEquals_self() {
    assertTrue(letterOptionTest.equals(letterOptionTest));
  }

  @Test
  void testEquals_null() {
    assertFalse(letterOptionTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(letterOptionTest.equals(new String("test")));
  }

  @Test
  void testEquals_similar() {
    LetterOption dupLetterOptionTest = new LetterOption(Boolean.TRUE);
    assertTrue(letterOptionTest.equals(dupLetterOptionTest));
  }

  @Test
  void testEquals_diffEmailOption() {
    LetterOption dupLetterOptionTest = new LetterOption(Boolean.FALSE);
    assertFalse(letterOptionTest.equals(dupLetterOptionTest));
  }

  @Test
  void testHashCode() {
    int expHash = Objects.hash(Boolean.TRUE);
    assertEquals(expHash, letterOptionTest.hashCode());
  }

  @Test
  void testToString() {
    String expString = "LetterOption{" +
        "letterSwitch=" + "true" +
        '}';
    assertEquals(expString, letterOptionTest.toString());
  }
}