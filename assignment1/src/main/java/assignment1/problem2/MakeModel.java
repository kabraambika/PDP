package assignment1.problem2;

import java.util.Objects;

/**
 * A custom class that keeps track of vehicle model and vehicle make
 * @author Ambika kabra, ambikakabra19
 */
public class MakeModel {
  private String vehicleMake;
  private String vehicleModel;

  /**
   * @param vehicleMake vehicle make, represented as a String
   * @param vehicleModel vehicle model, represented as a String
   */
  public MakeModel(String vehicleMake, String vehicleModel) {
    this.vehicleMake = vehicleMake;
    this.vehicleModel = vehicleModel;
  }

  /**
   * Get vehicle make, represented as a String
   * @return this.vehicleMake
   */
  public String getVehicleMake() {
    return this.vehicleMake;
  }

  /**
   * Get vehicle model, represented as a String
   * @return this.vehicleModel
   */
  public String getVehicleModel() {
    return this.vehicleModel;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MakeModel makeModel = (MakeModel) obj;
    return Objects.equals(getVehicleMake(), makeModel.getVehicleMake()) && Objects.equals(
        getVehicleModel(), makeModel.getVehicleModel());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicleMake(), getVehicleMake());
  }

  @Override
  public String toString() {
    return "MakeModel{" +
        "vehicleMake='" + getVehicleMake() + '\'' +
        ", vehicleModel='" + getVehicleModel() + '\'' +
        '}';
  }
}
