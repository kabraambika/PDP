package assignment2.pickupsystem;

import java.util.Objects;

/**
 * Represent Customer CustomerName with first name, middle name, last name
 */
public class CustomerName {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * CustomerName class constructor
   *
   * @param firstName  - First name of customer
   * @param middleName - middle name of customer
   * @param lastName   - last name of customer
   */
  public CustomerName(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Getter of first name property
   *
   * @return this.firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Getter of last name property
   *
   * @return this.lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Getter of middle name property
   *
   * @return this.middleName
   */
  public String getMiddleName() {
    return this.middleName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CustomerName customerName = (CustomerName) obj;
    return Objects.equals(this.getFirstName(), customerName.getFirstName()) &&
        Objects.equals(this.getMiddleName(), customerName.getMiddleName()) &&
        Objects.equals(this.getLastName(), customerName.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getMiddleName(), this.getLastName());
  }

  @Override
  public String toString() {
    return "CustomerName{" +
        "firstName='" + this.getFirstName() + '\'' +
        "middleName='" + this.getMiddleName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}