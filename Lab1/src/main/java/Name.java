import java.util.Objects;

/**
 * Represent Name with first name, last name
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Name class constructor
   * @param firstName - First name of author
   * @param lastName - last name of author
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * function used to return first name
   * @return this.firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * function used to return last name
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
    return Objects.equals(getFirstName(), name.getFirstName()) && Objects.equals(getLastName(),
        name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }
}
