package assignment2.products;

import java.util.Objects;

/**
 * AbstractProduct is an abstract class of GenericInventory. It contains information like
 * manufacturer, productName, price, minimum age
 *
 * @author Kabra Ambika, kabraambika19
 */
public abstract class AbstractProduct implements IProduct {

  /**
   * CONSTANT MINIMUM_AGE = 0 for validating minimumAge provided for product
   */
  private static final Integer MINIMUM_AGE = 0;
  /**
   * product manufacturer name, represented as a Manufacturer like Beeches
   */
  private Manufacturer manufacturer;
  /**
   * product name, represented as a String
   */
  private String productName;
  /**
   * product price, represented as a Double
   */
  private Double price;
  /**
   * minimum age required for the product like for product beer, minimum age can be 21
   */
  private Integer minimumAge;

  /**
   * Constructor of AbstractProduct class
   *
   * @param manufacturer product manufacturer name, represented as a Manufacturer like Beeches
   * @param productName  product name, represented as a String
   * @param price        product price, represented as a Double
   * @param minimumAge   minimum age required for the product like for product beer, minimum age can
   *                     be 21
   * @throws InvalidMinimumAgeException - This custom class exception is thrown when minimum age to
   *                                    purchase a product is given less than zero while creating
   *                                    any product in system
   */
  protected AbstractProduct(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge) throws InvalidMinimumAgeException {
    if (this.validateMinimumAge(minimumAge)) {
      this.manufacturer = manufacturer;
      this.productName = productName;
      this.price = price;
      this.minimumAge = minimumAge;
    } else {
      throw new InvalidMinimumAgeException(
          "Minimum age for product should be greater than or equal to 0");
    }
  }

  /**
   * @param minimumAge minimum age required for the product like for product beer, minimum age can
   *                   be 21
   * @return boolean, true if minimum age provided for product is greater than or equal to zero,
   * else false
   */
  private boolean validateMinimumAge(Integer minimumAge) {
    return minimumAge >= MINIMUM_AGE;
  }

  /**
   * Getter of manufacturer property
   *
   * @return this.manufacturer, represented as a Manufacturer object
   */
  @Override
  public Manufacturer getManufacturer() {
    return this.manufacturer;
  }

  /**
   * Getter of productName property
   *
   * @return this.productName
   */
  @Override
  public String getProductName() {
    return this.productName;
  }

  /**
   * Getter of price property
   *
   * @return this.price
   */
  @Override
  public Double getPrice() {
    return this.price;
  }

  /**
   * Getter of minimumAge property
   *
   * @return this.minimumAge
   */
  @Override
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
    return Objects.hash(this.getManufacturer(), this.getProductName(), this.getPrice(),
        this.getMinimumAge());
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
