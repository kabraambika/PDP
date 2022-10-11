package assignment2.products;

import java.util.Objects;

/**
 * AbstractGrocery is an abstract class which also extends another Abstract class, AbstractProduct.
 * It contains information like manufacturer, productName, price, minimum age, product weight.
 *
 * @author kabraambika19
 */
public abstract class AbstractGrocery extends AbstractProduct {

  /**
   * the weight of the product in ounces and all
   */
  private Double productWeight;

  /**
   * Constructor of AbstractGrocery abstract class
   *
   * @param manufacturer  product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName   product name, represented as a String
   * @param price         product price, represented as a Double
   * @param minimumAge    minimum age required for the product like for product beer, minimum age
   *                      can be 21
   * @param productWeight product weight in ounces
   */
  protected AbstractGrocery(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Double productWeight) {
    super(manufacturer, productName, price, minimumAge);
    this.productWeight = productWeight;
  }

  /**
   * Getter of productWeight property
   *
   * @return this.productWeight
   */
  public Double getProductWeight() {
    return this.productWeight;
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
    AbstractGrocery abstractGrocery = (AbstractGrocery) obj;
    return Objects.equals(this.getProductWeight(), abstractGrocery.getProductWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getProductWeight());
  }

  @Override
  public String toString() {
    return "AbstractGrocery{" +
        "manufacturer=" + this.getManufacturer() +
        ", productName='" + this.getProductName() + '\'' +
        ", price=" + this.getPrice() +
        ", minimumAge=" + this.getMinimumAge() +
        ", productWeight=" + this.getProductWeight() +
        '}';
  }
}
