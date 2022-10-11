package Lab3.problem2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestaurantTest {
  private Restaurant testRestaurant;
  private Address testAddress;
  private Menu testMenu;
  private List<String> testMeals;
  private List<String> testDeserts;
  private List<String> testBeverages;
  private List<String> testDrinks;
  @BeforeEach
  void setUp() {
    testAddress = new Address("500", "Seattle", "98121", "WA", "USA");
    testMeals = Arrays.asList("Burger", "Noodles", "Pizza");
    testDeserts = Arrays.asList("Ice-cream", "Sweets");
    testBeverages = Arrays.asList("Pepsi","Dew", "rum", "whisky", "brandy");
    testDrinks = Arrays.asList("Lemonade", "Cocktails");
    testMenu = new Menu(testMeals, testDeserts, testBeverages, testDrinks);
    testRestaurant = new Restaurant("The five point cafe", testAddress, testMenu, Boolean.TRUE);
  }

  @Test
  void getRestaurantName() {
    assertEquals("The five point cafe", testRestaurant.getRestaurantName());
  }

  @Test
  void getAddress() {
    Address expAddress = new Address("500", "Seattle", "98121", "WA", "USA");
    assertEquals(expAddress, testRestaurant.getAddress());
  }

  @Test
  void getMenu() {
    Menu expMenu = new Menu(testMeals, testDeserts, testBeverages, testDrinks);
    assertEquals(expMenu, testRestaurant.getMenu());
  }

  @Test
  void getOpen() {
    assertEquals(Boolean.TRUE, testRestaurant.getOpen());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRestaurant.equals(testRestaurant));
  }

  @Test
  void testEquals_null() {
    assertFalse(testRestaurant.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testRestaurant.equals(new String("A")));
  }

  @Test
  void testEquals_SimilarObject() {
    Restaurant testRestaurant1 = new Restaurant("The five point cafe", testAddress, testMenu, Boolean.TRUE);
    assertTrue(testRestaurant1.equals(testRestaurant));
  }

  @Test
  void testEquals_DiffName() {
    Restaurant testRestaurant1 = new Restaurant(null, testAddress, testMenu, Boolean.TRUE);
    assertFalse(testRestaurant1.equals(testRestaurant));
  }

  @Test
  void testEquals_DiffAddress() {
    Restaurant testRestaurant1 = new Restaurant("The five point cafe", null, testMenu, Boolean.TRUE);
    assertFalse(testRestaurant1.equals(testRestaurant));
  }

  @Test
  void testEquals_DiffMenu() {
    Restaurant testRestaurant1 = new Restaurant("The five point cafe", testAddress, null, Boolean.TRUE);
    assertFalse(testRestaurant1.equals(testRestaurant));
  }

  @Test
  void testEquals_DiffOpen() {
    Restaurant testRestaurant1 = new Restaurant("The five point cafe", testAddress, testMenu, Boolean.FALSE);
    assertFalse(testRestaurant1.equals(testRestaurant));
  }

  @Test
  void testHashCode() {
    Address expAddress = new Address("500", "Seattle", "98121", "WA", "USA");
    Menu expMenu = new Menu(testMeals, testDeserts, testBeverages, testDrinks);
    int expHashcode = Objects.hash("The five point cafe", expAddress, expMenu, Boolean.TRUE);
    assertEquals(expHashcode, testRestaurant.hashCode());
  }

  @Test
  void testToString() {
    Address expAddress = new Address("500", "Seattle", "98121", "WA", "USA");
    Menu expMenu = new Menu(testMeals, testDeserts, testBeverages, testDrinks);
    String expString = "Restaurant{" +
        "restaurantName='" + "The five point cafe" + '\'' +
        ", address=" + expAddress +
        ", menu=" + expMenu +
        ", isOpen=" + Boolean.TRUE +
        '}';
    assertEquals(expString, testRestaurant.toString());
  }

  @Test
  void setRestaurantName() {
    testRestaurant.setRestaurantName(null);
    assertEquals(null, testRestaurant.getRestaurantName());
  }

  @Test
  void setAddress() {
    testRestaurant.setAddress(null);
    assertEquals(null, testRestaurant.getAddress());
  }

  @Test
  void setMenu() {
    testRestaurant.setMenu(null);
    assertEquals(null, testRestaurant.getMenu());
  }

  @Test
  void setOpen() {
    testRestaurant.setOpen(Boolean.FALSE);
    assertEquals(Boolean.FALSE, testRestaurant.getOpen());
  }
}