import java.util.Objects;

/**
 * Represents an Author with their details--name, email and physical address
 * no package declaration
 * @author Ambika
 */
public class Author {

  private Name name;
  private String email;
  private String address;

  private static final Integer MAX_NAME_LENGTH = 15;

  /**
   * Author class constructor
   * @param name - name object consists of firstname and lastname
   * @param email - String
   * @param address - String
   * @throws NameLengthException - if length exceeds from 15 characters
   */
  public Author(Name name, String email, String address) throws NameLengthException {

      this.name = name;
      this.email = email;
      this.address = address;
      validate();
  }

  /**
   * function used to validate name if it exceeds 15 characters then throw NameLengthException
   * @throws NameLengthException - if length exceeds from 15 characters
   */
  private void validate() throws NameLengthException {
    StringBuilder givenName = new StringBuilder();
    givenName.append(this.name.getFirstName()).append(this.name.getLastName());

    if(givenName.length() > MAX_NAME_LENGTH){
      throw new NameLengthException("Name is bigger than 15 characters");
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Author author = (Author) obj;
    return Objects.equals(getName(), author.getName()) && Objects.equals(getEmail(),
        author.getEmail()) && Objects.equals(getAddress(), author.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getEmail(), getAddress());
  }

  /**
   * @return the name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * @param name - author name
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * @param email - author email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @param address - author address
   */
  public void setAddress(String address) {
    this.address = address;
  }
}