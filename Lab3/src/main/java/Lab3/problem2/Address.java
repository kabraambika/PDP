package Lab3.problem2;

import java.util.Objects;

/**
 * Class Address - address, where the class Address contains information like street Name, city, zip code, state, country
 */
public class Address {
  private String streetNumber;
  private String city;
  private String zipCode;
  private String state;
  private String country;

  /**
   * @param streetNumber String street and number
   * @param city String city
   * @param zipCode String ZIP code
   * @param state String state
   * @param country String country
   */
  public Address(String streetNumber, String city, String zipCode, String state, String country) {
    this.streetNumber = streetNumber;
    this.city = city;
    this.zipCode = zipCode;
    this.state = state;
    this.country = country;
  }

  /**
   * @return this.streetNumber
   */
  public String getStreetNumber() {
    return this.streetNumber;
  }

  /**
   * @return this.city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * @return this.zipCode
   */
  public String getZipCode() {
    return this.zipCode;
  }

  /**
   * @return this.state
   */
  public String getState() {
    return this.state;
  }

  /**
   * @return this.country
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * @param streetNumber String, street and number
   */
  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  /**
   * @param city City name, String
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @param zipCode String, zip code
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * @param state String, state name
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @param country String, country name
   */
  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Address address = (Address) obj;
    return Objects.equals(this.getStreetNumber(), address.getStreetNumber())
        && Objects.equals(this.getCity(), address.getCity()) && Objects.equals(
        this.getZipCode(), address.getZipCode()) && Objects.equals(this.getState(),
        address.getState()) && Objects.equals(this.getCountry(), address.getCountry());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getStreetNumber(), this.getCity(), this.getZipCode(), this.getState(), this.getCountry());
  }

  @Override
  public String toString() {
    return "Address{" +
        "streetNumber='" + this.getStreetNumber() + '\'' +
        ", city='" + this.getCity() + '\'' +
        ", zipCode='" + this.getZipCode() + '\'' +
        ", state='" + this.getState() + '\'' +
        ", country='" + this.getCountry() + '\'' +
        '}';
  }
}
