package assignment1.problem2;

/**
 * a custom enumeration with possible value: Sail Power, Inboard Engine,
 * Outboard Engine, Jet Propulsion.
 * @author Ambika kabra, kabraambika19
 */
public enum PropulsionType {
  /**
   * Enum constant ordinal: 0
   */
  SAIL_POWER("SAIL_POWER"),
  /**
   * Enum constant ordinal: 1
   */
  INBOARD_ENGINE("INBOARD_ENGINE"),
  /**
   * Enum constant ordinal: 2
   */
  OUTBOARD_ENGINE("OUTBOARD_ENGINE"),
  /**
   * Enum constant ordinal: 3
   */
  JET_PROPULSION("JET_PROPULSION");

  /**
   * Value of propulsionType
   */
  private final String propulsionType;

  /**
   * @param propulsionType represented as an PropulsionType
   */
  PropulsionType(String propulsionType) {
    this.propulsionType = propulsionType;
  }

  @Override
  public String toString() {
    return "PropulsionType{" +
        "propulsionType='" + this.propulsionType + '\'' +
        '}';
  }
}
