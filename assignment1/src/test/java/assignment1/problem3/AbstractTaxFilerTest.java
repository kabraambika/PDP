package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTaxFilerTest {
  ContactInfo contactInfo;
  Double lastYrEarning = 20000.0;
  String taxID = "123456";
  Double totalTaxPaid = 2000.0;
  Double mortgageIntPaid = 12500.0;
  Double propertyIntPaid = 2500.0;
  Double studLoanPaid = 5600.0;
  Double retSavAccount =  17_500.0;
  Double healthAccount = 2300.0;
  Double donationContrib = 340.0;
  AbstractTaxFiler abstractFiler;
  AbstractTaxFiler abstractFiler2;
  @BeforeEach
  void setUp() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    abstractFiler = new IndividualFiler("123456", contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    abstractFiler2 = new GroupFiler("123456", contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, GroupFilerType.HEAD_OF_THE_HOUSEHOLD, 2, 2, 1200.0, 2500.0);
  }

  @Test
  void getTaxID() {
    assertEquals(taxID, abstractFiler.getTaxID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, abstractFiler.getContactInfo());
  }

  @Test
  void getLastYrEarning() {
    assertEquals(lastYrEarning, abstractFiler.getLastYrEarning());
  }

  @Test
  void getTotalTaxPaid() {
    assertEquals(totalTaxPaid, abstractFiler.getTotalTaxPaid());
  }

  @Test
  void getMortgageIntPaid() {
    assertEquals(mortgageIntPaid, abstractFiler.getMortgageIntPaid());
  }

  @Test
  void getPropertyIntPaid() {
    assertEquals(propertyIntPaid, abstractFiler.getPropertyIntPaid());
  }

  @Test
  void getStudLoanPaid() {
    assertEquals(studLoanPaid, abstractFiler.getStudLoanPaid());
  }

  @Test
  void getRetSavAccount() {
    assertEquals(retSavAccount, abstractFiler.getRetSavAccount());
  }

  @Test
  void getHealthAccount() {
    assertEquals(healthAccount, abstractFiler.getHealthAccount());
  }

  @Test
  void getDonationContrib() {
    assertEquals(donationContrib, abstractFiler.getDonationContrib());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(abstractFiler.equals(abstractFiler));
  }

  @Test
  void testEquals_NotSame() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("3456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Same() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertTrue(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(abstractFiler.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    StringBuilder sb = new StringBuilder("test");
    assertFalse(abstractFiler.equals(sb));
  }

  @Test
  void testEquals_Parameter1() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("3456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter2() {
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", null, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter3() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, null, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter4() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, null, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter5() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, null, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter6() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, null, studLoanPaid, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter7() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, null, retSavAccount, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter8() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, null, healthAccount, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter9() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, null, donationContrib, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testEquals_Parameter10() {
    TaxFilerName filerName = new TaxFilerName("Ambika", "");
    ContactInfo dupContactInfo = new ContactInfo(filerName, "225 Terry ave", "987654321","a@gmail.com");
    AbstractTaxFiler dupAbstractFiler = new IndividualFiler("123456", dupContactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, null, IndividualFilerType.EMPLOYEE);
    assertFalse(abstractFiler.equals(dupAbstractFiler));
  }

  @Test
  void testHashCode() {
    assertEquals(totalTaxPaid, abstractFiler.getTotalTaxPaid());
  }

  @Test
  void testToString() {
    String name = "TaxFilerName{" +
        "firstName='" + "Ambika" + '\'' +
        ", lastName='" + "" + '\'' +
        '}';
    String contactInfo = "ContactInfo{" +
        "taxFilerName=" + name +
        ", address='" + "225 Terry ave" + '\'' +
        ", phoneNumber='" + "987654321" + '\'' +
        ", emailAddress='" + "a@gmail.com" + '\'' +
        '}';
    String expectedString = "AbstractTaxFiler{" +
        "taxID='" + 123456 + '\'' +
        ", contactInfo=" + contactInfo +
        ", lastYrEarning=" + lastYrEarning +
        ", totalTaxPaid=" + totalTaxPaid +
        ", mortgageIntPaid=" + mortgageIntPaid +
        ", propertyIntPaid=" + propertyIntPaid +
        ", studLoanPaid=" + studLoanPaid +
        ", retSavAccount=" + retSavAccount +
        ", healthAccount=" + healthAccount +
        ", donationContrib=" + donationContrib +
        '}';
    assertNotEquals(expectedString, abstractFiler.toString());
  }

  @Test
  void calculateCurrentTaxable() {
    assertEquals(18000.0, abstractFiler.calculateCurrentTaxable());
  }

  @Test
  void calculateTaxOnHealthRetirement() {
    Double amt1 = abstractFiler.calculateTaxOnHealthRetirement(2000.0, Boolean.TRUE);
    assertEquals(0.0, amt1);
    Double amt2 = abstractFiler.calculateTaxOnHealthRetirement(2000.0, Boolean.FALSE);
    assertEquals(0.0, amt2);
    Double amt3 = abstractFiler.calculateTaxOnHealthRetirement(20000.0, Boolean.TRUE);
    assertEquals(7130.0, amt3);
    Double amt4 = abstractFiler.calculateTaxOnHealthRetirement(20000.0, Boolean.FALSE);
    assertEquals(6140.0, amt4);
    Double amt5 = abstractFiler.calculateTaxOnHealthRetirement(20000.0, Boolean.FALSE);
    assertEquals(6140.0, amt5);
  }

  @Test
  void calculateTaxOnHealthRetirement_MoreThanContrib() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    abstractFiler = new IndividualFiler("123456", contactInfo, lastYrEarning, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, 17500.0, donationContrib, IndividualFilerType.EMPLOYEE);
    Double amt5 = abstractFiler.calculateTaxOnHealthRetirement(20000.0, Boolean.FALSE);
    assertEquals(0.0, amt5);
    Double amt3 = abstractFiler.calculateTaxOnHealthRetirement(20000.0, Boolean.TRUE);
    assertEquals(2500.0, amt3);
  }

  @Test
  void calculateTaxOnMortgagePropertyIn() {
    Double amt = abstractFiler.calculateTaxOnMortgagePropertyIn(2000.0);
    assertEquals(0.0, amt);
    Double amt2 = abstractFiler.calculateTaxOnMortgagePropertyIn(20000.0);
    assertEquals(17500, amt2);
    Double amt3 = abstractFiler.calculateTaxOnMortgagePropertyIn(2000000.0);
    assertEquals(1997500.0, amt3);
  }

  @Test
  void calculateTaxOnMortgagePropertyIn_InCondition1() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    abstractFiler = new IndividualFiler("123456", contactInfo, 300000.0, totalTaxPaid, mortgageIntPaid, propertyIntPaid, studLoanPaid, retSavAccount, 17500.0, donationContrib, IndividualFilerType.EMPLOYEE);
    Double amt3 = abstractFiler.calculateTaxOnMortgagePropertyIn(25000.0);
    assertEquals(25000.0, amt3);
  }

  @Test
  void calculateTaxOnMortgagePropertyIn_InCondition2() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321","a@gmail.com");
    abstractFiler = new IndividualFiler("123456", contactInfo, lastYrEarning, totalTaxPaid, 125.0, propertyIntPaid, studLoanPaid, retSavAccount, 17500.0, donationContrib, IndividualFilerType.EMPLOYEE);
    Double amt3 = abstractFiler.calculateTaxOnMortgagePropertyIn(25000.0);
    assertEquals(25000.0, amt3);
  }

  @Test
  void calculateTaxIncomeAfterChildcare() {
    Double amt = abstractFiler.calculateTaxIncomeAfterChildcare(2000.0, 60000.0);
    assertEquals(750.0, amt);
  }

  @Test
  void calculateTaxIncomeAfterChildcare_lessIncome() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321", "a@gmail.com");
    abstractFiler = new GroupFiler("123456", contactInfo, 200000.0, totalTaxPaid, mortgageIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib,
        GroupFilerType.HEAD_OF_THE_HOUSEHOLD, 2, 2, 100.0, 2500.0);
    Double amt5 = abstractFiler.calculateTaxIncomeAfterChildcare(2000.0, 6000.0);
    assertEquals(2000.0, amt5);
  }

  @Test
  void calculateTaxIncomeAfterChildcare_lessContrib() {
    TaxFilerName filerName1 = new TaxFilerName("Ambika", "");
    contactInfo = new ContactInfo(filerName1, "225 Terry ave", "987654321", "a@gmail.com");
    abstractFiler = new GroupFiler("123456", contactInfo, 2000.0, totalTaxPaid, mortgageIntPaid,
        propertyIntPaid, studLoanPaid, retSavAccount, healthAccount, donationContrib,
        GroupFilerType.HEAD_OF_THE_HOUSEHOLD, 2, 2, 100.0, 2500.0);
    Double amt5 = abstractFiler.calculateTaxIncomeAfterChildcare(2000.0, 600.0);
    assertEquals(2000.0, amt5);
  }

  @Test
  void calculateFinalTaxableIncome_1() {
    Double finalAmt = abstractFiler.calculateFinalTaxableIncome(50000.0, Boolean.TRUE);
    assertEquals(7249.999999999999, finalAmt);
  }

  @Test
  void calculateFinalTaxableIncome_2() {
    Double finalAmt = abstractFiler.calculateFinalTaxableIncome(50000.0, Boolean.FALSE);
    assertEquals(7500.0, finalAmt);
  }
}