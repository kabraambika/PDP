package assignment2.products;

/**
 * PaperTowel is a type of AbstractHousehold product. It contains information like: manufacturer,
 * productName, price, minimum age, number of individual units in a package.
 *
 * @author Kabraambika19
 */
public class PaperTowel extends AbstractHousehold {
  /**
   * Constant for product type Paper towel
   */
  private static final String PRODUCT_TYPE = "Paper towel";

  /**
   * Constructor of PaperTowel class
   *
   * @param manufacturer    product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName     product name, represented as a String
   * @param price           product price, represented as a Double
   * @param minimumAge      minimum age required for the product like for product beer, minimum age
   *                        can be 21
   * @param unitsPerPackage number of individual units in a package
   */
  public PaperTowel(Manufacturer manufacturer, String productName, Double price,
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
