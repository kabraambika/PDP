package assignment1.problem2;

import java.util.Objects;

/**
 * UsedCar a kind of car, extends VehicleCar
 * @author Ambika kabra, kabraambika19
 */
public class UsedCar extends VehicleCar {
  private Integer mileage;
  private Integer numPrevOwner;
  private Integer numOfAccident;
  /**
   * @param vehicleID              a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel       represented as a MakeModel, a custom class
   * @param msrp            Manufacturer Suggested Retail Price, represented as a Double
   * @param mileage         represented as an Integer
   * @param numPrevOwner number of previous owners, represented as an Integer
   * @param numOfAccident the vehicle was involved in, represented as
   * an Integer
   */
  public UsedCar(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp, Integer mileage, Integer numPrevOwner, Integer numOfAccident) {
    super(vehicleID, manufactureYr, makeModel, msrp);
    this.mileage = mileage;
    this.numPrevOwner = numPrevOwner;
    this.numOfAccident = numOfAccident;
  }

  /**
   * @return this.mileage
   */
  public Integer getMileage() {
    return this.mileage;
  }

  /**
   * @return this.numPrevOwner
   */
  public Integer getNumPrevOwner() {
    return this.numPrevOwner;
  }

  /**
   * @return this.numOfAccident
   */
  public Integer getNumOfAccident() {
    return this.numOfAccident;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    UsedCar usedCar = (UsedCar) obj;
    return Objects.equals(getMileage(), usedCar.getMileage()) && Objects.equals(
        getNumPrevOwner(), usedCar.getNumPrevOwner()) && Objects.equals(getNumOfAccident(),
        usedCar.getNumOfAccident());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMileage(), getNumPrevOwner(), getNumOfAccident());
  }

  @Override
  public String toString() {
    return "UsedCar{" +
        "mileage=" + getMileage() +
        ", numPrevOwner=" + getNumPrevOwner() +
        ", numOfAccident=" + getNumOfAccident() +
        '}';
  }
}
