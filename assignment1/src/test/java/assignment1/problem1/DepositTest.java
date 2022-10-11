package assignment1.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepositTest {
  private Deposit deposit;
  private FrequentFlyerName name;
  private int depositAmount;
  private String accountID;
  @BeforeEach
  void setUp() {
    depositAmount = 2000;
    accountID = "12345";
    name = new FrequentFlyerName("Amy", "B", "Lincoln");
    deposit = new Deposit(depositAmount, accountID, name);
  }

  @Test
  void getDepositAmount() {
    assertEquals(2000, deposit.getDepositAmount());
  }

  @Test
  void getRecipientAccID() {
    assertEquals("12345", deposit.getRecipientAccID());
  }

  @Test
  void getRecipientAccName() {
    FrequentFlyerName dupName = new FrequentFlyerName("Amy", "B", "Lincoln");
    assertEquals(dupName, deposit.getRecipientAccName());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(deposit.equals(deposit));
  }

  @Test
  void testEquals_Same() {
    FrequentFlyerName dupName = new FrequentFlyerName("Amy", "B", "Lincoln");
    Deposit dupDeposit = new Deposit(2000, "12345", dupName);
    assertTrue(deposit.equals(dupDeposit));
  }

  @Test
  void testEquals_NotSame() {
    FrequentFlyerName dupName = new FrequentFlyerName("Olivia", "B", "Lincoln");
    Deposit dupDeposit = new Deposit(2000, "12345", dupName);
    assertFalse(deposit.equals(dupDeposit));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(deposit.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(deposit.equals(new StringBuilder("test")));
  }

  @Test
  void testEquals_Param1() {
    FrequentFlyerName dupName = new FrequentFlyerName("Amy", "B", "Lincoln");
    Deposit dupDeposit = new Deposit(200, "12345", dupName);
    assertFalse(deposit.equals(dupDeposit));
  }
  @Test
  void testEquals_Param2() {
    FrequentFlyerName dupName = new FrequentFlyerName("Amy", "B", "Lincoln");
    Deposit dupDeposit = new Deposit(2000, null, dupName);
    assertFalse(deposit.equals(dupDeposit));
  }
  @Test
  void testEquals_Param3() {
    Deposit dupDeposit = new Deposit(2000, "12345", null);
    assertFalse(deposit.equals(dupDeposit));
  }
  @Test
  void testHashCode() {
    Object expectedHashCode = Objects.hash(depositAmount, accountID, name);
    assertEquals(expectedHashCode, deposit.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Deposit{" +
        "depositAmount=" + this.depositAmount +
        ", recipientAccID='" + this.accountID + '\'' +
        ", recipientAccName=" + this.name +
        '}';

    assertEquals(expectedString, deposit.toString());
  }
}