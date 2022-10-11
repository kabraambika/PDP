package assignment2.products;

/**
 * Salmon is a type of AbstractGrocery product It contains information like manufacturer,
 * productName, price, minimum age, product weight.
 *
 * @author kabraambika19
 */
public class Salmon extends AbstractGrocery {

  /**
   * Constant for product type salmon
   */
  private static final String PRODUCT_TYPE = "Salmon";

  /**
   * Constructor of Beer class
   *
   * @param manufacturer  product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName   product name, represented as a String
   * @param price         product price, represented as a Double
   * @param minimumAge    minimum age required for the product like for product beer, minimum age
   *                      can be 21
   * @param productWeight product weight in ounces
   */
  public Salmon(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Double productWeight) {
    super(manufacturer, productName, price, minimumAge, productWeight);
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
