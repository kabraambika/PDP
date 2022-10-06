package assignment2.problem1.products;

import assignment2.problem1.Manufacturer;
import java.util.Objects;

/**
 * AbstractProduct is an abstract class of Product.It contains information like manufacturer, productName, price, minimum age
 * @author Kabra Ambika, kabraambika19
 */
public abstract class AbstractProduct {
  protected Manufacturer manufacturer;
  protected String productName;
  protected Double price;
  protected Integer minimumAge;

  /**
   * Constructor of AbstractProduct class
   * @param manufacturer product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName product name, represented as a String
   * @param price product price, represented as a Double
   * @param minimumAge minimum age required for the product like for product beer, minimum age can be 21
   */
  protected AbstractProduct(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Getter of manufacturer property
   * @return this.manufacturer, represented as a Manufacturer object
   */
  public Manufacturer getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Getter of productName property
   * @return this.productName
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * Getter of price property
   * @return this.price
   */
  public Double getPrice() {
    return this.price;
  }

  /**
   * Getter of minimumAge property
   * @return this.minimumAge
   */
  public Integer getMinimumAge() {
    return this.minimumAge;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractProduct that = (AbstractProduct) obj;
    return Objects.equals(this.getManufacturer(), that.getManufacturer())
        && Objects.equals(this.getProductName(), that.getProductName())
        && Objects.equals(this.getPrice(), that.getPrice()) && Objects.equals(
        this.getMinimumAge(), that.getMinimumAge());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getManufacturer(), this.getProductName(), this.getPrice(), this.getMinimumAge());
  }

  @Override
  public String toString() {
    return "AbstractProduct{" +
        "manufacturer=" + this.getManufacturer() +
        ", productName='" + this.getProductName() + '\'' +
        ", price=" + this.getPrice() +
        ", minimumAge=" + this.getMinimumAge() +
        '}';
  }
}
