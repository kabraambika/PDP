package assignment2.problem1.stock;

import assignment2.problem1.products.Household;
import java.util.Objects;

/**
 * HouseholdStockItem is a type of StockItem which extends StockItem class. It contains following information :
 * A household product, represented as a Household object
 * Quantity, represented as Double
 * @author kabraambika19
 */
public class HouseholdStockItem extends StockItem {
  private Household householdProduct;

  /**
   * Constructor of HouseholdStockItem class
   * @param householdProduct stock product, represented as a Household object
   * @param quantity represented as Double, The quantity of this product that the supermarket has in stock.
   */
  public HouseholdStockItem(Household householdProduct, Double quantity) {
    super(quantity);
    this.householdProduct = householdProduct;
  }

  /**
   * Getter of householdProduct property
   * @return this.householdProduct
   */
  public Household getHouseholdProduct() {
    return this.householdProduct;
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
    HouseholdStockItem that = (HouseholdStockItem) obj;
    return Objects.equals(this.getHouseholdProduct(), that.getHouseholdProduct());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getHouseholdProduct());
  }

  @Override
  public String toString() {
    return "HouseholdStockItem{" +
        "householdProduct=" + this.getHouseholdProduct() +
        ", quantity=" + getQuantity() +
        '}';
  }
}
