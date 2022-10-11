package assignment2.products;

/**
 * The user of this interface with get basic information like Manufacturer, price, product name and
 * minimum age of any product. This interface is used to represent two type of products in
 * supermarket system for now, grocery and household products.
 *
 * @author kabraambika19
 */
public interface IProduct {

  /**
   * get name of product type
   * @return Name of product type
   */
  String getProductType();
  /**
   * get the Manufacturer information of product
   *
   * @return Manufacturer object, represented as Manufacturer
   */
  Manufacturer getManufacturer();

  /**
   * get price of product
   *
   * @return price, represented as price
   */
  Double getPrice();

  /**
   * Get product name
   *
   * @return product name, represented as String
   */
  String getProductName();

  /**
   * get the minimum age required to purchase a product
   *
   * @return minimum age, represented as Integer
   */
  Integer getMinimumAge();
}
