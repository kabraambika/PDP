package assignment3.problem1.commandline;

import java.util.Objects;

/**
 * LetterOption class represents --letter option in argument
 * @author kabraambika19
 */
public class LetterOption {
  private Boolean letterSwitch;

  /**
   * Constructor of LetterOption
   * @param letterSwitch Boolean for --letter option
   */
  public LetterOption(Boolean letterSwitch) {
    this.letterSwitch = letterSwitch;
  }

  /**
   * Gets boolean if --letter option present in args or not
   * @return Boolean
   */
  public Boolean getLetterSwitch() {
    return this.letterSwitch;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    LetterOption that = (LetterOption) obj;
    return Objects.equals(this.getLetterSwitch(), that.getLetterSwitch());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getLetterSwitch());
  }

  @Override
  public String toString() {
    return "LetterOption{" +
        "letterSwitch=" + this.getLetterSwitch() +
        '}';
  }
}
