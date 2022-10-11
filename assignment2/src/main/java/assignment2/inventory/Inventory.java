package assignment2.inventory;

import assignment2.products.AbstractGrocery;
import assignment2.products.AbstractHousehold;
import assignment2.products.IProduct;
import assignment2.stocks.StockItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Inventory is a core feature of supermarket system. Inventory contains list of grocery stock items
 * and list of household stock items. This is a singleton class for supermarket system. Inventory
 * instance can be created only once and used by different users of system. It keeps track of stocks
 * for grocery and household stock items. You can get list of grocery stock items and list of
 * household stock items. you can add new product in inventorySystem and appropriate list will get
 * updated.
 *
 * @author kabraambika19
 */
public class Inventory {

  /**
   * Constant for min amount for calculation
   */
  private static final Double MIN_AMOUNT = 0.0;
  /**
   * Constant for single quantity
   */
  private static final Double SINGLE_QUANTITY = 1.0;
  /**
   * Static instance of Inventory
   */
  private static Inventory inventorySystem;
  /**
   * <p>List of grocery stock items, represented as List of StockItem<AbstractGrocery></p>
   */
  private final List<StockItem<AbstractGrocery>> groceryStockItems;
  /**
   * <p>List of AbstractHousehold stock items, represented as List of
   * StockItem<AbstractHousehold></p>
   */
  private final List<StockItem<AbstractHousehold>> houseStockItems;

  /**
   * private constructor of Inventory class, initialises lists of grocery and household stock items
   */
  private Inventory() {
    this.groceryStockItems = new ArrayList<>();
    this.houseStockItems = new ArrayList<>();
  }

  /**
   * this static method returns the instance of class. if not initialised then creates new instance
   * and save in static parameter of class, then returns instance
   *
   * @return Instance of Inventory, represented as Inventory
   */
  public static Inventory getInstance() {
    if (inventorySystem == null) {
      inventorySystem = new Inventory();
    }
    return inventorySystem;
  }

  /**
   * Getter of groceryStockItems property
   *
   * @return this.groceryStockItems, represented as List of StockItem type AbstractGrocery
   */
  public List<StockItem<AbstractGrocery>> getGroceryStockItems() {
    return this.groceryStockItems;
  }

  /**
   * Getter of houseStockItems property
   *
   * @return this.houseStockItems, represented as List of StockItem type AbstractHousehold
   */
  public List<StockItem<AbstractHousehold>> getHouseStockItems() {
    return this.houseStockItems;
  }

  /**
   * this helper method adds product in grocery stock item list
   *
   * @param product  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity product quantity needed to be added in stock, represented as Double
   */
  private void addProductInInventory(AbstractGrocery product, Double quantity) {
    StockItem<AbstractGrocery> groceryStockItem = new StockItem<>(product, quantity);
    this.getGroceryStockItems().add(groceryStockItem);
  }

  /**
   * this helper method adds product in household stock item list
   *
   * @param product  AbstractHousehold product, represented as AbstractHousehold
   * @param quantity product quantity needed to be added in stock, represented as Double
   */
  private void addProductInInventory(AbstractHousehold product, Double quantity) {
    StockItem<AbstractHousehold> houseStockItem = new StockItem<>(product, quantity);
    this.getHouseStockItems().add(houseStockItem);
  }

  /**
   * This method is used to add a new product in grocery stock with single quantity
   *
   * @param product AbstractGrocery product, represented as AbstractGrocery
   */
  public void addNewProduct(AbstractGrocery product) {
    this.addNewProduct(product, SINGLE_QUANTITY);
  }

  /**
   * This method is used to add a new product in household stock with single quantity
   *
   * @param product AbstractHousehold product, represented as AbstractHousehold
   */
  public void addNewProduct(AbstractHousehold product) {
    this.addNewProduct(product, SINGLE_QUANTITY);
  }

