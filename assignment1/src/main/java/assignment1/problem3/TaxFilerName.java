package assignment1.problem3;

import java.util.Objects;

/**
 * A custom class of a tax filer first and last name, represented as a Tax Filer TaxFilerName
 * @author Ambika kabra, ambikakabra19
 */
public class TaxFilerName {
  private String firstName;
  private String lastName;

  /**
   * @param firstName tax filer first name
   * @param lastName tax filer last name
   */
  public TaxFilerName(String firstName, String lastName) {
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
    TaxFilerName taxFilerName = (TaxFilerName) obj;
    return Objects.equals(getFirstName(), taxFilerName.getFirstName()) && Objects.equals(getLastName(),
        taxFilerName.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }

  @Override
  public String toString() {
    return "TaxFilerName{" +
        "firstName='" + getFirstName() + '\'' +
        ", lastName='" + getLastName() + '\'' +
        '}';
  }
}
