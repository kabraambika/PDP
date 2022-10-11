package Lab3.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {
  private Runner testPlayer;
  private Name testName;
  private Name expectedName;
  private Runner testPlayerWithoutLeague;
  private Runner testPlayer2;
  @BeforeEach
  void setUp() {
    testName = new Name("Matt", "J.", "Boyd");
    expectedName = new Name("Matt", "J.", "Boyd");
    testPlayer = new Runner(testName, 6.2, 185.0, "MLB", 2.5, 1.35, "Seattle Event");
    testPlayerWithoutLeague = new Runner(testName, 6.2, 185.0, 2.5, 1.35, "Seattle Event");
  }

  @Test
  void getBest5KTime() {
    assertEquals(2.5, testPlayer.getBest5KTime());
  }

  @Test
  void getHalfMarathonTime() {
    assertEquals(1.35, testPlayer.getHalfMarathonTime());
  }

  @Test
  void getFavRunningTime() {
    assertEquals("Seattle Event", testPlayer.getFavRunningEvent());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testPlayer.equals(testPlayer));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testPlayer.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testPlayer.equals(testName));
  }

  @Test
  void testEquals_SimilarAthlete() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, "MLB", 2.5, 1.35, "Seattle Event");
    assertTrue(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentName() {
    testPlayer2 = new Runner(null, 6.2, 185.0, "MLB", 2.5, 1.35, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentHeight() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), null, 185.0, "MLB", 2.5, 1.35, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentWeight() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, null, "MLB", 2.5, 1.35, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentLeague() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, null, 2.5, 1.35, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentBest5k() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, "MLB", null, 1.35, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentHalfMarathon() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, "MLB", 2.5, null, "Seattle Event");
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentEvent() {
    testPlayer2 = new Runner(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, "MLB", 2.5, 1.35, null);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(Objects.hash(testName, 6.2, 185.0, "MLB"), 2.5, 1.35, "Seattle Event");
    assertEquals(expHashcode, testPlayer.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Runner{" +
        "athletesName=" + testName +
        ", height=" + 6.2 +
        ", weight=" + 185.0 +
        ", league='" + "MLB" + '\'' +
        ", best5KTime=" + 2.5 +
        ", halfMarathonTime=" + 1.35 +
        ", favRunningEvent='" + "Seattle Event"+ '\'' +
        '}';
    assertEquals(expectedString, testPlayer.toString());
  }
}