  /**
   * This method adds new product in grocery stock with given quantity asa input. if any grocery
   * product is already in inventorySystem then quantity of grocery stock will be increased else new
   * grocery product will be added in inventorySystem list
   *
   * @param product  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity product quantity needed to be added in stock, represented as Double
   */
  public void addNewProduct(AbstractGrocery product, Double quantity) {
    if (this.isGroceryPresent(product)) {
      this.updateGroceryStock(product, quantity);
    } else {
      this.addProductInInventory(product, quantity);
    }
  }

  /**
   * This method adds new product in household stock with given quantity as input. if any household
   * product is already in inventorySystem then quantity of household stock will be increased else
   * new household product will be added in inventorySystem list
   *
   * @param product  AbstractHousehold product, represented as AbstractHousehold
   * @param quantity product quantity needed to be added in stock, represented as Double
   */
  public void addNewProduct(AbstractHousehold product, Double quantity) {
    if (this.isHouseholdProductPresent(product)) {
      this.updateHouseholdStock(product, quantity);
    } else {
      this.addProductInInventory(product, quantity);
    }
  }

  /**
   * Total amount of retail cost of all the stock present in inventorySystem
   *
   * @return represented as Double
   */
  public Double totalRetailCostInStock() {
    return this.getGroceryTotalRetailValue() + this.getHouseholdTotalRetailValue();
  }

  /**
   * This method provides validation for grocery product and its quantity before allowing the
   * product to be purchased or added in cart.
   *
   * @param grocery  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity product quantity needed to be added in stock, represented as Double
   * @return represented as boolean, This method verifies whether product is present in grocery
   * stock and quantity needed in event of purchase should be less than or equal to quantity in
   * stock.
   */
  public boolean validateProductQty(AbstractGrocery grocery, Double quantity) {
    return this.isGroceryPresent(grocery) && this.isQuantityAvailable(grocery, quantity);
  }

  /**
   * This method provides validation for household product and its quantity before allowing the
   * product to be purchased or added in cart.
   *
   * @param household household product, represented as AbstractHousehold
   * @param quantity  product quantity needed to be added in stock, represented as Double
   * @return represented as boolean, This method verifies whether product is present in household
   * stock and quantity needed in event of purchase should be less than or equal to quantity in
   * stock.
   */
  public boolean validateProductQty(AbstractHousehold household, Double quantity) {
    return this.isHouseholdProductPresent(household) && this.isQuantityAvailable(household, quantity);
  }

  /**
   * This method is used for finding similar grocery product for substituting product that is out of
   * stock. Product is substituted only when the similar product has similar type like Cheese
   * product can be replaced by cheese type, and similar product has available quantity in stock
   * which is similar to quantity needed to substitute the product, and similar product price should
   * be less than or equal to the substituted product, and similar product weight should be greater
   * than or equal to substituted product.
   *
   * @param substituteProduct AbstractGrocery product that needed to be substituted by staff,
   *                          represented as AbstractGrocery
   * @param qty               quantity of substitute product added in cart
   * @return represented in AbstractGrocery, if any similarProduct is found, similar grocery product
   * is returned else null will be returned
   */
  public AbstractGrocery similarProduct(AbstractGrocery substituteProduct, Double qty) {
    AbstractGrocery similarGrocery = null;

    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      AbstractGrocery grocery = stockItem.getProduct();
      if (this.similarType(grocery, substituteProduct) &&
          this.validateProductQty(grocery, qty) &&
          this.similarPrice(grocery, substituteProduct) &&
          this.similarWeight(grocery, substituteProduct)) {
        similarGrocery = grocery;
      }
    }

