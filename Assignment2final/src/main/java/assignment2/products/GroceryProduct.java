package assignment2.products;

import assignment2.enums.ProductCategory;
import assignment2.enums.ProductType;
import java.util.Objects;

public class GroceryProduct extends AbstractProduct{
  private ProductCategory productCategory;
  private ProductType productType;
  private Double weight;

  public GroceryProduct(String manufacturer, String productName, Double price, int age, ProductType productType, Double weight) {
    super(manufacturer, productName, price, age);
    this.productType = productType;
    this.weight = weight;
    this.productCategory = ProductCategory.GROCERY;
  }
  public ProductCategory getProductCategory() {
    return this.productCategory;
  }

  @Override
  public ProductType getProductType() {
    return this.productType;
  }

  public Double getWeight() {
    return this.weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    GroceryProduct that = (GroceryProduct) o;
    return getProductCategory() == that.getProductCategory()
        && getProductType() == that.getProductType() && Objects.equals(getWeight(), that.getWeight());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getProductCategory(), getProductType(), getWeight());
  }

  @Override
  public String toString() {
    return "GroceryProduct{" +
        "productCategory=" + getProductCategory() +
        ", productType=" + getProductType() +
        ", weight=" + getWeight() +
        ", manufacturer='" + getManufacturer() + '\'' +
        ", productName='" + getProductName() + '\'' +
        ", price=" + getPrice() +
        ", age=" + getAge() +
        '}';
  }

}
