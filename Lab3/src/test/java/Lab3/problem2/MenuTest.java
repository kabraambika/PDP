package Lab3.problem2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTest {
  private Menu testMenu;
  private List<String> testMeals;
  private List<String> expMeals;
  private List<String> testDeserts;
  private List<String> testBeverages;
  private List<String> testDrinks;
  private List<String> expDeserts;
  private List<String> expBeverages;
  private List<String> expDrinks;

  @BeforeEach
  void setUp() {
    testMeals = Arrays.asList("Burger", "Noodles", "Pizza");
    expMeals = Arrays.asList("Burger", "Noodles", "Pizza");
    testDeserts = Arrays.asList("Ice-cream", "Sweets");
    expDeserts = Arrays.asList("Ice-cream", "Sweets");
    testBeverages = Arrays.asList("Pepsi","Dew", "rum", "whisky", "brandy");
    expBeverages = Arrays.asList("Pepsi","Dew", "rum", "whisky", "brandy");
    testDrinks = Arrays.asList("Lemonade", "Cocktails");
    expDrinks = Arrays.asList("Lemonade", "Cocktails");
    testMenu = new Menu(testMeals, testDeserts, testBeverages, testDrinks);
  }

  @Test
  void getMeals() {
    assertEquals(expMeals, testMenu.getMeals());
  }

  @Test
  void getDeserts() {
    assertEquals(expDeserts, testMenu.getDeserts());
  }

  @Test
  void getBeverages() {
    assertEquals(expBeverages, testMenu.getBeverages());
  }

  @Test
  void getDrinks() {
    assertEquals(expDrinks, testMenu.getDrinks());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testMenu.equals(testMenu));
  }

  @Test
  void testEquals_null() {
    assertFalse(testMenu.equals(null));
  }

  @Test
  void testEquals_Type() {
    assertFalse(testMenu.equals(new String("test")));
  }

  @Test
  void testEquals_SimilarObject() {
    assertTrue(testMenu.equals(new Menu(testMeals, testDeserts, testBeverages, testDrinks)));
  }

  @Test
  void testEquals_DifferentMeals() {
    assertFalse(testMenu.equals(new Menu(null, testDeserts, testBeverages, testDrinks)));
  }

  @Test
  void testEquals_DifferentDeserts() {
    assertFalse(testMenu.equals(new Menu(testMeals, null, testBeverages, testDrinks)));
  }

  @Test
  void testEquals_DifferentBeverages() {
    assertFalse(testMenu.equals(new Menu(testMeals, testDeserts, null, testDrinks)));
  }

  @Test
  void testEquals_DifferentDrinks() {
    assertFalse(testMenu.equals(new Menu(testMeals, testDeserts, testBeverages, null)));
  }

  @Test
  void testHashCode() {
    int expHashcode = Objects.hash(expMeals, expDeserts, expBeverages, expDrinks);
    assertEquals(expHashcode, testMenu.hashCode());
  }

  @Test
  void testToString() {
    String expString = "Menu{" +
        "meals=" + expMeals +
        ", deserts=" + expDeserts +
        ", beverages=" + expBeverages +
        ", drinks=" + expDrinks +
        '}';
    assertEquals(expString, testMenu.toString());
  }

  @Test
  void setMeals() {
    testMenu.setMeals(null);
    assertEquals(null, testMenu.getMeals());
  }

  @Test
  void setDeserts() {
    testMenu.setDeserts(null);
    assertEquals(null, testMenu.getDeserts());
  }

  @Test
  void setBeverages() {
    testMenu.setBeverages(null);
    assertEquals(null, testMenu.getBeverages());
  }

  @Test
  void setDrinks() {
    testMenu.setDrinks(null);
    assertEquals(null, testMenu.getDrinks());
  }
}