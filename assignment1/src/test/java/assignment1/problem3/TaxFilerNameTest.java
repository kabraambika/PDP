package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaxFilerNameTest {

  TaxFilerName name1;
  TaxFilerName name2;
  TaxFilerName name3;

  @BeforeEach
  void setUp() {
    name1 = new TaxFilerName("Ambika", "");
    name2 = new TaxFilerName("Olivia", "Lincoln");
    name3 = new TaxFilerName("Mr", "Brown");
  }

  @Test
  void getFirstName() {
    assertEquals("Ambika", name1.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("", name1.getLastName());
  }

  @Test
  void testEquals() {
    assertTrue(name2.equals(name2));
  }

  @Test
  void testEqualsNotNull() {
    assertFalse(name2.equals(null));
  }

  @Test
  void testEqualsByDatatype(){
    assertFalse(name2.equals(new StringBuffer("test0")));
  }

  @Test
  void testEqualsNotSame(){
    assertFalse(name3.equals(name2));
  }

  @Test
  void testEqualsByInstance() {
    assertTrue(name2.equals(new TaxFilerName("Olivia", "Lincoln")));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(name2.hashCode(), name2.hashCode());
  }

  @Test
  void testEquals_Parameter1() {
    assertFalse(name2.equals(new TaxFilerName("", "Lincoln")));
  }

  @Test
  void testEquals_Parameter2() {
    assertFalse(name2.equals(new TaxFilerName("Olivia", "")));
  }

  @Test
  void testHashCodeNotSame() {
    TaxFilerName name4 = new TaxFilerName("Ambika", "");
    assertNotEquals(name4.hashCode(), name2.hashCode());
  }

  @Test
  void testHashCode() {
    TaxFilerName name4 = new TaxFilerName("Ambika", "");
    assertEquals(name4.hashCode(), name1.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuffer test0 = new StringBuffer("test0");
    assertNotEquals(name2.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String expectedName = "TaxFilerName{" +
        "firstName='" + "Ambika" + '\'' +
        ", lastName='" + "" + '\'' +
        '}';

    assertEquals(expectedName, name1.toString());
  }
}