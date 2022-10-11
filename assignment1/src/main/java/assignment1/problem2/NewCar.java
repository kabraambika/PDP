package assignment1.problem2;

import java.util.Objects;

/**
 * A type of car vehicle, extends VehicleCar
 * @author Ambika Kabra, kabraambika19
 */
public class NewCar extends VehicleCar {
  private Integer vehicleInRange;

  /**
   * Class variable of type NewCarDirectory
   */
  private NewCarDirectory newCarDirectory;

  /**
   * @param vehicleID a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel represented as a MakeModel
   * @param msrp Manufacturer Suggested Retail Price, represented as a Double
   */
  public NewCar(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp) {
    super(vehicleID, manufactureYr, makeModel, msrp);

    newCarDirectory = NewCarDirectory.getInstance();
    newCarDirectory.updateDirectory(this);

    this.vehicleInRange = newCarDirectory.getDirectorySize();
  }

  /**
   * Get number of available vehicles within 50
   * miles, represented as an Integer
   * @return this.vehicleInRange
   */
  public Integer getVehicleInRange() {
    return this.vehicleInRange;
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
    NewCar newCar = (NewCar) obj;
    return Objects.equals(getVehicleInRange(), newCar.getVehicleInRange());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getVehicleInRange());
  }

  @Override
  public String toString() {
    return "NewCar{" +
        "vehicleInRange=" + getVehicleInRange() +
        '}';
  }
}
