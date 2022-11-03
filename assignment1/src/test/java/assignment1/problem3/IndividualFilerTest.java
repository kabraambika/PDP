package assignment1.problem3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualFilerTest {
  IndividualFiler indFiler1;
  ContactInfo contactInfo1;
  Double lastYrEarning1 = 23456000.0;
  String taxID1 = "123456";
  Double totalTaxPaid1 = 2300000.0;
  Double mortgageIntPaid1 = 250.0;
  Double propertyIntPaid1 = 2500.0;
  Double studLoanPaid1 = 5600.0;
  Double retSavAccount1 = 3450.0;
  Double healthAccount1 = 17500.0;
  Double donationContrib1 = 340.0;
  IndividualFiler indFiler2;
  String taxID2 = "9999999";

  @BeforeEach
  void setUp() {
    TaxFilerName filerName1 = new TaxFilerName("Mr", "Brown");
    contactInfo1 = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    indFiler1 = new Employee(taxID1,contactInfo1, lastYrEarning1,totalTaxPaid1,mortgageIntPaid1,propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1);
    indFiler2 = new Employee(taxID2,contactInfo1, lastYrEarning1,totalTaxPaid1,mortgageIntPaid1,propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1);
  }

  @Test
  void testEquals() {
    assertTrue(indFiler1.equals(indFiler1));
    assertFalse(indFiler1.equals(null));
    assertFalse(indFiler1.equals(new StringBuilder("test0")));
    assertTrue(indFiler1.equals(new Employee(taxID1,contactInfo1, lastYrEarning1,totalTaxPaid1,mortgageIntPaid1,propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1)));
  }

  @Test
  void testHashCode() {
    IndividualFiler dupIndFiler1 = new Employee(taxID1,contactInfo1, lastYrEarning1,totalTaxPaid1,mortgageIntPaid1,propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1);
    StringBuilder stringBuilder = new StringBuilder("test1");

    assertEquals(indFiler1.hashCode(), indFiler1.hashCode());
    assertNotEquals(indFiler2.hashCode(), indFiler1.hashCode());
    assertEquals(indFiler1.hashCode(), dupIndFiler1.hashCode());
    assertNotEquals(indFiler1.hashCode(), stringBuilder.hashCode());
  }

  @Test
  void testCalculateTaxOnHealthRetirement(){
    Double amt = indFiler1.calculateTaxOnHealthRetirement(2000.0);
    assertEquals(0.0, amt);
  }

  @Test
  void testCalculateTaxOnHealthRetirement_moreCurrentTaxableIncome(){
    Double amt = indFiler1.calculateTaxOnHealthRetirement(2000000.0);
    assertEquals(1985335.0, amt);
  }

  @Test
  void testCalculateFinalTaxableIncome_lessBracket() {
    Double amt = indFiler1.calculateFinalTaxableIncome(5500.0);
    assertEquals(825.0, amt);
  }

  @Test
  void testCalculateFinalTaxableIncome_equalBracket() {
    Double amt = indFiler1.calculateFinalTaxableIncome(55000.0);
    assertEquals(8250.0, amt);
  }

  @Test
  void testCalculateFinalTaxableIncome_moreBracket() {
    Double amt = indFiler1.calculateFinalTaxableIncome(60000.0);
    assertEquals(11400.0, amt);
  }
}