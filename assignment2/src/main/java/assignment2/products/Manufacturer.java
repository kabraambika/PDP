package assignment2.products;

import java.util.Objects;

/**
 * Manufacturer class provides name of product manufacturer
 */
public class Manufacturer {

  private String manufacturerName;

  /**
   * Constructor of Manufacturer
   *
   * @param manufacturerName manufacturer name, represented as String e.g. Beechers
   */
  public Manufacturer(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  /**
   * @return this.manufacturer
   */
  public String getManufacturerName() {
    return this.manufacturerName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Manufacturer that = (Manufacturer) obj;
    return Objects.equals(this.getManufacturerName(), that.getManufacturerName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getManufacturerName());
  }

  @Override
  public String toString() {
    return "Manufacturer{" +
        "manufacturerName='" + this.getManufacturerName() + '\'' +
        '}';
  }
}
