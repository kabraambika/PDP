package assignment1.problem1;

/**
 * This interface contains all the operations which frequent flyer customer can do in the frequent flyer system
 */
public interface IFrequentFlyer {

 /**
  * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
  */
 void depositMilesBalance(Integer depositAmount);
 /**
  * @param depositAmount Deposit amount that is in the range [1000 to 10000] miles
  */
 void withdrawMilesBalance(Integer depositAmount);

 /**
  * @param deposit Deposit consists of:
  *                Deposit amount that is in the range [1000 to 10000] miles.
  *                The information about the recipient unique account ID, and their name.
  */
 void transferMiles(Deposit deposit) throws InvalidDepositException;
}