    return similarGrocery;
  }

  /**
   * This method is used for finding similar household product for substituting product that is out
   * of stock. Product is substituted only when the similar product has similar type like Shampoo
   * product can be replaced by Shampoo type, and similar product has available quantity in stock
   * which is similar to quantity needed to substitute the product, and similar product price should
   * be less than or equal to the substituted product, and similar product units per package should
   * be greater than or equal to substituted product.
   *
   * @param substituteProduct AbstractHousehold product that needed to be substituted by staff,
   *                          represented as AbstractHousehold
   * @param qty               quantity of substitute product added in cart
   * @return represented in AbstractHousehold, if any similarProduct is found, similar household
   * product is returned else null will be returned
   */
  public AbstractHousehold similarProduct(AbstractHousehold substituteProduct, Double qty) {
    AbstractHousehold similarHousehold = null;

    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      AbstractHousehold household = stockItem.getProduct();
      if (this.similarType(household, substituteProduct) &&
          this.validateProductQty(household, qty) &&
          this.similarPrice(household, substituteProduct) &&
          this.similarUnits(household, substituteProduct)) {
        similarHousehold = household;
      }
    }

    return similarHousehold;
  }

  /**
   * This method is used to decrease the stock of grocery product by given quantity. Quantity of
   * grocery product should be decreased by given quantity. If quantity you want is reduced more
   * than available quantity in stock then throws custom exception, QuantityExceededException
   *
   * @param product AbstractGrocery product, represented as AbstractGrocery
   * @param qty     quantity to be reduced from stock, represented in Double
   */
  public void decreaseGroceryStock(AbstractGrocery product, Double qty) {
    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      if (stockItem.getProduct().equals(product)) {
        stockItem.reduceQuantity(product, qty);
      }
    }
  }

  /**
   * This method is used to decrease the stock of household product by given quantity. Quantity of
   * household product should be decreased by given quantity from the stock. If quantity you want is
   * reduced more than available quantity in stock then throws custom exception,
   * QuantityExceededException
   *
   * @param product AbstractHousehold product, represented as AbstractHousehold
   * @param qty     quantity to be reduced from stock, represented in Double
   */
  public void decreaseHouseholdStock(AbstractHousehold product, Double qty) {
    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      if (stockItem.getProduct().equals(product)) {
        stockItem.reduceQuantity(product, qty);
      }
    }
  }

  /**
   * This helper method increases stock of household product by given quantity.
   *
   * @param household AbstractHousehold product, represented as AbstractHousehold
   * @param quantity  quantity to be increased in stock, represented in Double
   */
  private void updateHouseholdStock(AbstractHousehold household, Double quantity) {
    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      if (stockItem.getProduct().equals(household)) {
        Double increasedQuantity = stockItem.getQuantity() + quantity;
        stockItem.setQuantity(increasedQuantity);
      }
    }
  }

  /**
   * This helper method checks whether household product is in stock or not
   *
   * @param household household product, represented as AbstractHousehold
   * @return Represented as Boolean, true if product is in household stock or false if there is no
   * same product as product given
   */
  private boolean isHouseholdProductPresent(AbstractHousehold household) {
    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      if (household.equals(stockItem.getProduct())) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * This helper method increases stock of grocery product by given quantity.
   *
   * @param grocery  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity quantity to be increased in stock, represented in Double
   */
  private void updateGroceryStock(AbstractGrocery grocery, Double quantity) {
    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      if (stockItem.getProduct().equals(grocery)) {
        Double increasedQuantity = stockItem.getQuantity() + quantity;
        stockItem.setQuantity(increasedQuantity);
      }
    }
  }

  /**
   * This helper method checks whether grocery product is in stock or not
   *
   * @param grocery AbstractGrocery product, represented as AbstractGrocery
   * @return Represented as Boolean, true if product is in grocery stock or false if there is no
   * same product as product given
   */
  private boolean isGroceryPresent(AbstractGrocery grocery) {
    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      if (grocery.equals(stockItem.getProduct())) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * This helper method returns total retail value of all grocery stock items.
   *
   * @return Represented as Double
   */
  private Double getGroceryTotalRetailValue() {
    Double totalAmount = MIN_AMOUNT;
    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      totalAmount += stockItem.getProduct().getPrice() * stockItem.getQuantity();
    }
    return totalAmount;
  }

  /**
   * This helper method returns total retail value of all household stock items.
   *
   * @return Represented as Double
   */
  private Double getHouseholdTotalRetailValue() {
    Double totalAmount = MIN_AMOUNT;
    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      totalAmount += stockItem.getProduct().getPrice() * stockItem.getQuantity();
    }
    return totalAmount;
  }

  /**
   * This helper method is used to check if grocery product quantity in stock is greater than equal
   * to quantity needed
   *
   * @param grocery  AbstractGrocery product, represented as AbstractGrocery
   * @param quantity quantity needed by customer
   * @return Represented as boolean, true if stock has more or equal quantity than quantity
   * mentioned in input
   */
  private boolean isQuantityAvailable(AbstractGrocery grocery, Double quantity) {
    for (StockItem<AbstractGrocery> stockItem : this.getGroceryStockItems()) {
      if (stockItem.getProduct().equals(grocery) && stockItem.getQuantity() >= quantity) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * This helper method is used to check if household product quantity in stock is greater than
   * equal to quantity needed
   *
   * @param household AbstractHousehold product, represented as AbstractHousehold
   * @param quantity  quantity needed by customer
   * @return Represented as boolean, true if stock has more or equal quantity than quantity
   * mentioned in input
   */
  private boolean isQuantityAvailable(AbstractHousehold household, Double quantity) {
    for (StockItem<AbstractHousehold> stockItem : this.getHouseStockItems()) {
      if (stockItem.getProduct().equals(household) && stockItem.getQuantity() >= quantity) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * This helper method checks whether product has more or equal to units per package than product
   * to be replaced
   *
   * @param household         AbstractHousehold product that is eligible for replacement,
   *                          represented as AbstractHousehold
   * @param substituteProduct AbstractHousehold product that needed to be replaced, represented as
   *                          AbstractHousehold
   * @return represented as boolean
   */
  private boolean similarUnits(AbstractHousehold household, AbstractHousehold substituteProduct) {
    return household.getUnitsPerPackage() >= substituteProduct.getUnitsPerPackage();
  }

  /**
   * This helper method checks whether product has more or equal to weight than product to be
   * replaced
   *
   * @param grocery           AbstractGrocery product that is eligible for replacement, represented
   *                          as AbstractGrocery
   * @param substituteProduct AbstractGrocery product that needed to be replaced, represented as
   *                          AbstractGrocery
   * @return represented as boolean
   */
  private boolean similarWeight(AbstractGrocery grocery, AbstractGrocery substituteProduct) {
    return grocery.getProductWeight() >= substituteProduct.getProductWeight();
  }

  /**
   * This helper method checks if product should have less or equal to price than product to be
   * replaced
   *
   * @param product           product that is eligible for replacement, represented as IProduct
   * @param substituteProduct product that needed to be replaced, represented as IProduct
   * @return represented as boolean
   */
  private boolean similarPrice(IProduct product, IProduct substituteProduct) {
    return product.getPrice() <= substituteProduct.getPrice();
  }

  /**
   * This helper method checks if product type is similar to product to be replaced
   *
   * @param product           product that is eligible for replacement, represented as IProduct
   * @param substituteProduct product that needed to be replaced, represented as IProduct
   * @return represented as boolean
   */
  private boolean similarType(IProduct product, IProduct substituteProduct) {
    return product.getProductType().equals(substituteProduct.getProductType());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) obj;
    return Objects.equals(this.getGroceryStockItems(), inventory.getGroceryStockItems())
        && Objects.equals(this.getHouseStockItems(), inventory.getHouseStockItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getGroceryStockItems(), this.getHouseStockItems());
  }

  @Override
  public String toString() {
    return "Inventory{" +
        "groceryStockItems=" + this.getGroceryStockItems() +
        ", houseStockItems=" + this.getHouseStockItems() +
        ", totalRetailCostInStock=" + totalRetailCostInStock() +
        '}';
  }
}
