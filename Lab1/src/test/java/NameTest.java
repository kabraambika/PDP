import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  String firstName = "Alex";
  String lastName = "Lincoln";
  Name name;
  Name secondName = new Name("Alex", "Lincoln");
  @BeforeEach
  void setUp() {
    name = new Name("Alex", "Lincoln");
  }

  @Test
  void getFirstName() {
    assertEquals(this.firstName, this.name.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(this.lastName, this.name.getLastName());
  }

  @Test
  void testEquals() {
    assertEquals(this.secondName, this.name);
  }

  @Test
  void testHashCode() {
    Name name1 = new Name("Ambika", "Kabra");  // equals and hashCode check name field value
    Name name2 = new Name("Ambika", "Kabra");
    assertTrue(name1.equals(name2) && name2.equals(name1));
    assertTrue(name1.hashCode() == name2.hashCode());
  }
}