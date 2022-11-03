package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateTest {
  private Template testTemplate;
  @BeforeEach
  void setUp() throws IOException {
    testTemplate = new Template("src/test/resources/letter-template-small.txt");
  }

  @Test
  void getTemplateContent() {
    String templateContent = """
        [[company_name]].
        [[first_name]] [[last_name]]
        [[address]], [[city]],
        [[county]], [[state]], [[zip]]
        ([[email]])
        """;
    assertEquals(templateContent, testTemplate.getTemplateContent());
  }

  @Test
  void getPlaceholders() {
    List<String> testPlaceholders = new ArrayList<>();
    testPlaceholders.add("company_name");
    testPlaceholders.add("first_name");
    testPlaceholders.add("last_name");
    testPlaceholders.add("address");
    testPlaceholders.add("city");
    testPlaceholders.add("county");
    testPlaceholders.add("state");
    testPlaceholders.add("zip");
    testPlaceholders.add("email");

    assertEquals(testPlaceholders, testTemplate.getPlaceholders());

  }

  @Test
  void testEquals() {
    assertTrue(testTemplate.equals(testTemplate));
  }

  @Test
  void testEquals_Null() {
    assertFalse(testTemplate.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(testTemplate.equals(new String("test")));
  }

  @Test
  void testEquals_Same() throws IOException {
    ITemplate dupTemplate = new Template("src/test/resources/letter-template-small.txt");
    assertTrue(testTemplate.equals(dupTemplate));
  }

  @Test
  void testEquals_diffContent() throws IOException {
    ITemplate diffTemplate = new Template("src/test/resources/letter-template.txt");
    assertFalse(testTemplate.equals(diffTemplate));
  }

  @Test
  void testHashCode() throws IOException {
    ITemplate dupTemplate = new Template("src/test/resources/letter-template-small.txt");
    String templateContent = """
        [[company_name]].
        [[first_name]] [[last_name]]
        [[address]], [[city]],
        [[county]], [[state]], [[zip]]
        ([[email]])
        """;
    int hashExp = Objects.hash(templateContent);
    assertEquals(hashExp, dupTemplate.hashCode());
  }

  @Test
  void testToString() throws IOException {
    ITemplate dupTemplate = new Template("src/test/resources/letter-template-small.txt");
    String templateContent = """
        [[company_name]].
        [[first_name]] [[last_name]]
        [[address]], [[city]],
        [[county]], [[state]], [[zip]]
        ([[email]])
        """;
    String expString = "Template{" +
        "templateContent='" + templateContent + '\'' +
        '}';
    assertEquals(expString, dupTemplate.toString());

  }
}