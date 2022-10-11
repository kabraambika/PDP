package Lab3.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {
  private Name testName;
  private BaseballPlayer testPlayer;
  private BaseballPlayer testPlayerWithoutLeague;
  private Name expectedName;
  private BaseballPlayer testPlayer2;

  @BeforeEach
  void setUp() {
    testName = new Name("Matt", "J.", "Boyd");
    expectedName = new Name("Matt", "J.", "Boyd");
    testPlayer = new BaseballPlayer(testName, 6.2, 185.0, "MLB", "Seattle Mariners", 1.35, 12);
    testPlayerWithoutLeague = new BaseballPlayer(testName, 6.2, 185.0, "Seattle Mariners", 1.35, 12);
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testName);
  }

  @Test
  void getHeight() {
    assertEquals(6.2, testPlayer.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(185.0, testPlayer.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals("MLB", testPlayer.getLeague());
  }

  @Test
  void getTeam() {
    assertEquals("Seattle Mariners", testPlayer.getTeam());
  }

  @Test
  void getAverageBatting() {
    assertEquals(1.35, testPlayer.getAvgBattingScore());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(12, testPlayer.getSeasonHomeRuns());
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
    testPlayer2 = new BaseballPlayer(new Name("Matt", "J.", "Boyd"), 6.2, 185.0, "MLB", "Seattle Mariners", 1.35, 12);
    assertTrue(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentName() {
    testPlayer2 = new BaseballPlayer(new Name("John", "J.", "Boyd"), 6.2, 185.0, "MLB", "Seattle Mariners", 1.35, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentHeight() {
    testPlayer2 = new BaseballPlayer(testName, 6.0, 185.0, "MLB", "Seattle Mariners", 1.35, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentWeight() {
    testPlayer2 = new BaseballPlayer(testName, 6.2, 180.0, "MLB", "Seattle Mariners", 1.35, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentLeague() {
    testPlayer2 = new BaseballPlayer(testName, 6.2, 185.0, null, "Seattle Mariners", 1.35, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentTeam() {
    testPlayer2 = new BaseballPlayer(testName, 6.2, 185.0, "MLB", null, 1.35, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentAvgBattingScore() {
    testPlayer2 = new BaseballPlayer(testName, 6.2, 185.0, "MLB", "Seattle Mariners", null, 12);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testEquals_DifferentSeasonHomeRuns() {
    testPlayer2 = new BaseballPlayer(testName, 6.2, 185.0, "MLB", "Seattle Mariners", 1.35, null);
    assertFalse(testPlayer.equals(testPlayer2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testPlayer.getAthletesName(), testPlayer.getHeight(), testPlayer.getWeight(), testPlayer.getLeague()), testPlayer.getTeam(), testPlayer.getAvgBattingScore(), testPlayer.getSeasonHomeRuns());
    assertEquals(expectedHashCode, testPlayer.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "BaseballPlayer{" +
        " athletesName=" + testName +
        ", height=" + 6.2 +
        ", weight=" + 185.0 +
        ", league='" + "MLB" + '\'' +
        ", team='" + "Seattle Mariners" + '\'' +
        ", avgBattingScore=" + 1.35 +
        ", seasonHomeRuns=" + 12 +
        '}';
    assertEquals(expectedString, testPlayer.toString());
  }
}