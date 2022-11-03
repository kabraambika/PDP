package assignment3.problem1.process;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomatedDocumentTest {
  private String docContent;
  private AutomatedDocument documentTest;
  @BeforeEach
  void setUp() {
    docContent = """
    As you may have heard or read, last month we learned that criminals forced their way into our systems,\s
    and stole information about our customers. Late last week, as part of our ongoing investigation,\s
    we learned that the taken information includes names, mailing addresses, phone numbers or email addresses.
    """;
    documentTest = new AutomatedDocument(docContent);
  }

  @Test
  void getDocumentContent() {
    String expDocContent = """
    As you may have heard or read, last month we learned that criminals forced their way into our systems,\s
    and stole information about our customers. Late last week, as part of our ongoing investigation,\s
    we learned that the taken information includes names, mailing addresses, phone numbers or email addresses.
    """;
    assertTrue(expDocContent.equals(documentTest.getDocumentContent()));
  }

  @Test
  void testEquals() {
    assertTrue(documentTest.equals(documentTest));
  }

  @Test
  void testEquals_Null() {
    assertFalse(documentTest.equals(null));
  }

  @Test
  void testEquals_DiffType() {
    assertFalse(documentTest.equals(new String("test")));
  }

  @Test
  void testEquals_SameObj() {
    AutomatedDocument dupDocumentTest = new AutomatedDocument(docContent);
    assertTrue(documentTest.equals(dupDocumentTest));
  }

  @Test
  void testEquals_DiffObj() {
    AutomatedDocument dupDocumentTest = new AutomatedDocument("");
    assertFalse(documentTest.equals(dupDocumentTest));
  }

  @Test
  void testHashCode() {
    int hasExp = Objects.hash(docContent);
    assertEquals(hasExp, documentTest.hashCode());
  }

  @Test
  void testToString() {
    String expString = "AutomatedDocument{" +
        "uniqueName='" + documentTest.getUniqueName() + '\'' +
        ", documentContent='" + docContent + '\'' +
        '}';
    assertEquals(expString, documentTest.toString());
  }
}