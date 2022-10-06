package assignment2.problem1.products;

import assignment2.problem1.Manufacturer;

/**
 * PaperTowel is a type of Household product.
 * It contains information like: manufacturer, productName, price, minimum age, number of individual units in a package.
 * @author Kabraambika19
 */
public class PaperTowel extends Household {

  /**
   * Constructor of PaperTowel class
   * @param manufacturer product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName product name, represented as a String
   * @param price product price, represented as a Double
   * @param minimumAge minimum age required for the product like for product beer, minimum age can be 21
   * @param unitsPerPackage number of individual units in a package
   */
  public PaperTowel(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Integer unitsPerPackage) {
    super(manufacturer, productName, price, minimumAge, unitsPerPackage);
  }
}
