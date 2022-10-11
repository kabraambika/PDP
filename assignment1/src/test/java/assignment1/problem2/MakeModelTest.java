package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeModelTest {
  MakeModel makeModel;
  MakeModel makeModel1;
  MakeModel makeModel2;

  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("2010", "Sedan");
    makeModel1 = new MakeModel("2021", "BMW");
    makeModel2 = new MakeModel("2012", "Alto");

  }

  @Test
  void getVehicleMakeNotEqual() {
    assertNotEquals("2011", makeModel.getVehicleMake());
  }

  @Test
  void getVehicleMakeEqual() {
    assertEquals("2010", makeModel.getVehicleMake());
  }

  @Test
  void getVehicleModel() {
    assertEquals("Sedan", makeModel.getVehicleModel());
  }

  @Test
  void getVehicleModelNotEqual() {
    assertNotEquals("BMW", makeModel.getVehicleModel());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(makeModel2.equals(makeModel2));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(makeModel1.equals(null));
  }

  @Test
  void testEquals_ByInstance(){
    assertFalse(makeModel1.equals(new StringBuffer("test0")));
  }

  @Test
  void testEquals_NotSame(){
      assertFalse(makeModel1.equals(makeModel2));
  }

  @Test
  void testEquals_Same() {
    assertTrue(makeModel1.equals(new MakeModel("2021", "BMW")));
  }

  @Test
  void testEquals_parameter1(){
    MakeModel param1 = new MakeModel("2012", "Sedan");
    assertFalse(param1.equals(makeModel));
  }

  @Test
  void testEquals_parameter2(){
    MakeModel param2 = new MakeModel("2010", "Tracker");
    assertFalse(param2.equals(makeModel));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(makeModel1.hashCode(), makeModel1.hashCode());
  }

  @Test
  void testHashCodeNotSame() {
    MakeModel makeModel3 = new MakeModel("2021", "BMW");
    assertNotEquals(makeModel3.hashCode(), makeModel2.hashCode());
  }

  @Test
  void testHashCode() {
    MakeModel makeModel3 = new MakeModel("2021", "BMW");
    assertEquals(makeModel1.hashCode(), makeModel3.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuffer test0 = new StringBuffer("test0");
    assertNotEquals(makeModel1.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "MakeModel{" +
        "vehicleMake='" + "2021" + '\'' +
        ", vehicleModel='" + "BMW" + '\'' +
        '}';
    assertEquals(expectedString, makeModel1.toString());
  }
}