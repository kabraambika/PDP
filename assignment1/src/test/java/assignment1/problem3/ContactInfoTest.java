package assignment1.problem3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {

  TaxFilerName filerName1;
  TaxFilerName filerName2;
  TaxFilerName filerName3;

  ContactInfo contactInfo1;
  ContactInfo contactInfo2;
  ContactInfo contactInfo3;

  @BeforeEach
  void setUp() {
    filerName1 = new TaxFilerName("Ambika", "");
    filerName2 = new TaxFilerName("Olivia", "Lincoln");
    filerName3 = new TaxFilerName("Mr", "Brown");

    contactInfo1 = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    contactInfo2 = new ContactInfo(filerName2, "401 Terry ave", "9956423111","o@gmail.com");
    contactInfo3 = new ContactInfo(filerName3, "225 Wall ST", "8567512345","b@gmail.com");  }

  @Test
  void getName() {
    TaxFilerName  dupfilerName3 = new TaxFilerName("Mr", "Brown");
    assertEquals(dupfilerName3, contactInfo3.getName());
  }

  @Test
  void getAddress() {
    assertEquals("225 Wall ST", contactInfo3.getAddress());
  }

  @Test
  void getPhoneNumber() {
    assertEquals("8567512345", contactInfo3.getPhoneNumber());
  }

  @Test
  void getEmailAddress() {
    assertEquals("b@gmail.com", contactInfo3.getEmailAddress());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(contactInfo1.equals(contactInfo1));
  }

  @Test
  void testEquals_NotSame() {
    assertFalse(contactInfo1.equals(contactInfo2));
  }

  @Test
  void testEquals_Same() {
    assertTrue(contactInfo1.equals(new ContactInfo(new TaxFilerName("Ambika", ""), "225 Terry ave", "987654321","a@gmail.com")));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(contactInfo1.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(contactInfo1.equals(new StringBuffer("test")));
  }

  @Test
  void testEquals_Parameter1() {
    assertFalse(contactInfo1.equals(new ContactInfo(null, "225 Terry ave", "987654321","a@gmail.com")));
  }

  @Test
  void testEquals_Parameter2() {
    assertFalse(contactInfo1.equals(new ContactInfo(new TaxFilerName("Ambika", ""), null, "987654321","a@gmail.com")));
  }

  @Test
  void testEquals_Parameter3() {
    assertFalse(contactInfo1.equals(new ContactInfo(new TaxFilerName("Ambika", ""), "225 Terry ave", null,"a@gmail.com")));
  }

  @Test
  void testEquals_Parameter4() {
    assertFalse(contactInfo1.equals(new ContactInfo(new TaxFilerName("Ambika", ""), "225 Terry ave", "987654321",null)));
  }

  @Test
  void testHashCodeItself() {
    assertEquals(contactInfo1.hashCode(), contactInfo1.hashCode());
  }

  @Test
  void testHashCodeNotSame() {
    TaxFilerName filerName4 = new TaxFilerName("Ambika", "");
    ContactInfo contactInfo4 = new ContactInfo(filerName4, "225 Terry ave", "987654321","a@gmail.com");
    assertNotEquals(contactInfo4.hashCode(), contactInfo2.hashCode());
  }

  @Test
  void testHashCode() {
    TaxFilerName filerName4 = new TaxFilerName("Ambika", "");
    ContactInfo contactInfo4 = new ContactInfo(filerName4, "225 Terry ave", "987654321","a@gmail.com");
    assertEquals(contactInfo4.hashCode(), contactInfo1.hashCode());
  }

  @Test
  void testHashCodeByDatatype() {
    StringBuilder test0 = new StringBuilder("test0");
    assertNotEquals(contactInfo1.hashCode(), test0.hashCode());
  }

  @Test
  void testToString() {
    String name = "TaxFilerName{" +
        "firstName='" + "Ambika" + '\'' +
        ", lastName='" + "" + '\'' +
        '}';
    String expectedString = "ContactInfo{" +
        "taxFilerName=" + name +
        ", address='" + "225 Terry ave" + '\'' +
        ", phoneNumber='" + "987654321" + '\'' +
        ", emailAddress='" + "a@gmail.com" + '\'' +
        '}';
    assertEquals(expectedString, contactInfo1.toString());
  }
}