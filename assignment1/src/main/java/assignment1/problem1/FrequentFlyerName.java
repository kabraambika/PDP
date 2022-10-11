package assignment1.problem1;

import java.util.Objects;

/**
 * This class provides information about frequent flyer first name, middle name, last name
 * @author Ambika kabra, kabraambika19
 */
public class FrequentFlyerName {
  private String firstName;
  private String middleName;
  private String lastName;
  /**
   * @param firstName frequent flyer first name
   * @param middleName frequent flyer middle name
   * @param lastName frequent flyer last name
   */
  public FrequentFlyerName(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * @return this.firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return this.middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * @return this.lastName
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    FrequentFlyerName that = (FrequentFlyerName) obj;
    return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(
        getMiddleName(), that.getMiddleName()) && Objects.equals(getLastName(),
        that.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName());
  }

  @Override
  public String toString() {
    return "FrequentFlyerName{" +
        "firstName='" + getFirstName() + '\'' +
        ", middleName='" + getMiddleName() + '\'' +
        ", lastName='" + getLastName() + '\'' +
        '}';
  }
}
