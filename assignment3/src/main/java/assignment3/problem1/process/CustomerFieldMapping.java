package assignment3.problem1.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * CustomerFieldMapping is a class which maps header with customer details, both provided in List
 * @author kabraambika19
 */
public class CustomerFieldMapping {
  private Map<String, String> headerValueMap;

  /**
   * Constructor of CustomerFieldMapping
   * @param headers Headers provided from CSV, List of String
   * @param customersData single customer details from CSV, List of String
   */
  public CustomerFieldMapping(List<String> headers, List<String> customersData) {
    this.headerValueMap = new HashMap<>();
    this.updateMapping(headers, customersData);
  }

  /**
   * get map which stores header as key and customer data as value
   * @return Map of String, String
   */
  public Map<String, String> getHeaderValueMap() {
    return this.headerValueMap;
  }

  /**
   * Get value of provided key if not present then null
   * @param key Header provided from CSV or placeholder in template, String
   * @return String, value of key
   */
  public String getHeaderValue(String key) {
    return this.headerValueMap.getOrDefault(key, null);
  }

  /**
   * This private method map headers and value of customer data
   * @param headers Headers provided from CSV, List of String
   * @param customersData single customer details from CSV, List of String
   */
  private void updateMapping(List<String> headers, List<String> customersData) {
    for(int index = 0; index < headers.size(); index++){
      this.headerValueMap.put(headers.get(index), customersData.get(index));
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
    CustomerFieldMapping mapping = (CustomerFieldMapping) obj;
    return Objects.equals(this.getHeaderValueMap(), mapping.getHeaderValueMap());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getHeaderValueMap());
  }

  @Override
  public String toString() {
    return "CustomerFieldMapping{" +
        "headerValueMap=" + this.getHeaderValueMap() +
        '}';
  }
}
