package assignment2.products;

import java.util.Objects;

/**
 * AbstractHousehold is an abstract class for all household products. It extends AbstractProduct
 * class as well. It contains information like: manufacturer, productName, price, minimum age,
 * number of individual units in a package.
 *
 * @author Kabraambika19
 */
public abstract class AbstractHousehold extends AbstractProduct {

  /**
   * the number of individual units in a package
   */
  private Integer unitsPerPackage;

  /**
   * Constructor of AbstractHousehold class
   *
   * @param manufacturer    product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName     product name, represented as a String
   * @param price           product price, represented as a Double
   * @param minimumAge      minimum age required for the product like for product beer, minimum age
   *                        can be 21
   * @param unitsPerPackage number of individual units in a package
   */
  protected AbstractHousehold(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Integer unitsPerPackage) {
    super(manufacturer, productName, price, minimumAge);
    this.unitsPerPackage = unitsPerPackage;
  }

  /**
   * Getter of unitsPerPackage property
   *
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
    AbstractHousehold abstractHousehold = (AbstractHousehold) obj;
    return Objects.equals(this.getUnitsPerPackage(), abstractHousehold.getUnitsPerPackage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getUnitsPerPackage());
  }

  @Override
  public String toString() {
    return "AbstractHousehold{" +
        "manufacturer=" + this.getManufacturer() +
        ", productName='" + this.getProductName() + '\'' +
        ", price=" + this.getPrice() +
        ", minimumAge=" + this.getMinimumAge() +
        ", unitsPerPackage=" + this.getUnitsPerPackage() +
        '}';
  }
}
