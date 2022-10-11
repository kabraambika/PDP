package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewCarTest {
  NewCar newCar1;
  NewCar newCar2;
  NewCar newCar3;
  MakeModel makeModel;
  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("2010", "Sedan");
    newCar1 = new NewCar("abcdef", 2015, makeModel, 2500.0);
    newCar2 = new NewCar("defghi", 2016, makeModel, 2000.0);
    newCar3 = new NewCar("ghijkl", 2017, makeModel, 1500.0);
  }

  @Test
  void getVehicleInRange() {
    assertEquals(3, newCar1.getVehicleInRange());
  }

  @Test
  void getVehicleInRangeNotEqual() {
    assertNotEquals(1, newCar1.getVehicleInRange());
  }

  @Test
  void testEquals() {
    assertTrue(newCar2.equals(newCar2));
  }

  @Test
  void testEqualsNotNull() {
    assertFalse(newCar2.equals(null));
  }

  @Test
  void testEqualsByDatatype(){
    assertFalse(newCar2.equals(new StringBuffer("test0")));
  }

  @Test
  void testEqualsNotSame(){
    assertFalse(newCar2.equals(newCar3));
  }

  @Test
  void testEqualsByInstance() {
    assertTrue(newCar2.equals(new NewCar("defghi", 2016, makeModel, 2000.0)));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(newCar2.hashCode(), newCar2.hashCode());
  }

  @Test
  void testHashCodeNotSame() {
    MakeModel makeModel4 = new MakeModel("2010", "Sedan");
    NewCar newCar4 = new NewCar("abcdef", 2015, makeModel4, 2500.0);
    assertNotEquals(newCar4.hashCode(), newCar2.hashCode());
  }

  @Test
  void testHashCode() {
    MakeModel makeModel4 = new MakeModel("2010", "Sedan");
    NewCar newCar4 = new NewCar("abcdef", 2015, makeModel4, 2500.0);
    assertEquals(newCar1.hashCode(), newCar4.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuffer test0 = new StringBuffer("test0");
    assertNotEquals(newCar3.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "NewCar{" +
        "vehicleInRange=" + 3 +
        '}';
    assertEquals(expectedString, newCar2.toString());
  }
}