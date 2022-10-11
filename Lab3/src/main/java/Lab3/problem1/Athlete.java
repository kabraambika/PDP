package Lab3.problem1;

import java.util.Objects;

/**
 * Class Athlete contains information about an athlete, including athlete's name, their height, weight and league
 */
public class Athlete {
  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last   name
   * @param height - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete league, expressed as String
   */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   */
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * @return this.athletesName
   */
  public Name getAthletesName() {
    return this.athletesName;
  }

  /**
   * @return this.height
   */
  public Double getHeight() {
    return this.height;
  }

  /**
   * @return this.weight
   */
  public Double getWeight() {
    return this.weight;
  }

  /**
   * @return this.league
   */
  public String getLeague() {
    return this.league;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(this.getAthletesName(), athlete.getAthletesName())
        && Objects.equals(this.getHeight(), athlete.getHeight()) && Objects.equals(
        this.getWeight(), athlete.getWeight()) && Objects.equals(this.getLeague(),
        athlete.getLeague());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getAthletesName(), this.getHeight(), this.getWeight(), this.getLeague());
  }

  @Override
  public String toString() {
    return "Athlete{" +
        "athletesName=" + this.athletesName +
        ", height=" + this.height +
        ", weight=" + this.weight +
        ", league='" + this.league + '\'' +
        '}';
  }
}
