package Lab3.problem2;

import java.util.Objects;

/**
 * Restaurant class contains the information like restaurant name, Address, menu, is open/closed
 */
public class Restaurant {
  private String restaurantName;
  private Address address;
  private Menu menu;
  private Boolean isOpen;

  /**
   * @param restaurantName A String restaurant name
   * @param address Class Address
   * @param menu Class Menu
   * @param isOpen A Boolean open/closed
   */
  public Restaurant(String restaurantName, Address address, Menu menu, Boolean isOpen) {
    this.restaurantName = restaurantName;
    this.address = address;
    this.menu = menu;
    this.isOpen = isOpen;
  }

  /**
   * @return this.restaurantName
   */
  public String getRestaurantName() {
    return this.restaurantName;
  }

  /**
   * @return this.address, Address class object
   */
  public Address getAddress() {
    return this.address;
  }

  /**
   * @return this.menu, Menu class object
   */
  public Menu getMenu() {
    return this.menu;
  }

  /**
   * @return this.isOpen, Boolean if true then Restaurant is open, else Restaurant is closed
   */
  public Boolean getOpen() {
    return this.isOpen;
  }

  /**
   * @param restaurantName String, restaurant name
   */
  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  /**
   * @param address Address object
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * @param menu Menu object
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * @param open Boolean for restaurant open or not
   */
  public void setOpen(Boolean open) {
    isOpen = open;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Restaurant that = (Restaurant) obj;
    return Objects.equals(this.getRestaurantName(), that.getRestaurantName())
        && Objects.equals(this.getAddress(), that.getAddress()) && Objects.equals(
        this.getMenu(), that.getMenu()) && Objects.equals(this.getOpen(), that.getOpen());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getRestaurantName(), this.getAddress(), this.getMenu(), this.getOpen());
  }

  @Override
  public String toString() {
    return "Restaurant{" +
        "restaurantName='" + this.getRestaurantName() + '\'' +
        ", address=" + this.getAddress() +
        ", menu=" + this.getMenu() +
        ", isOpen=" + this.getOpen() +
        '}';
  }
}
