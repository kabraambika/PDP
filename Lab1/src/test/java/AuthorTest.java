

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Author Test case
 */
class AuthorTest {

  private Author jane;
  private Name expectedName =  new Name("Jane", "Olivia");
  private String expectedEmail = "j@a.com";
  private String expectedAddress = "222 Main St, Seattle, Wa, 98980";
  private Name jennika = new Name("Jennika", "Brown");
  private String newEmail = "j.brown@gmail.com";
  private String newAddress = "225 Terry Ave, Seattle, Wa, 98980";

  @BeforeEach
  void setUp() throws NameLengthException {
    this.jane = new Author(new Name("Jane","Olivia"),
        "j@a.com",
        "222 Main St, Seattle, Wa, 98980");

  }

  @Test
  public void testThrowNameLengthException(){
    NameLengthException thrown = Assertions.assertThrows(NameLengthException.class, () -> {
      StringBuilder givenName = new StringBuilder();
      givenName.append(this.jane.getName().getFirstName()).append(this.jane.getName().getLastName());

      if(givenName.length() > 5)
        throw new NameLengthException("Name is bigger than 5 characters");
    });
    Assertions.assertEquals("Name is bigger than 5 characters", thrown.getMessage());
  }

  @Test
  void getName() {
    Assertions.assertEquals(this.expectedName, this.jane.getName());
  }

  @Test
  void getEmail() {
    Assertions.assertEquals(this.expectedEmail, this.jane.getEmail());
  }

  @Test
  void getAddress() {
    Assertions.assertEquals(this.expectedAddress, this.jane.getAddress());
  }

  @Test
  void testEquals() throws NameLengthException {
    Author similarJane = new Author(new Name("Jane","Olivia"), "j@a.com", "222 Main St, Seattle, Wa, 98980");
    assertEquals(similarJane, this.jane);
  }

  @Test
  void testHashCode() throws NameLengthException {
    Author author1 = new Author(new Name("Jane","Olivia"), "j@a.com", "222 Main St, Seattle, Wa, 98980");
    Author author2 = new Author(new Name("Jane","Olivia"), "j@a.com", "222 Main St, Seattle, Wa, 98980");
    assertTrue(author1.equals(author2) && author2.equals(author1));
    assertTrue(author1.hashCode() == author2.hashCode());
  }

  @Test
  void setName() {
    this.jane.setName(this.jennika);
    assertEquals(this.jennika, this.jane.getName());
  }

  @Test
  void setEmail() {
    this.jane.setEmail(this.newEmail);
    assertEquals(this.newEmail, this.jane.getEmail());
  }

  @Test
  void setAddress() {
    this.jane.setAddress(this.newAddress);
    assertEquals(this.newAddress, this.jane.getAddress());
  }
}