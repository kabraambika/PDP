package assignment2.products;

import assignment2.enums.HouseholdProductType;
import assignment2.enums.ProductCategory;
import java.util.Objects;

public class HouseholdProduct extends AbstractProduct{
  private ProductCategory productCategory;
  private HouseholdProductType productType;
  private Integer unitsPerPackage;

  public HouseholdProduct(String manufacturer, String productName, Double price, int age, HouseholdProductType productType, Integer unitsPerPackage) {
    super(manufacturer, productName, price, age);
    this.productType = productType;
    this.unitsPerPackage = unitsPerPackage;
    this.productCategory = ProductCategory.HOUSEHOLD;
  }

  public ProductCategory getProductCategory() {
    return this.productCategory;
  }

  public HouseholdProductType getProductType() {
    return this.productType;
  }

  public Integer getUnitsPerPackage() {
    return this.unitsPerPackage;
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
    HouseholdProduct that = (HouseholdProduct) o;
    return getProductCategory() == that.getProductCategory()
        && getProductType() == that.getProductType() && Objects.equals(getUnitsPerPackage(),
        that.getUnitsPerPackage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getProductCategory(), getProductType(), getUnitsPerPackage());
  }

  @Override
  public String toString() {
    return "HouseholdProduct{" +
        "productCategory=" + getProductCategory() +
        ", productType=" + getProductType() +
        ", unitsPerPackage=" + getUnitsPerPackage() +
        ", manufacturer='" + getManufacturer() + '\'' +
        ", productName='" + getProductName() + '\'' +
        ", price=" + getPrice() +
        ", age=" + getAge() +
        '}';
  }

}
