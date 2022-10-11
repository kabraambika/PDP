package Lab3.problem2;

import java.util.List;
import java.util.Objects;

/**
 * Menu contains information like list of meals, list of deserts, list of beverages, list of drinks
 */
public class Menu {
  private List<String> meals;
  private List<String> deserts;
  private List<String> beverages;
  private List<String> drinks;

  /**
   * @param meals A List of meals
   * @param deserts A List of desserts
   * @param beverages A List of beverages
   * @param drinks A List of drinks
   */
  public Menu(List<String> meals, List<String> deserts, List<String> beverages,
      List<String> drinks) {
    this.meals = meals;
    this.deserts = deserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   * @return list of meals, this.meals
   */
  public List<String> getMeals() {
    return this.meals;
  }

  /**
   * @return list of deserts, this.deserts
   */
  public List<String> getDeserts() {
    return this.deserts;
  }

  /**
   * @return list of beverages, this.beverages
   */
  public List<String> getBeverages() {
    return this.beverages;
  }

  /**
   * @return list of drinks, this.drinks
   */
  public List<String> getDrinks() {
    return this.drinks;
  }

  /**
   * @param meals list of meals, string type list
   */
  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  /**
   * @param deserts list of deserts, string type list
   */
  public void setDeserts(List<String> deserts) {
    this.deserts = deserts;
  }

  /**
   * @param beverages list of beverages, string type list
   */
  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  /**
   * @param drinks list of drinks, string type list
   */
  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(this.getMeals(), menu.getMeals()) && Objects.equals(
        this.getDeserts(), menu.getDeserts()) && Objects.equals(this.getBeverages(),
        menu.getBeverages()) && Objects.equals(this.getDrinks(), menu.getDrinks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getMeals(), this.getDeserts(), this.getBeverages(), this.getDrinks());
  }

  @Override
  public String toString() {
    return "Menu{" +
        "meals=" + this.getMeals() +
        ", deserts=" + this.getDeserts() +
        ", beverages=" + this.getBeverages() +
        ", drinks=" + this.getDrinks() +
        '}';
  }
}
