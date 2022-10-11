package assignment1.problem1;
import java.util.Objects;

/**
 * Deposit consists of:
 * Deposit amount that is in the range [1000 to 10000] miles.
 * The information about the recipient unique account ID, and their name.
 * @author Ambika Kabra, kabraambika19
 */
public class Deposit {
  private Integer depositAmount;
  private String recipientAccID;
  private FrequentFlyerName recipientAccName;

  /**
   * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
   * @param recipientAccID unique account ID of recipient
   * @param recipientAccName name of recipient
   */
  public Deposit(Integer depositAmount, String recipientAccID, FrequentFlyerName recipientAccName) {
    this.depositAmount = depositAmount;
    this.recipientAccID = recipientAccID;
    this.recipientAccName = recipientAccName;
  }

  /**
   * @return this.depositAmount
   */
  public Integer getDepositAmount() {
    return this.depositAmount;
  }

  /**
   * @return this.recipientAccID
   */
  public String getRecipientAccID() {
    return this.recipientAccID;
  }

  /**
   * @return this.recipientAccName
   */
  public FrequentFlyerName getRecipientAccName() {
    return this.recipientAccName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) obj;
    return Objects.equals(getDepositAmount(), deposit.getDepositAmount())
        && Objects.equals(getRecipientAccID(), deposit.getRecipientAccID())
        && Objects.equals(getRecipientAccName(), deposit.getRecipientAccName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDepositAmount(), getRecipientAccID(), getRecipientAccName());
  }

  @Override
  public String toString() {
    return "Deposit{" +
        "depositAmount=" + getDepositAmount() +
        ", recipientAccID='" + getRecipientAccID() + '\'' +
        ", recipientAccName=" + getRecipientAccName() +
        '}';
  }
}
