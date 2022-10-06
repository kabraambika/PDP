package assignment2.problem1.stock;
import assignment2.problem1.products.Grocery;
import java.util.Objects;

/**
 * GroceryStockItem is a type of StockItem which extends StockItem class. It contains following information :
 * A grocery product, represented as a Grocery object
 * Quantity, represented as Double
 * @author kabraambika19
 */
public class GroceryStockItem extends StockItem {
  private Grocery groceryProduct;

  /**
   * Constructor of GroceryStockItem
   * @param groceryProduct product, represented as a Grocery object.
   * @param quantity represented as Double, The quantity of this product that the supermarket has in stock.
   */
  public GroceryStockItem(Grocery groceryProduct, Double quantity) {
    super(quantity);
    this.groceryProduct = groceryProduct;
  }

  /**
   * Getter of groceryProduct property
   * @return this.groceryProduct, represented as a Grocery object
   */
  public Grocery getGroceryProduct() {
    return this.groceryProduct;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    GroceryStockItem that = (GroceryStockItem) o;
    return Objects.equals(this.getGroceryProduct(), that.getGroceryProduct());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getGroceryProduct());
  }

  @Override
  public String toString() {
    return "GroceryStockItem{" +
        "groceryProduct=" + this.getGroceryProduct() +
        ", quantity=" + this.getQuantity() +
        '}';
  }
}
