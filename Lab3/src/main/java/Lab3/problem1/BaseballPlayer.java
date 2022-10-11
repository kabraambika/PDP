package Lab3.problem1;

import java.util.Objects;

/**
 * BaseballPlayer class inherit states and behavior of the class Athlete and also contains addition information such as
 * team, average batting, season home runs
 */
public class BaseballPlayer extends Athlete{
  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;
  /**
   * Constructs a new baseball athlete, based upon all the provided input parameters.
   * @param athletesName - object Name, containing athlete's first, middle and last   name
   * @param height       - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm)
   * @param weight       - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200
   *                     pounds)
   * @param league       - athlete league, expressed as String
   * @param team         - Team, expressed as a String
   * @param avgBattingScore - Average batting, expressed as a Double
   * @param seasonHomeRuns - Season home runs, expressed as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team, Double avgBattingScore,  Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructs a new baseball athlete, based upon all the provided input parameters.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height       - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm)
   * @param weight       - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200
   *                     pounds)
   * @param team         - Team, expressed as a String
   * @param avgBattingScore - Average batting, expressed as a Double
   * @param seasonHomeRuns - Season home runs, expressed as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team, Double avgBattingScore,  Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Getter method for team property
   * @return this.team, String
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Getter method for average batting score
   * @return this.avgBattingScore, Double
   */
  public Double getAvgBattingScore() {
    return this.avgBattingScore;
  }

  /**
   * Getter method for session home runs
   * @return this.seasonHomeRuns, Integer
   */
  public Integer getSeasonHomeRuns() {
    return this.seasonHomeRuns;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) obj;
    return Objects.equals(this.getTeam(), that.getTeam()) && Objects.equals(
        this.getAvgBattingScore(), that.getAvgBattingScore()) && Objects.equals(
        this.getSeasonHomeRuns(), that.getSeasonHomeRuns());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getTeam(), this.getAvgBattingScore(), this.getSeasonHomeRuns());
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        " athletesName=" + getAthletesName() +
        ", height=" + getHeight() +
        ", weight=" + getWeight() +
        ", league='" + getLeague() + '\'' +
        ", team='" + this.getTeam() + '\'' +
        ", avgBattingScore=" + this.getAvgBattingScore() +
        ", seasonHomeRuns=" + this.getSeasonHomeRuns() +
        '}';
  }
}
