package assignment1.problem3;

import java.util.Objects;

/**
 *  Tax filer Contact Info, a custom class to keep track of taxFilerName, address, phone number, email address
 * @author Ambika Kabra, kabraambika19
 */
public class ContactInfo {
  private TaxFilerName taxFilerName;
  private String address;
  private String phoneNumber;
  private String emailAddress;

  /**
   * Constructor of ContactInfo
   * @param taxFilerName a tax filer first and last taxFilerName, represented as a TaxFilerName, another custom class
   * @param address a tax filer address, represented as a String
   * @param phoneNumber the tax filer phone number, represented as a String
   * @param emailAddress the tax filer email address, represented as a String
   */
  public ContactInfo(TaxFilerName taxFilerName, String address, String phoneNumber, String emailAddress) {
    this.taxFilerName = taxFilerName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter of taxFilerName
   * @return this.taxFilerName
   */
  public TaxFilerName getName() {
    return this.taxFilerName;
  }

  /**
   * Getter of address
   * @return this.address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Getter of phoneNumber
   * @return this.phoneNumber
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Getter of emailAddress
   * @return this.emailAddress
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ContactInfo that = (ContactInfo) obj;
    return Objects.equals(getName(), that.getName()) && Objects.equals(getAddress(),
        that.getAddress()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber())
        && Objects.equals(getEmailAddress(), that.getEmailAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAddress(), getPhoneNumber(), getEmailAddress());
  }

  @Override
  public String toString() {
    return "ContactInfo{" +
        "taxFilerName=" + getName() +
        ", address='" + getAddress() + '\'' +
        ", phoneNumber='" + getPhoneNumber() + '\'' +
        ", emailAddress='" + getEmailAddress() + '\'' +
        '}';
  }
}
