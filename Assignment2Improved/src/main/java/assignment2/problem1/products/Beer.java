package assignment2.problem1.products;

import assignment2.problem1.Manufacturer;

/**
 * Beer is a type of Grocery product
 * It contains information like manufacturer, productName, price, minimum age, product weight.
 * @author kabraambika19
 */
public class Beer extends Grocery {

  /**
   * Constructor of Beer class
   * @param manufacturer product manufacturer name, represented as a Manufacturer eg. "Beeches"
   * @param productName product name, represented as a String
   * @param price product price, represented as a Double
   * @param minimumAge minimum age required for the product like for product beer, minimum age can be 21
   * @param productWeight product weight in ounces
   */
  public Beer(Manufacturer manufacturer, String productName, Double price,
      Integer minimumAge, Double productWeight) {
    super(manufacturer, productName, price, minimumAge, productWeight);
  }
}
