package assignment1.problem3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupFilerTest {

  GroupFiler grpFiler1;
  ContactInfo contactInfo1;
  Double lastYrEarning1 = 23456000.0;
  String taxID1 = "123456";
  Double totalTaxPaid1 = 2300000.0;
  Double mortgageIntPaid1 = 250.0;
  Double propertyIntPaid1 = 2500.0;
  Double studLoanPaid1 = 5600.0;
  Double retSavAccount1 = 3450.0;
  Double healthAccount1 = 2300.0;
  Double donationContrib1 = 340.0;
  Integer numDependent1 = 1;
  Integer numChild1 = 1;
  Double childCareExp1 = 200.0;
  Double depCareExp1 = 30.0;
  GroupFilerType grpType1;
  GroupFilerType grpType2;
  GroupFilerType grpType3;
  GroupFiler grpFiler2;
  GroupFiler grpFiler3;
  String taxID2 = "9999999";
  String taxID3 = "1111111";
  @BeforeEach
  void setUp() {
    grpType1 = GroupFilerType.HEAD_OF_THE_HOUSEHOLD;
    grpType2 = GroupFilerType.MARRIED_FILLING_JOINTLY;
    grpType3 = GroupFilerType.MARRIED_FILLING_SEPARATELY;
    grpFiler1 = new GroupFiler(taxID1, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType1, numDependent1, numChild1, childCareExp1, depCareExp1);
    grpFiler2 = new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, numChild1, childCareExp1, depCareExp1);
    grpFiler3 = new GroupFiler(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType3, numDependent1, numChild1, childCareExp1, depCareExp1);

  }

  @Test
  void getGrpFilerType() {
    assertEquals(GroupFilerType.HEAD_OF_THE_HOUSEHOLD, grpFiler1.getGrpFilerType());
    assertEquals(GroupFilerType.MARRIED_FILLING_JOINTLY, grpFiler2.getGrpFilerType());
  }

  @Test
  void getNumDependent() {
    assertEquals(1, grpFiler1.getNumDependent());
  }

  @Test
  void getNumChild() {
    assertEquals(1, grpFiler1.getNumDependent());
  }

  @Test
  void getChildCareExp() {
    assertEquals(200.0, grpFiler1.getChildCareExp());
  }

  @Test
  void getDepCareExp() {
    assertEquals(30.0, grpFiler1.getDepCareExp());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(grpFiler2.equals(grpFiler2));
  }

  @Test
  void testEquals_NotSame() {
    assertFalse(grpFiler1.equals(grpFiler2));
  }

  @Test
  void testEquals_Same() {
    assertTrue(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, numChild1, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(grpFiler1.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(grpFiler1.equals(new StringBuffer("test")));
  }

  @Test
  void testEquals_Parameter1() {
    assertFalse(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, null, numDependent1, numChild1, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_Parameter2() {
    assertFalse(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, null, numChild1, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_Parameter3() {
    assertFalse(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, null, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_Parameter4() {
    assertFalse(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, numChild1, null, depCareExp1)));
  }

  @Test
  void testEquals_Parameter5() {
    assertFalse(grpFiler2.equals(new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, numChild1, childCareExp1, null)));
  }

  @Test
  void testHashCode() {
    GroupFiler dupGrpFiler2 = new GroupFiler(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, grpType2, numDependent1, numChild1, childCareExp1, depCareExp1);
    StringBuilder stringBuilder = new StringBuilder("test1");
    assertEquals(grpFiler2.hashCode(), grpFiler2.hashCode());
    assertNotEquals(grpFiler2.hashCode(), grpFiler1.hashCode());
    assertEquals(grpFiler2.hashCode(), dupGrpFiler2.hashCode());
    assertNotEquals(grpFiler2.hashCode(), stringBuilder.hashCode());
  }

  @Test
  void testToString() {
    String grpTypeString = "GroupFilerType{" +
        "grpFilerType='" + "MARRIED_FILLING_SEPARATELY" + '\'' +
        '}';
    String expectedString = "GroupFiler{" +
        "grpFilerType=" + grpTypeString +
        ", numDependent=" + 1 +
        ", numChild=" + 1 +
        ", childCareExp=" + 200.0 +
        ", depCareExp=" + 30.0 +
        '}';
    assertEquals(expectedString, grpFiler3.toString());
  }

  @Test
  void calculateTaxes() {
    assertEquals(3913168.5625, grpFiler1.calculateTaxes());
  }
}