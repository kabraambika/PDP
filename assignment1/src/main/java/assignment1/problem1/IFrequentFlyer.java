package assignment1.problem1;

/**
 * This interface contains all the operations which frequent flyer customer can do in the frequent flyer system
 */
public interface IFrequentFlyer {

 /**
  * Deposit miles balance in recipient miles balance
  * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
  */
 void depositMilesBalance(Integer depositAmount);
 /**
  * withdraw miles balance from sender miles balance
  * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
  */
 void withdrawMilesBalance(Integer depositAmount);

 /**
  * transfer miles balance from sender to recipient with given inputs
  * @param deposit Deposit consists of:
  *                Deposit amount that is in the range [1000 to 10000] miles.
  *                The information about the recipient unique account ID, and their name.
  * @throws InvalidDepositException if deposit is null or sender is not depositing amount in range or doesn't has amount,
  *                                 exception will be thrown
  */
 void transferMiles(Deposit deposit) throws InvalidDepositException;
}
