package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
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

  @BeforeEach
  void setUp() {
    TaxFilerName filerName1 = new TaxFilerName("Mr", "Brown");
    contactInfo1 = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    indFiler1 = new Employee(taxID1,contactInfo1, lastYrEarning1,totalTaxPaid1,mortgageIntPaid1,propertyIntPaid1, studLoanPaid1, retSavAccount1, healthAccount1, donationContrib1);
  }

  @Test
  void calculateTaxes() {
    Double amt = indFiler1.calculateTaxes();
    assertEquals(4016853.65, amt);
  }
}