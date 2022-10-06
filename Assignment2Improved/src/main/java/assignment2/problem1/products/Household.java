package assignment2.problem1.products;

import assignment2.problem1.Manufacturer;
import java.util.Objects;

/**
 * Household is an abstract class for all household products.
 * It extends AbstractProduct class as well.
 * It contains information like: manufacturer, productName, price, minimum age, number of individual units in a package.
 * @author Kabraambika19
 */
public abstract class Household extends AbstractProduct{
  protected Integer unitsPerPackage;

  /**
   * Constructor of Household class
   * @param manufacturer product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName product name, represented as a String
   * @param price product price, represented as a Double
   * @param minimumAge minimum age required for the product like for product beer, minimum age can be 21
   * @param unitsPerPackage number of individual units in a package
   */
  protected Household(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Integer unitsPerPackage) {
    super(manufacturer, productName, price, minimumAge);
    this.unitsPerPackage = unitsPerPackage;
  }

  /**
   * Getter of unitsPerPackage property
   * @return this.unitsPerPackage
   */
  public Integer getUnitsPerPackage() {
    return this.unitsPerPackage;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    Household household = (Household) obj;
    return Objects.equals(this.getUnitsPerPackage(), household.getUnitsPerPackage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getUnitsPerPackage());
  }

  @Override
  public String toString() {
    return "Household{" +
        "manufacturer=" + getManufacturer() +
        ", productName='" + getProductName() + '\'' +
        ", price=" + getPrice() +
        ", minimumAge=" + getMinimumAge() +
        ", unitsPerPackage=" + this.getUnitsPerPackage() +
        '}';
  }
}
