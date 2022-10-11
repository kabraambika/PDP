package assignment2.products;

/**
 * Shampoo is a type of household product. It contains information like: manufacturer, productName,
 * price, minimum age, number of individual units in a package.
 *
 * @author Kabraambika19
 */
public class Shampoo extends AbstractHousehold {

  /**
   * Constant for product type Shampoo
   */
  private static final String PRODUCT_TYPE = "Shampoo";

  /**
   * Constructor of Shampoo class
   *
   * @param manufacturer    product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName     product name, represented as a String
   * @param price           product price, represented as a Double
   * @param minimumAge      minimum age required for the product like for product beer, minimum age
   *                        can be 21
   * @param unitsPerPackage number of individual units in a package
   */
  public Shampoo(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Integer unitsPerPackage) {
    super(manufacturer, productName, price, minimumAge, unitsPerPackage);
  }

  /**
   * get name of product type
   *
   * @return Name of product type
   */
  @Override
  public String getProductType() {
    return PRODUCT_TYPE;
  }
}
