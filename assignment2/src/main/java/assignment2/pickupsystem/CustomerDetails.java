package assignment2.pickupsystem;

import java.util.Objects;

/**
 * CustomerDetails keeps track of information of customer details like customerName and age
 *
 * @author kabraambika19
 */
public class CustomerDetails {

  /**
   * MIN_HUMAN_AGE constant for validation of age of customer
   */
  private static final Integer MIN_HUMAN_AGE = 0;
  private CustomerName customerName;
  private Integer age;

  /**
   * Constructor of Customer details
   *
   * @param customerName Customer customerName, represented as CustomerName
   * @param age          Customer age, represented as Integer
   * @throws InvalidAgeException if customer age is less than 0 then throw InvalidAgeException
   */
  public CustomerDetails(CustomerName customerName, Integer age) throws InvalidAgeException {
    if (validateAge(age)) {
      this.customerName = customerName;
      this.age = age;
    } else {
      throw new InvalidAgeException("Invalid customer age provided!");
    }
  }

  /**
   * Getter of customerName property, represented as CustomerName
   *
   * @return this.customerName
   */
  public CustomerName getName() {
    return this.customerName;
  }

  /**
   * Getter of age property, represented as Integer
   *
   * @return this.age
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Checks if age is greater than 0
   *
   * @param age Customer age, Represented as Integer
   * @return boolean, true if age greater than 0 else false
   */
  private boolean validateAge(Integer age) {
    return age > MIN_HUMAN_AGE;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CustomerDetails that = (CustomerDetails) obj;
    return Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getAge(),
        that.getAge());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.getAge());
  }

  @Override
  public String toString() {
    return "CustomerDetails{" +
        "customerName=" + this.getName() +
        ", age=" + this.getAge() +
        '}';
  }
}
