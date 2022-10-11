package Lab3.problem4;

import java.util.Objects;

/**
 * Name class contains information of piece first name and last name
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * @param firstName piece first name, represented as String
   * @param lastName piece last name, represented as String
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return this.firstName
   */
  public String getFirstName() {
    return this.firstName;
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
    return Objects.equals(this.getFirstName(), name.getFirstName()) && Objects.equals(this.getLastName(),
        name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName());
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
