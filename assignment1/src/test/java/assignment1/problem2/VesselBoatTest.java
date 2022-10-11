package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VesselBoatTest {
  VesselBoat vesselBoat1;
  MakeModel makeModel1;
  VesselBoat vesselBoat2;
  MakeModel makeModel2;
  VesselBoat vesselBoat3;
  MakeModel makeModel3;
  @BeforeEach
  void setUp() {
    makeModel1 = new MakeModel("2010", "Boat1");
    makeModel2 = new MakeModel("2011", "Boat2");
    makeModel3 = new MakeModel("2012", "Boat3");
    vesselBoat1 = new VesselBoat("abcdef", 2015, makeModel1, 2500.0, 10.5f, 12, PropulsionType.INBOARD_ENGINE);
    vesselBoat2 = new VesselBoat("qwerty", 2016, makeModel2, 3000.0, 20f, 25, PropulsionType.SAIL_POWER);
    vesselBoat3 = new VesselBoat("asdfgh", 2017, makeModel3, 4000.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
  }

  @Test
  void getBoatLength() {
    assertEquals(10.5f, vesselBoat1.getBoatLength());
  }

  @Test
  void getPassengerNum() {
    assertEquals(12, vesselBoat1.getPassengerNum());
  }

  @Test
  void getPropulsionType() {
    assertEquals(PropulsionType.INBOARD_ENGINE, vesselBoat1.getPropulsionType());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(vesselBoat3.equals(vesselBoat3));
  }

  @Test
  void testEquals_Same() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 4000.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertTrue(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(vesselBoat1.equals(null));
  }

  @Test
  void testEquals_ByInstance(){
    assertFalse(vesselBoat1.equals(new StringBuffer("test0")));
  }

  @Test
  void testEquals_NotSame(){
    assertFalse(vesselBoat1.equals(vesselBoat2));
  }

  @Test
  void testEquals_Parameter1() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("qwerty", 2017, makeModel4, 4000.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter2() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2016, makeModel4, 4000.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter3() {
    MakeModel makeModel4 = new MakeModel("2011", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 4000.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter4() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 400.0, 16.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter5() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 4000.0, 12.4f, 20, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter6() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 4000.0, 16.4f, 2, PropulsionType.OUTBOARD_ENGINE);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testEquals_Parameter7() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("asdfgh", 2017, makeModel4, 4000.0, 16.4f, 20, PropulsionType.JET_PROPULSION);
    assertFalse(vesselBoat3.equals(vesselBoat4));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(vesselBoat1.hashCode(), vesselBoat1.hashCode());
  }

  @Test
  void testHashCodeNotSame() {
    MakeModel makeModel4 = new MakeModel("2012", "Boat3");
    VesselBoat vesselBoat4 = new VesselBoat("abcdef", 2015, makeModel4, 2500.0, 10.5f, 12, PropulsionType.JET_PROPULSION);
    assertNotEquals(vesselBoat2.hashCode(),  vesselBoat4.hashCode());
  }

  @Test
  void testHashCode() {
    MakeModel makeModel4 = new MakeModel("2010", "Boat1");
    VesselBoat vesselBoat4 = new VesselBoat("abcdef", 2015, makeModel4, 2500.0, 10.5f, 12, PropulsionType.INBOARD_ENGINE);
    assertEquals(vesselBoat1.hashCode(), vesselBoat4.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuffer test0 = new StringBuffer("test0");
    assertNotEquals(vesselBoat3.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "VesselBoat{" +
        "boatLength=" + 10.5f +
        ", passengerNum=" + 12 +
        ", propulsionType=" + PropulsionType.INBOARD_ENGINE +
        '}';
    assertEquals(expectedString, vesselBoat1.toString());
  }
}