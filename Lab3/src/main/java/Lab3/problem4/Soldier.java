package Lab3.problem4;

import java.util.Objects;

/**
 * Soldier class extends Piece
 */
public abstract class Soldier extends Piece {

  private static final Double MIN_STAMINA = 0.0;
  private static final Double MAX_STAMINA = 100.0;
  /**
   * Additional information of a soldier's stamina
   */
  protected Double stamina;

  /**
   * @param name Name, containing information about a Piece first and last name
   * @param age  age is an Integer in the range [0, 128], containing information a Piece age
   * @param stamina Soldiers keep track of their stamina, represented as Double
   */
  public Soldier(Name name, Integer age, Double stamina) {
    super(name, age);
    if(validateStamina(stamina)) {
      this.stamina = stamina;
    }
    else {
      throw new IncorrectWealthValueException("Incorrect wealth value");
    }
  }

  /**
   * @param stamina Soldiers keep track of their stamina.
   * @return Boolean
   */
  private boolean validateStamina(Double stamina) {
    return stamina >= MIN_STAMINA && stamina <= MAX_STAMINA;
  }

  /**
   * @return this.stamina
   */
  public Double getStamina() {
    return this.stamina;
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
    Soldier soldier = (Soldier) o;
    return Objects.equals(getStamina(), soldier.getStamina());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getStamina());
  }

  @Override
  public String toString() {
    return "Soldier{" +
        "name=" + getName() +
        ", age=" + getAge() +
        ", stamina=" + this.stamina +
        '}';
  }

  /**
   * @param stamina represented as Double
   * @return updated stamina
   */
  public Double increaseStamina(Double stamina) {
    if(validateStamina(stamina)) {
      this.stamina += stamina;
    }
    return this.stamina;
  }

  /**
   * @param stamina Represented as double
   * @return decreased stamina
   */
  public Double decreaseStamina(Double stamina) {
    if(validateStamina(stamina) && validateStamina(this.stamina - stamina)) {
      this.stamina -= stamina;
    }
    return this.stamina;
  }
}
