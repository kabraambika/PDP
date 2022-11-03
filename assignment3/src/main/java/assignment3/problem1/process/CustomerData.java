package assignment3.problem1.process;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * CustomerData is a class which provides information of headers and all customer details in list
 * This class implements Iterator interface
 * @author kabraambika19
 */
public class CustomerData implements Iterator<List<String>> {

  /**
   * Constant for Zero to reset customer ID
   */
  private static final int STARTING_INDEX = 0;
  private int customerID = 0;
  private List<String> headers;
  private List<List<String>> customerDetails;

  /**
   * Constructor of CustomerData
   * @param csvData List of String type list
   */
  public CustomerData(List<List<String>> csvData) {
    this.headers = csvData.get(0);
    this.customerDetails = csvData.subList(1, csvData.size());
  }

  /**
   * Get headers of CSV file
   * @return this.headers, List of string
   */
  public List<String> getHeaders() {
    return this.headers;
  }

  /**
   * Get customer details in form of List of String type List
   * @return List of String type list
   */
  public List<List<String>> getCustomerDetails() {
    return this.customerDetails;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CustomerData that = (CustomerData) obj;
    return Objects.equals(this.getHeaders(), that.getHeaders()) && Objects.equals(
        this.getCustomerDetails(), that.getCustomerDetails());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getHeaders(), this.getCustomerDetails());
  }

  @Override
  public String toString() {
    return "CustomerData{" +
        "headers=" + this.getHeaders() +
        ", customerDetails=" + this.getCustomerDetails() +
        '}';
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return this.customerID < this.getCustomerDetails().size();
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public List<String> next() {
    return this.getCustomerDetails().get(this.customerID++);
  }

  /**
   * To reset the customer ID to Zero
   */
  public void resetCustomerID() {
    this.customerID = STARTING_INDEX;
  }
}
