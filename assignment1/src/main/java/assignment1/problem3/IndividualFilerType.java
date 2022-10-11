package assignment1.problem3;

/**
 * Enum of type of individual tax filer
 * @author Ambika Kabra, kabraambika19
 */
public enum IndividualFilerType {
  /**
   * Enum constant ordinal: 0
   */
  EMPLOYEE("EMPLOYEE");
  /**
   * Value of Individual filer type
   */
  private final String indFilerType;

  /**
   * @param indFilerType Value of Individual filer type
   */
  IndividualFilerType(String indFilerType) {
    this.indFilerType = indFilerType;
  }

  @Override
  public String toString() {
    return "IndividualFilerType{" +
        "indFilerType='" + indFilerType + '\'' +
        '}';
  }
}
