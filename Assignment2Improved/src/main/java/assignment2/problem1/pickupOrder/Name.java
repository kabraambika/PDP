package assignment2.problem1.pickupOrder;

import java.util.Objects;

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

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
}
