package Lab3.problem4;

/**
 * Farmer extends Civilian
 */
public class Farmer extends Civilian{

  /**
   * @param name   Name, containing information about a Piece first and last name
   * @param age    Age, which is an Integer in the range [0, 128], containing information a Piece
   *               age
   * @param wealth represented as Double
   */
  public Farmer(Name name, Integer age, Double wealth) {
    super(name, age, wealth);
  }
}
