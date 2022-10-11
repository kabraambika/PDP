package assignment2.fulfillmentsystem;

import assignment2.products.IProduct;
import java.util.Map;
import java.util.Objects;

/**
 * Receipt keeps track of following information The total price paid. The list of products the
 * customer received when the order was processed. A list of any products that were out of stock and
 * could not be substituted. A list of any products that were removed from the order because the
 * customer did not meet minimum age requirements.
 *
 * @author kabraambika19
 */
public class Receipt {

  /**
   * The total price paid, represented as Double
   */
  private Double totalPricePaid;
  /**
   * The list of products the customer received when the order was processed, Represented as Map
   * consists of products as key and quantity as value
   */
  private Map<IProduct, Double> productsReceived;
  /**
   * A list of any products that were out of stock and could not be substituted, Represented as Map
   * consists of products as key and quantity as value
   */
  private Map<IProduct, Double> outStockProducts;
  /**
   * A list of any products that were removed from the order because the customer did not meet
   * minimum age requirements. Represented as Map consists of products as key and quantity as value
   */
  private Map<IProduct, Double> removedProducts;

  /**
   * Constructor of Receipt
   *
   * @param totalPricePaid   The total price paid, represented as Double
   * @param productsReceived The list of products the customer received when the order was
   *                         processed, Represented as Map consists of products as key and quantity
   *                         as value
   * @param outStockProducts A list of any products that were out of stock and could not be
   *                         substituted, Represented as Map consists of products as key and
   *                         quantity as value
   * @param removedProducts  A list of any products that were removed from the order because the
   *                         customer did not meet minimum age requirements, Represented as Map
   *                         consists of products as key and quantity as value
   */
  public Receipt(Double totalPricePaid,
      Map<IProduct, Double> productsReceived, Map<IProduct, Double> outStockProducts,
      Map<IProduct, Double> removedProducts) {
    this.totalPricePaid = totalPricePaid;
    this.productsReceived = productsReceived;
    this.outStockProducts = outStockProducts;
    this.removedProducts = removedProducts;
  }

  /**
   * Getter of total price paid
   *
   * @return this.totalPricePaid
   */
  public Double getTotalPricePaid() {
    return this.totalPricePaid;
  }

  /**
   * Getter of Map of products received. Here map is consists of product as key, and quantity as
   * value
   *
   * @return this.productsReceived
   */
  public Map<IProduct, Double> getProductsReceived() {
    return this.productsReceived;
  }

  /**
   * Getter of Map of products out of stock. Here map is consists of product as key, and quantity as
   * value
   *
   * @return this.outStockProducts
   */
  public Map<IProduct, Double> getOutStockProducts() {
    return this.outStockProducts;
  }

  /**
   * Getter of Map of products removed due to age restricted. Here map is consists of product as
   * key, and quantity as value
   *
   * @return this.removedProducts
   */
  public Map<IProduct, Double> getRemovedProducts() {
    return this.removedProducts;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Receipt receipt = (Receipt) obj;
    return Objects.equals(
        this.getTotalPricePaid(), receipt.getTotalPricePaid()) && Objects.equals(
        this.getProductsReceived(), receipt.getProductsReceived()) && Objects.equals(
        this.getOutStockProducts(), receipt.getOutStockProducts()) && Objects.equals(
        this.getRemovedProducts(), receipt.getRemovedProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getTotalPricePaid(), this.getProductsReceived(),
        this.getOutStockProducts(), this.getRemovedProducts());
  }

  @Override
  public String toString() {
    return "Receipt{" +
        "totalPricePaid=" + this.getTotalPricePaid() +
        ", productsReceived=" + this.getProductsReceived() +
        ", outStockProducts=" + this.getOutStockProducts() +
        ", removedProducts=" + this.getRemovedProducts() +
        '}';
  }
}
