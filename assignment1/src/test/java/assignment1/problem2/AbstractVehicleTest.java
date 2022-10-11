package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractVehicleTest {

  AbstractVehicle aVehicle;
  MakeModel makeModel;
  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("2012", "BMW");
    aVehicle = new VehicleCar("123456",2012, makeModel, 12000.0);
  }

  @Test
  void getVehicleID() {
    assertEquals("123456", aVehicle.getVehicleID());
  }

  @Test
  void getManufactureYr() {
    assertEquals(2012, aVehicle.getManufactureYr());
  }

  @Test
  void getMakeModel() {
    assertEquals(makeModel, aVehicle.getMakeModel());
  }

  @Test
  void getMsrp() {
    assertEquals(12000.0, aVehicle.getMsrp());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(aVehicle.equals(aVehicle));
  }

  @Test
  void testEquals_NotSame() {
    MakeModel makeModel2 = new MakeModel("2016", "Sedan");
    AbstractVehicle aVehicle2 = new VehicleCar("654321",2016, makeModel2, 1200.0);
    assertFalse(aVehicle.equals(aVehicle2));
  }

  @Test
  void testEquals_Same() {
    MakeModel dupMakeModel = new MakeModel("2012", "BMW");
    AbstractVehicle dupAVehicle = new VehicleCar("123456",2012, dupMakeModel, 12000.0);
    assertTrue(aVehicle.equals(dupAVehicle));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(aVehicle.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(aVehicle.equals(new StringBuffer("test")));
  }

  @Test
  void testEquals_Parameter1(){
    MakeModel dupMakeModel1 = new MakeModel("2012", "BMW");
    AbstractVehicle dupAVehicle1 = new VehicleCar("1234",2012, dupMakeModel1, 12000.0);
    assertFalse(aVehicle.equals(dupAVehicle1));
  }

  @Test
  void testEquals_Parameter2(){
    MakeModel dupMakeModel1 = new MakeModel("2012", "BMW");
    AbstractVehicle dupAVehicle1 = new VehicleCar("123456",2016, dupMakeModel1, 12000.0);
    assertFalse(aVehicle.equals(dupAVehicle1));
  }

  @Test
  void testEquals_Parameter3(){
    MakeModel makeModel1 = new MakeModel("2016", "Sedan");
    AbstractVehicle dupAVehicle1 = new VehicleCar("123456",2012, makeModel1, 12000.0);
    assertFalse(aVehicle.equals(dupAVehicle1));
  }

  @Test
  void testEquals_Parameter4(){
    MakeModel dupMakeModel1 = new MakeModel("2012", "BMW");
    AbstractVehicle dupAVehicle1 = new VehicleCar("123456",2012, dupMakeModel1, 1200.0);
    assertFalse(aVehicle.equals(dupAVehicle1));
  }

  @Test
  void testHashCode_BySame() {
    MakeModel dupMakeModel1 = new MakeModel("2016", "BMW");
    AbstractVehicle dupAVehicle1 = new VehicleCar("123456",2012, dupMakeModel1, 1200.0);
    MakeModel dupMakeModel2 = new MakeModel("2016", "BMW");
    AbstractVehicle dupAVehicle2 = new VehicleCar("123456",2012, dupMakeModel2, 1200.0);

    assertEquals(dupAVehicle1.hashCode(), dupAVehicle2.hashCode());
  }

  @Test
  void testHashCode_Itself() {
    assertEquals(aVehicle.hashCode(), aVehicle.hashCode());
  }

  @Test
  void testHashCode_ByInstance() {
    StringBuffer sb = new StringBuffer("TEST");
    assertNotEquals(sb.hashCode(), aVehicle.hashCode());
  }

  @Test
  void testToString() {
    String makeModelStr = "MakeModel{" +
        "vehicleMake='" + "2012" + '\'' +
        ", vehicleModel='" + "BMW" + '\'' +
        '}';
    String expectedString = "AbstractVehicle{" +
        "vehicleID='" + 123456 + '\'' +
        ", manufactureYr=" + 2012 +
        ", makeModel=" + makeModelStr +
        ", msrp=" + 12000.0 +
        '}';
    assertEquals(expectedString, aVehicle.toString());
  }
}