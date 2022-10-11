package Lab3.problem4;

/**
 * Civilian extends Piece
 */
public abstract class Civilian extends Piece{

  private static final Double MIN_WEALTH = 0.0;
  /**
   * Represented as Double
   */
  protected Double wealth;
  /**
   * @param name Name, containing information about a Piece first and last name
   * @param age  Age, which is an Integer in the range [0, 128], containing information a Piece age
   * @param wealth Represented as Double
   */
  public Civilian(Name name, Integer age, Double wealth) {
    super(name, age);
    if(validateWealth(wealth)) {
      this.wealth = wealth;
    }
  }

  /**
   * @param wealth Represented as Double
   * @return wealth is more than or equal to zero
   */
  private Boolean validateWealth(Double wealth) {
    return wealth >= MIN_WEALTH;
  }

  /**
   * @return this.wealth
   */
  public Double getWealth() {
    return this.wealth;
  }

  /**
   * @param wealth Represented as Double
   * @return if valid wealth, then add wealth in existing wealth
   */
  public Double increaseWealth(Double wealth) {
    if(validateWealth(wealth)) {
      this.wealth += wealth;
    }
    return this.wealth;
  }

  /**
   * @param wealth Represented as Double
   * @return if valid wealth and after deduct still valid then remove wealth
   */
  public Double decreaseWealth(Double wealth) {
    if(validateWealth(wealth) && validateWealth(this.wealth - wealth)) {
      this.wealth -= wealth;
    }
    return this.wealth;
  }
}
