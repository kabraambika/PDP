package Lab3.problem4;

import java.util.Objects;

/**
 * Pieces contain information
 * Name, containing information about a Piece first and last name
 * Age, which is an Integer in the range [0, 128], containing information a Piece age
 */
public abstract class Piece {

  private static final Integer MIN_AGE = 0;
  private static final Integer MAX_AGE = 128;
  private Name name;
  private Integer age;

  /**
   * @param name Name, containing information about a Piece first and last name
   * @param age Age, which is an Integer in the range [0, 128], containing information a Piece age
   */
  public Piece(Name name, Integer age) {
    if(validateAge(age)) {
      this.name = name;
      this.age = age;
    }
    else {
      throw new IncorrectAgeRangeException("Incorrect age range");
    }
  }

  private Boolean validateAge(Integer age) {
    return age >= MIN_AGE && age <= MAX_AGE;
  }

  /**
   * @return this.name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @return this.age
   */
  public Integer getAge() {
    return this.age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Piece piece = (Piece) o;
    return Objects.equals(this.getName(), piece.getName()) && Objects.equals(this.getAge(),
        piece.getAge());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName(), this.getAge());
  }

  @Override
  public String toString() {
    return "Piece{" +
        "name=" + this.getName() +
        ", age=" + this.getAge() +
        '}';
  }
}
