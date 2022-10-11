package Lab3.problem1;

import java.util.Objects;

/**
 * Name class contains information of athlete first name, middle name and last name
 */
public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * @param firstName Athlete first name, represented as String
   * @param middleName Athlete middle name, represented as String
   * @param lastName Athlete last name, represented as String
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * @return this.firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * @return this.middleName
   */
  public String getMiddleName() {
    return this.middleName;
  }

  /**
   * @return this.lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(this.getFirstName(), name.getFirstName()) && Objects.equals(
        this.getMiddleName(), name.getMiddleName()) && Objects.equals(this.getLastName(),
        name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getMiddleName(), this.getLastName());
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", middleName='" + this.getMiddleName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
