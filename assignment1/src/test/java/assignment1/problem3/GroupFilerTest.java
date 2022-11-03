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
  GroupFiler grpFiler2;
  GroupFiler grpFiler3;
  String taxID2 = "9999999";
  String taxID3 = "1111111";
  @BeforeEach
  void setUp() {
    grpFiler1 = new HeadOfHousehold(taxID1, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, depCareExp1);
    grpFiler2 = new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, depCareExp1);
    grpFiler3 = new MarriedFillingSeparately(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
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
    assertTrue(grpFiler2.equals(new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, depCareExp1)));
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
  void testEquals_Parameter2() {
    assertFalse(grpFiler2.equals(new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, null, numChild1, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_Parameter3() {
    assertFalse(grpFiler2.equals(new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, null, childCareExp1, depCareExp1)));
  }

  @Test
  void testEquals_Parameter4() {
    assertFalse(grpFiler2.equals(new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, null, depCareExp1)));
  }

  @Test
  void testEquals_Parameter5() {
    assertFalse(grpFiler2.equals(new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, null)));
  }

  @Test
  void testHashCode() {
    GroupFiler dupGrpFiler2 = new MarriedFillingJointly(taxID2, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, depCareExp1);
    StringBuilder stringBuilder = new StringBuilder("test1");
    assertEquals(grpFiler2.hashCode(), grpFiler2.hashCode());
    assertNotEquals(grpFiler2.hashCode(), grpFiler1.hashCode());
    assertEquals(grpFiler2.hashCode(), dupGrpFiler2.hashCode());
    assertNotEquals(grpFiler2.hashCode(), stringBuilder.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "GroupFiler{" +
        "numDependent=" + 1 +
        ", numChild=" + 1 +
        ", childCareExp=" + 6000.0 +
        ", depCareExp=" + 30.0 +
        '}';
    assertEquals(expectedString, grpFiler3.toString());
  }

  @Test
  void testCalculateTaxOnHealthRetirement_lessIncome() {
    Double amt1 = grpFiler2.calculateTaxOnHealthRetirement(2000.0);
    assertEquals(0.0, amt1);
  }

  @Test
  void testCalculateTaxOnHealthRetirement_MoreIncome() {
    Double amt3 = grpFiler2.calculateTaxOnHealthRetirement(20000.0);
    assertEquals(16262.5, amt3);
  }

  @Test
  void testCalculateTaxOnHealthRetirement_totalContribMoreThan17500() {
    grpFiler3 = new MarriedFillingSeparately(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, 175000.0, 0.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double amt = grpFiler3.calculateTaxOnHealthRetirement(200000.0);
    assertEquals(182500.0, amt);
  }

  @Test
  void testCalculateTaxOnHealthRetirement_totalContribLessThan17500() {
    grpFiler3 = new MarriedFillingSeparately(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, 100.0, 0.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double amt = grpFiler3.calculateTaxOnHealthRetirement(200000.0);
    assertEquals(199935.0, amt);
  }

  @Test
  void testCalculateTaxIncomeAfterChildcare() {
    Double amt = grpFiler1.calculateTaxIncomeAfterChildcare(2000.0);
    assertEquals(2000.0, amt);
  }

  @Test
  void testCalculateTaxIncomeAfterChildcare_lessLastEarning() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, 200000.0, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double amt = grpFiler4.calculateTaxIncomeAfterChildcare(2000.0);
    assertEquals(2000.0, amt);
  }

  @Test
  void testCalculateTaxIncomeAfterChildcare_moreLastEarning() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, 2000000.0, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double amt = grpFiler4.calculateTaxIncomeAfterChildcare(2000.0);
    assertEquals(2000.0, amt);
  }

  @Test
  void testCalculateTaxIncomeAfterChildcare_lessLastEarning_moreChildExpenses() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, 20000.0, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double amt = grpFiler4.calculateTaxIncomeAfterChildcare(2000.0);
    assertEquals(750.0, amt);
  }

  @Test
  void testCalculateTaxIncomeAfterChildcare_lessLastEarning_lessChildExpenses() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, 20000.0, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 600.0, depCareExp1);
    Double amt = grpFiler4.calculateTaxIncomeAfterChildcare(2000.0);
    assertEquals(2000.0, amt);
  }

  @Test
  void testCalculateFinalTaxableIncome_firstBracket() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double finalAmt = grpFiler4.calculateFinalTaxableIncome(50000.0);
    assertEquals(7249.999999999999, finalAmt);
  }

  @Test
  void testCalculateFinalTaxableIncome_secondBracket() {
    GroupFiler grpFiler4 = new MarriedFillingSeparately(taxID3, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, 17_500.0, donationContrib1, numDependent1, numChild1, 6000.0, depCareExp1);
    Double finalAmt = grpFiler4.calculateFinalTaxableIncome(100000.0);
    assertEquals(18500.0, finalAmt);
  }

}