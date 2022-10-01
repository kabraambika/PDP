package assignment2.products;
import assignment2.enums.ProductCategory;
import assignment2.enums.ProductType;
import java.util.Objects;

public abstract class AbstractProduct {
  private String manufacturer;
  private String productName;
  private Double price;
  private int age;
  public AbstractProduct(String manufacturer, String productName, Double price, int age) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.age = age;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public String getProductName() {
    return this.productName;
  }

  public Double getPrice() {
    return this.price;
  }

  public int getAge() {
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
    AbstractProduct product = (AbstractProduct) o;
    return getAge() == product.getAge() && Objects.equals(getManufacturer(),
        product.getManufacturer()) && Objects.equals(getProductName(),
        product.getProductName()) && Objects.equals(getPrice(), product.getPrice());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getManufacturer(), getProductName(), getPrice(), getAge());
  }

  @Override
  public String toString() {
    return "AbstractProduct{" +
        "manufacturer='" + manufacturer + '\'' +
        ", productName='" + productName + '\'' +
        ", price=" + price +
        ", age=" + age +
        '}';
  }

  public abstract ProductCategory getProductCategory();
  public abstract ProductType getProductType();
}
