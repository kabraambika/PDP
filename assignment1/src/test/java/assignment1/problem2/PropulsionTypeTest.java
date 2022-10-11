package assignment1.problem2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropulsionTypeTest {
  PropulsionType pType1;
  PropulsionType pType2;
  PropulsionType pType3;
  PropulsionType pType4;

  @BeforeEach
  void setUp() {
    pType1 = PropulsionType.SAIL_POWER;
    pType2 = PropulsionType.INBOARD_ENGINE;
    pType3 = PropulsionType.OUTBOARD_ENGINE;
    pType4 = PropulsionType.JET_PROPULSION;
  }

  @Test
  void getPropulsionType() {
    assertEquals(PropulsionType.SAIL_POWER, pType1);
  }

  @Test
  void testToString() {
    String expectedString = "PropulsionType{" +
        "propulsionType='" + "SAIL_POWER" + '\'' +
        '}';
    assertEquals(expectedString, pType1.toString());
  }

  @Test
  void testValues() {
    assertTrue((pType1.compareTo(PropulsionType.SAIL_POWER) == 0));
    assertTrue((pType2.compareTo(PropulsionType.INBOARD_ENGINE) == 0));
    assertTrue((pType3.compareTo(PropulsionType.OUTBOARD_ENGINE) == 0));
    assertTrue((pType4.compareTo(PropulsionType.JET_PROPULSION) == 0));
  }
}