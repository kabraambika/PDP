package assignment1.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MilesBalanceTest {

  private int totalMileAvl;
  private int milesEarnCurrYr;
  private int mileExpCurrYr;

  private MilesBalance milesBalance;
  @BeforeEach
  void setUp() {
    totalMileAvl = 1000;
    milesEarnCurrYr = 100;
    mileExpCurrYr = 900;

    milesBalance = new MilesBalance(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
  }

  @Test
  void getTotalMileAvl() {
    assertEquals(totalMileAvl, milesBalance.getTotalMileAvl());
  }

  @Test
  void getMilesEarnCurrYr() {
    assertEquals(milesEarnCurrYr, milesBalance.getMilesEarnCurrYr());
  }

  @Test
  void getMileExpCurrYr() {
    assertEquals(mileExpCurrYr, milesBalance.getMileExpCurrYr());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(milesBalance.equals(milesBalance));
  }

  @Test
  void testEquals_Same() {
    MilesBalance milesBalance1 = new MilesBalance(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
    assertTrue(milesBalance.equals(milesBalance1));
  }

  @Test
  void testEquals_NotSame() {
    MilesBalance milesBalance1 = new MilesBalance(totalMileAvl, milesEarnCurrYr, 0);
    assertFalse(milesBalance.equals(milesBalance1));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(milesBalance.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(milesBalance.equals(new StringBuilder("test")));
  }

  @Test
  void testEquals_Param1() {
    MilesBalance milesBalance1 = new MilesBalance(0, milesEarnCurrYr, mileExpCurrYr);
    assertFalse(milesBalance.equals(milesBalance1));
  }

  @Test
  void testEquals_Param2() {
    MilesBalance milesBalance1 = new MilesBalance(totalMileAvl, 0, mileExpCurrYr);
    assertFalse(milesBalance.equals(milesBalance1));
  }

  @Test
  void testHashCode() {
    Object expectedHashCode = Objects.hash(totalMileAvl, milesEarnCurrYr, mileExpCurrYr);
    assertEquals(expectedHashCode, milesBalance.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "MilesBalance{" +
        "totalMileAvl=" + totalMileAvl +
        ", milesEarnCurrYr=" + milesEarnCurrYr +
        ", mileExpCurrYr=" + mileExpCurrYr +
        '}';
    assertEquals(expectedString, milesBalance.toString());
  }
}