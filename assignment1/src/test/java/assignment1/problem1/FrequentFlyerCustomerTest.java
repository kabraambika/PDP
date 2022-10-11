package assignment1.problem1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrequentFlyerCustomerTest {
  private String accountID;
  private FrequentFlyerName name;
  private String email;
  private MilesBalance milesBalance;
  private FrequentFlyerCustomer flyerCustomer;
  @BeforeEach
  void setUp() throws InvalidCustomerException {
    this.accountID = "abcdefabcdef";
    this.name = new FrequentFlyerName("Amy", "J", "Brown");
    this.email = "a@gmail.com";
    this.milesBalance = new MilesBalance(1100, 200, 800);

    flyerCustomer = new FrequentFlyerCustomer(accountID, name, email, milesBalance);
    flyerCustomer.updateCustomer(flyerCustomer);
  }

  @Test
  void getAccountID() {
    assertEquals(accountID, flyerCustomer.getAccountID());
  }

  @Test
  void getName() {
    assertEquals(name, flyerCustomer.getName());
  }

  @Test
  void getEmail() {
    assertEquals(email, flyerCustomer.getEmail());
  }

  @Test
  void getMilesBalance() {
    assertEquals(milesBalance, flyerCustomer.getMilesBalance());
  }

  @Test
  void testEquals_ByItself() {
    assertTrue(flyerCustomer.equals(flyerCustomer));
  }

  @Test
  void testEquals_Same() throws InvalidCustomerException {
    FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(accountID, name, email, milesBalance);
    assertTrue(flyerCustomer.equals(dupFlyerCustomer));
  }

  @Test
  void testEquals_NotSame() throws InvalidCustomerException {
    FrequentFlyerCustomer flyerCustomer1 = new FrequentFlyerCustomer(accountID, name, email, null);
    assertFalse(flyerCustomer.equals(flyerCustomer1));
  }

  @Test
  void testEquals_NotNull() {
    assertFalse(flyerCustomer.equals(null));
  }

  @Test
  void testEquals_ByInstance() {
    assertFalse(flyerCustomer.equals(new StringBuilder("test")));
  }

  @Test
  void testEquals_Param1() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(null, name, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param4() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer("abc", name, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param2() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(accountID, null, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param5() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerName name2 = new FrequentFlyerName("Ambika", "J", "Brown");
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(null, name2, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param6() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerName name2 = new FrequentFlyerName("", "J", "Brown");
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(null, name2, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param7() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerName name2 = new FrequentFlyerName("Ambika", "J", "");
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(null, name2, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param8() throws InvalidCustomerException {
    assertDoesNotThrow(() -> {
      FrequentFlyerName name2 = new FrequentFlyerName("Ambika", "J", "Brown");
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer("abcdefabcdef", name2, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param9() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> {
      FrequentFlyerName name2 = new FrequentFlyerName("Ambika", "", "Brown");
      FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(null, name2, email, milesBalance);
    });
  }

  @Test
  void testEquals_Param3() throws InvalidCustomerException {
    FrequentFlyerCustomer dupFlyerCustomer = new FrequentFlyerCustomer(accountID, name, null, milesBalance);
    assertFalse(flyerCustomer.equals(dupFlyerCustomer));
  }

  @Test
  void testHashCode() {
    Object expectedHashcode = Objects.hash(accountID, name, email, milesBalance);
    assertEquals(expectedHashcode, flyerCustomer.hashCode());
  }

  @Test
  void testToString() {
    String expString = "FrequentFlyerCustomer{" +
        "accountID='" + accountID + '\'' +
        ", name=" + name.toString() +
        ", email='" + email + '\'' +
        ", milesBalance=" + milesBalance.toString() +
        '}';
    assertEquals(expString, flyerCustomer.toString());
  }

  @Test
  void depositMilesBalanceMinBalanceException() {
    Deposit deposit = new Deposit(100, "12345", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.depositMilesBalance(deposit.getDepositAmount());
    });
  }

  @Test
  void depositMilesBalanceMaxBalanceException() {
    Deposit deposit = new Deposit(100000, "12345", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.depositMilesBalance(deposit.getDepositAmount());
    });
  }

  @Test
  void depositMilesBalance() {
    Deposit deposit = new Deposit(1100, "abcdefabcdef", name);
    assertDoesNotThrow(() -> {
      flyerCustomer.depositMilesBalance(deposit.getDepositAmount());
    });
  }

  @Test
  void withdrawMilesBalance() {
    Deposit deposit = new Deposit(1100, "12345", name);
    flyerCustomer.withdrawMilesBalance(deposit.getDepositAmount());
  }

  @Test
  void withdrawMilesBalanceInvalidBalance() {
    Deposit deposit = new Deposit(-100, "12345", name);
    flyerCustomer.withdrawMilesBalance(deposit.getDepositAmount());
  }

  @Test
  void transferMilesInvalidAmount() {
    Deposit deposit = new Deposit(100000, "12345", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.transferMiles(deposit);
    });
  }

  @Test
  void transferMilesMinBalanceNoRecipientID() {
    Deposit deposit = new Deposit(1100, null, name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.transferMiles(deposit);
    });
  }

  @Test
  void transferMilesMinBalanceNoRecipientName() {
    Deposit deposit = new Deposit(11000, "abcedf", null);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.transferMiles(deposit);
    });
  }

  @Test
  void transferMilesMinBalanceInvalidAmount() {
    Deposit deposit = new Deposit(12000, "abcdefabcdef", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.transferMiles(deposit);
    });
  }

  @Test
  void hasCustomerAmountTest() {
    Deposit deposit = new Deposit(null, "abcdefabcdef", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer.transferMiles(deposit);
    });
  }

  @Test
  void hasCustomerAmountNoMiles() {
    Deposit deposit = new Deposit(null, "abcdefabcdef", name);
    assertThrows(InvalidDepositException.class, () -> {
      FrequentFlyerCustomer flyerCustomer1 = new FrequentFlyerCustomer(accountID, name, email, null);
      flyerCustomer1.updateCustomer(flyerCustomer1);
      flyerCustomer1.transferMiles(deposit);
    });
  }

  @Test
  void testValidateDepositLessAmount() {
    FrequentFlyerCustomer flyerCustomer1 = new FrequentFlyerCustomer(accountID, name, email, new MilesBalance(500,0, 0));
    flyerCustomer1.updateCustomer(flyerCustomer1);
    Deposit deposit = new Deposit(500, "abcdefabcdef", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer1.transferMiles(deposit);
    });
  }

  @Test
  void testValidateDepositMoreAmount() {
    FrequentFlyerCustomer flyerCustomer1 = new FrequentFlyerCustomer(accountID, name, email, new MilesBalance(50000,0, 0));
    flyerCustomer1.updateCustomer(flyerCustomer1);
    Deposit deposit = new Deposit(50000, "abcdefabcdef", name);
    assertThrows(InvalidDepositException.class, () -> {
      flyerCustomer1.transferMiles(deposit);
    });
  }

  @Test
  void transferMiles() {
    Deposit deposit = new Deposit(1100, "abcdefabcdef", name);
    flyerCustomer.transferMiles(deposit);
  }
}