package Lab3.problem1;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AthleteTest {
  private Athlete athlete1;
  private Athlete athleteWithLeague;
  private Name name1;
  @BeforeEach
  void setUp() {
    name1 = new Name("John", "J", "Brown");
    athlete1 = new Athlete(name1, 6.5, 180.0, null);
    athleteWithLeague = new Athlete(name1, 6.5, 180.0);
  }

  @Test
  void getAthletesName() {
    assertEquals(name1, athlete1.getAthletesName());
    assertEquals(name1, athleteWithLeague.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(6.5, athlete1.getHeight());
    assertEquals(6.5, athleteWithLeague.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(180.0, athlete1.getWeight());
    assertEquals(180.0, athleteWithLeague.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(null, athlete1.getLeague());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(athlete1.equals(athlete1));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(athlete1.equals(null));
  }

  @Test
  void testEquals_SimilarObject() {
    Name name2 = new Name("John", "J", "Brown");
    Athlete athlete2 = new Athlete(name2, 6.5, 180.0, null);
    assertTrue(athlete1.equals(athlete2));
  }

  @Test
  void testEquals_DifferentObject() {
    String test = new String("test1");
    assertFalse(athlete1.equals(test));
  }

  @Test
  void testEquals_DifferentName() {
    Athlete athlete2 = new Athlete(null, 6.5, 180.0, null);
    assertFalse(athlete1.equals(athlete2));
  }

  @Test
  void testEquals_DifferentHeight() {
    Name name2 = new Name("John", "J", "Brown");
    Athlete athlete2 = new Athlete(name2, null, 180.0, null);
    assertFalse(athlete1.equals(athlete2));
  }

  @Test
  void testEquals_DifferentWeight() {
    Name name2 = new Name("John", "J", "Brown");
    Athlete athlete2 = new Athlete(name2, 6.5, null, null);
    assertFalse(athlete1.equals(athlete2));
  }

  @Test
  void testEquals_DifferentLeague() {
    Name name2 = new Name("John", "J", "Brown");
    Athlete athlete2 = new Athlete(name2, 6.5, 180.0, "MLB");
    assertFalse(athlete1.equals(athlete2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(name1, 6.5, 180.0, null);
    assertEquals(expectedHashCode, athlete1.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Athlete{" +
        "athletesName=" + name1 +
        ", height=" + 6.5 +
        ", weight=" + 180.0 +
        ", league='" + null + '\'' +
        '}';

    assertEquals(expectedString, athlete1.toString());
  }

  @Test
  void testGetAthletesName() {
  }

  @Test
  void testGetHeight() {
  }

  @Test
  void testGetWeight() {
  }

  @Test
  void testGetLeague() {
  }
}