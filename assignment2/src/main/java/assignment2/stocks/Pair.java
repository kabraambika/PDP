package assignment2.stocks;

import java.util.Objects;

/**
 * Generic pair class. this class is made generic to represent the quantities of each Product as a
 * StockItem, which contains the following information: A product, first object Quantity of this
 * product that the supermarket has in stock, second object
 *
 * @param <X> The First object in pair
 * @param <Y> The Second object in pair
 */
public class Pair<X, Y> {

  /**
   * The first object in pair.
   */
  protected X first;
  /**
   * The second object in the pair.
   */
  protected Y second;

  /**
   * Constructor of pair
   *
   * @param first  first object in pair
   * @param second second object in pair
   */
  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Getter of the first object in pair.
   *
   * @return this.first
   */
  public X getFirst() {
    return this.first;
  }

  /**
   * Getter of the second object in pair.
   *
   * @return this.second
   */
  public Y getSecond() {
    return this.second;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Pair<?, ?> pair = (Pair<?, ?>) obj;
    return Objects.equals(this.getFirst(), pair.getFirst()) && Objects.equals(
        this.getSecond(), pair.getSecond());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getFirst(), this.getSecond());
  }

  @Override
  public String toString() {
    return "Pair{" +
        "first=" + getFirst() +
        ", second=" + getSecond() +
        '}';
  }
}
