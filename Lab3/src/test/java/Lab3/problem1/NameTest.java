package Lab3.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  private Name name;
  @BeforeEach
  void setUp() {
    name = new Name("John", "J", "Brown");
  }

  @Test
  void getFirstName() {
    assertEquals("John", name.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals("J", name.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals("Brown", name.getLastName());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(name.equals(name));
  }

  @Test
  void testEquals_null() {
    assertFalse(name.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(name.equals(new String("A")));
  }

  @Test
  void testEquals_SimilarObject() {
    Name name1 = new Name("John", "J", "Brown");
    assertTrue(name.equals(name1));
  }

  @Test
  void testEquals_DiffFirstName() {
    Name name1 = new Name(null, "J", "Brown");
    assertFalse(name.equals(name1));
  }

  @Test
  void testEquals_DiffMiddleName() {
    Name name1 = new Name("John", null, "Brown");
    assertFalse(name.equals(name1));
  }

  @Test
  void testEquals_DiffLastName() {
    Name name1 = new Name("John", "J", null);
    assertFalse(name.equals(name1));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash("John", "J", "Brown");
    assertEquals(expHashcode, name.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Name{" +
        "firstName='" + "John" + '\'' +
        ", middleName='" + "J" + '\'' +
        ", lastName='" + "Brown" + '\'' +
        '}';
    assertEquals(expString, name.toString());
  }
}