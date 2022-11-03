package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerFieldMappingTest {
  private CustomerFieldMapping mappingTest;
  private Map<String, String> expMapping;
  @BeforeEach
  void setUp() {
    List<String> headers = new ArrayList<>();
    headers.add("first_name");
    headers.add("last_name");
    List<String> james = new ArrayList<>();
    james.add("James");
    james.add("Butt");

    expMapping = new HashMap<>();
    expMapping.put("first_name", "James");
    expMapping.put("last_name", "Butt");

    mappingTest = new CustomerFieldMapping(headers, james);
  }

  @Test
  void getHeaderValueMap() {
    assertEquals(expMapping, mappingTest.getHeaderValueMap());
  }

  @Test
  void getHeaderValue() {
    assertEquals("James", mappingTest.getHeaderValue("first_name"));
  }

  @Test
  void testEquals() {
    assertTrue(mappingTest.equals(mappingTest));
  }

  @Test
  void testEquals_null() {
    assertFalse(mappingTest.equals(null));
  }

  @Test
  void testEquals_diffType() {
    assertFalse(mappingTest.equals(new String("test")));
  }

  @Test
  void testEquals_Similar() {
    List<String> dupHeaders = new ArrayList<>();
    dupHeaders.add("first_name");
    dupHeaders.add("last_name");
    List<String> dupJames = new ArrayList<>();
    dupJames.add("James");
    dupJames.add("Butt");
    CustomerFieldMapping dupMappingTest = new CustomerFieldMapping(dupHeaders, dupJames);
    assertTrue(mappingTest.equals(dupMappingTest));
  }

  @Test
  void testEquals_Different() {
    List<String> dupHeaders = new ArrayList<>();
    dupHeaders.add("first_name");
    dupHeaders.add("last_name");
    List<String> dupJames = new ArrayList<>();
    dupJames.add("James");
    dupJames.add("Albert");
    CustomerFieldMapping dupMappingTest = new CustomerFieldMapping(dupHeaders, dupJames);
    assertFalse(mappingTest.equals(dupMappingTest));
  }

  @Test
  void testHashCode() {
    int expHash = Objects.hash(expMapping);
    assertEquals(expHash, mappingTest.hashCode());
  }

  @Test
  void testToString() {
    String expString = "CustomerFieldMapping{" +
        "headerValueMap=" + expMapping +
        '}';
    assertEquals(expString, mappingTest.toString());
  }
}