package assignment2.problem1.pickupOrder;

public class QuantityExceededException extends RuntimeException{

  public QuantityExceededException(String errorMessage) {
    super(errorMessage);
  }
}
