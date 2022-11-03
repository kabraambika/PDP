package assignment3.problem1.commandline;

import java.util.Objects;

/**
 * EmailOption class represents --email option in argument
 * @author kabraambika19
 */
public class EmailOption {
  private Boolean emailSwitch;

  /**
   * Constructor of EmailOption
   * @param emailSwitch Boolean for --email option
   */
  public EmailOption(Boolean emailSwitch) {
    this.emailSwitch = emailSwitch;
  }

  /**
   * Gets the boolean value of --email option
   * @return Boolean
   */
  public Boolean getEmailSwitch() {
    return this.emailSwitch;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    EmailOption that = (EmailOption) obj;
    return Objects.equals(this.getEmailSwitch(), that.getEmailSwitch());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getEmailSwitch());
  }

  @Override
  public String toString() {
    return "EmailOption{" +
        "emailSwitch=" + this.getEmailSwitch() +
        '}';
  }

}
