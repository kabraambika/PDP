package assignment3.problem1.commandline;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailOptionTest {
  private EmailOption emailOptionTest;
  @BeforeEach
  void setUp() {
    emailOptionTest = new EmailOption(Boolean.TRUE);
  }

  @Test
  void getEmailSwitch() {
    assertTrue(emailOptionTest.getEmailSwitch());
  }

  @Test
  void testEquals_self() {
    assertTrue(emailOptionTest.equals(emailOptionTest));
  }

  @Test
  void testEquals_null() {
    assertFalse(emailOptionTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(emailOptionTest.equals(new String("test")));
  }

  @Test
  void testEquals_similar() {
    EmailOption dupEmailOptionTest = new EmailOption(Boolean.TRUE);
    assertTrue(emailOptionTest.equals(dupEmailOptionTest));
  }

  @Test
  void testEquals_diffEmailOption() {
    EmailOption dupEmailOptionTest = new EmailOption(Boolean.FALSE);
    assertFalse(emailOptionTest.equals(dupEmailOptionTest));
  }

  @Test
  void testHashCode() {
    int expHash = Objects.hash(Boolean.TRUE);
    assertEquals(expHash, emailOptionTest.hashCode());
  }

  @Test
  void testToString() {
    String expString = "EmailOption{" +
        "emailSwitch=" + "true" +
        '}';
    assertEquals(expString, emailOptionTest.toString());
  }
}