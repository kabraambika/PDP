package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeadOfHouseholdTest {
  GroupFiler grpFiler1;
  ContactInfo contactInfo1;
  Double lastYrEarning1 = 234000.0;
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

  @BeforeEach
  void setUp() {
    grpFiler1 = new HeadOfHousehold(taxID1, contactInfo1, lastYrEarning1, totalTaxPaid1, mortgageIntPaid1, propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1, numDependent1, numChild1, childCareExp1, depCareExp1);
  }

  @Test
  void calculateTaxes() {
    Double amt = grpFiler1.calculateTaxes();
    assertEquals(0.0, amt);
  }
}