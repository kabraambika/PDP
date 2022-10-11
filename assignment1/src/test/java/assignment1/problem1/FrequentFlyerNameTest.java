package assignment1.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrequentFlyerNameTest {
  private String firstName;
  private String middleName;
  private String lastName;
  private FrequentFlyerName name;
  @BeforeEach
  void setUp() {
    firstName = "Amy";
    middleName = "J";
    lastName = "Brown";
    name = new FrequentFlyerName(firstName, middleName, lastName);
  }

  @Test
  void getFirstName() {
    assertEquals(firstName, name.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals(middleName, name.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals(lastName, name.getLastName());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(name.equals(name));
  }

  @Test
  void testEquals_Same() {
    FrequentFlyerName dupName = new FrequentFlyerName(firstName, middleName, lastName);
    assertTrue(name.equals(dupName));
  }

  @Test
  void testEquals_NotSame() {
    FrequentFlyerName name1 = new FrequentFlyerName(firstName, null, lastName);
    assertFalse(name.equals(name1));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(name.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(name.equals(new StringBuilder("test")));
  }

  @Test
  void testEquals_Param1() {
    FrequentFlyerName dupName = new FrequentFlyerName(null, middleName, lastName);
    assertFalse(name.equals(dupName));
  }

  @Test
  void testEquals_Param3() {
    FrequentFlyerName dupName = new FrequentFlyerName(firstName, middleName, null);
    assertFalse(name.equals(dupName));
  }

  @Test
  void testHashCode() {
    Object expHashcode = Objects.hash(firstName, middleName, lastName);
    assertEquals(expHashcode, name.hashCode());
  }

  @Test
  void testToString() {
    String expString = "FrequentFlyerName{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
    assertEquals(expString, name.toString());
  }
}