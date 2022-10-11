package assignment1.problem3;

/**
 * Enum of type of group tax filer
 */
public enum GroupFilerType {
  /**
   * Enum constant ordinal: 0
   */
  MARRIED_FILLING_JOINTLY("MARRIED_FILLING_JOINTLY"),
  /**
   * Enum constant ordinal: 1
   */
  MARRIED_FILLING_SEPARATELY("MARRIED_FILLING_SEPARATELY"),
  /**
   * Enum constant ordinal: 2
   */
  HEAD_OF_THE_HOUSEHOLD("HEAD_OF_THE_HOUSEHOLD");

  /**
   * Value of Group filer type
   */
  private final String grpFilerType;

  /**
   * @param grpFilerType Value of Group filer type
   */
  GroupFilerType(String grpFilerType) {
    this.grpFilerType = grpFilerType;
  }

  @Override
  public String toString() {
    return "GroupFilerType{" +
        "grpFilerType='" + grpFilerType + '\'' +
        '}';
  }
}
