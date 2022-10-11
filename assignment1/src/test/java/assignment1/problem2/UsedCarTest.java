package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsedCarTest {
  MakeModel makeModel1;
  MakeModel makeModel2;
  MakeModel makeModel3;
  UsedCar usedCar1;
  UsedCar usedCar2;
  UsedCar usedCar3;

  @BeforeEach
  void setUp() {
    makeModel1 = new MakeModel("2010", "Sedan");
    makeModel2 = new MakeModel("2011", "BMW");
    makeModel3 = new MakeModel("2012", "Tesla");
    usedCar1 = new UsedCar("abcdef", 2015, makeModel1, 2500.0, 20,1, 0);
    usedCar2 = new UsedCar("qwerty", 2019, makeModel2, 5000.0, 30,2, 1);
    usedCar3 = new UsedCar("zxcvbn", 2018, makeModel3, 1000.0, 16,5, 2);
  }

  @Test
  void getMileage() {
    assertEquals(20, usedCar1.getMileage());
  }

  @Test
  void getNumPrevOwner() {
    assertEquals(1, usedCar1.getNumPrevOwner());
  }

  @Test
  void getNumOfAccident() {
    assertEquals(0, usedCar1.getNumOfAccident());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(usedCar1.equals(usedCar1));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(usedCar1.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(usedCar1.equals(new StringBuffer("test0")));
  }

  @Test
  void testEquals_NotSame(){
    assertFalse(usedCar2.equals(usedCar1));
  }

  @Test
  void testEquals_Same() {
   MakeModel makeModel = new MakeModel("2010", "Sedan");
   UsedCar usedCar = new UsedCar("abcdef", 2015, makeModel, 2500.0, 20,1, 0);

    assertTrue(usedCar.equals(usedCar1));
  }

  @Test
  void testEqualsByInstance() {
    assertTrue(usedCar1.equals(new UsedCar("abcdef", 2015, new MakeModel("2010", "Sedan"), 2500.0, 20,1, 0)));
  }

  @Test
  void testEquals_Parameter1(){
    UsedCar usedCarParam1 = new UsedCar("abcdef", 2015, new MakeModel("2010", "Sedan"), 2500.0, 0, 1, 0);
    assertFalse(usedCar1.equals(usedCarParam1));
  }

  @Test
  void testEquals_Parameter2(){
    UsedCar usedCarParam1 = new UsedCar("abcdef", 2015, new MakeModel("2010", "Sedan"), 2500.0, 20, 10, 0);
    assertFalse(usedCar1.equals(usedCarParam1));
  }

  @Test
  void testEquals_Parameter3(){
    UsedCar usedCarParam1 = new UsedCar("abcdef", 2015, new MakeModel("2010", "Sedan"), 2500.0, 20, 1, 1);
    assertFalse(usedCar1.equals(usedCarParam1));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(usedCar1.hashCode(), usedCar1.hashCode());
  }

  @Test
  void testHashCodeNotSame() {
    assertNotEquals(usedCar1.hashCode(), usedCar3.hashCode());
  }

  @Test
  void testHashCode() {
    UsedCar usedCar4 = new UsedCar("abcdef", 2015, new MakeModel("2010", "Sedan"), 2500.0, 20,1, 0);
    assertEquals(usedCar1.hashCode(), usedCar4.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuffer test0 = new StringBuffer("test0");
    assertNotEquals(usedCar1.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "UsedCar{" +
        "mileage=" + 20 +
        ", numPrevOwner=" + 1 +
        ", numOfAccident=" + 0 +
        '}';
    assertEquals(expectedString, usedCar1.toString());
  }
}