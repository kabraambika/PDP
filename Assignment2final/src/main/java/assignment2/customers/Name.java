package assignment2.customers;

import java.util.Objects;

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  public Name(String firstName) {
    this.firstName = firstName;
  }

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(getFirstName(), name.getFirstName()) && Objects.equals(
        getMiddleName(), name.getMiddleName()) && Objects.equals(getLastName(),
        name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName());
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
