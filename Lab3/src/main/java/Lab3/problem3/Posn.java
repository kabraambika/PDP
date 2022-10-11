package Lab3.problem3;

import java.util.Objects;

/**
 * Posn represents a Cartesian coordinate.
 */
public class Posn {
  private Integer x;
  private Integer y;

  /**
   * @param x x property of coordinate
   * @param y y property of coordinate
   */
  public Posn(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter of x property
   * @return this.x
   */
  public Integer getX() {
    return this.x;
  }

  /**
   * Getter of y property
   * @return this.y
   */
  public Integer getY() {
    return this.y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Posn posn = (Posn) obj;
    return Objects.equals(this.getX(), posn.getX()) && Objects.equals(this.getY(),
        posn.getY());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getX(), this.getY());
  }

  @Override
  public String toString() {
    return "Posn{" +
        "x=" + this.getX() +
        ", y=" + this.getY() +
        '}';
  }
}
