package Lab3.problem1;

import java.util.Objects;

/**
 * Runner class inherit states and behavior of the class Athlete and also contains addition information such as
 * best 5K time, half Marathon Time, Favorite Running Time
 */
public class Runner extends Athlete {
  private Double best5KTime;
  private Double halfMarathonTime;
  private String favRunningEvent;

  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last   name
   * @param height       - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm)
   * @param weight       - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200
   *                     pounds)
   * @param league       - athlete league, expressed as String
   * @param best5KTime   - the best 5K time, expressed as a Double
   * @param halfMarathonTime - the best half-marathon time, expressed as a Double
   * @param favRunningEvent   - Favorite running event, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league, Double best5KTime, Double halfMarathonTime, String favRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.halfMarathonTime = halfMarathonTime;
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * Constructs a new athlete, based upon all the provided input parameters.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height       - athlete height, expressed as a Double in cm (e.g., 6'2'' is recorded as
   *                     187.96cm)
   * @param weight       - athlete weight, expressed as a Double in pounds (e.g. 125, 155, 200
   *                     pounds)
   * @param best5KTime   - the best 5K time, expressed as a Double
   * @param halfMarathonTime - the best half-marathon time, expressed as a Double
   * @param favRunningEvent   - Favorite running event, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KTime, Double halfMarathonTime, String favRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.halfMarathonTime = halfMarathonTime;
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * @return this.best5KTime
   */
  public Double getBest5KTime() {
    return this.best5KTime;
  }

  /**
   * @return this.halfMarathonTime
   */
  public Double getHalfMarathonTime() {
    return this.halfMarathonTime;
  }

  /**
   * @return this.favRunningEvent
   */
  public String getFavRunningEvent() {
    return this.favRunningEvent;
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
    Runner runner = (Runner) obj;
    return Objects.equals(this.getBest5KTime(), runner.getBest5KTime())
        && Objects.equals(this.getHalfMarathonTime(), runner.getHalfMarathonTime())
        && Objects.equals(this.getFavRunningEvent(), runner.getFavRunningEvent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getBest5KTime(), this.getHalfMarathonTime(),
        this.getFavRunningEvent());
  }

  @Override
  public String toString() {
    return "Runner{" +
        "athletesName=" + getAthletesName() +
        ", height=" + getHeight() +
        ", weight=" + getWeight() +
        ", league='" + getLeague() + '\'' +
        ", best5KTime=" + this.getBest5KTime() +
        ", halfMarathonTime=" + this.getHalfMarathonTime() +
        ", favRunningEvent='" + this.getFavRunningEvent() + '\'' +
        '}';
  }
}
