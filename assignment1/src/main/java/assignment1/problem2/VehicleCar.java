package assignment1.problem2;

/**
 * VehicleCar, System recognises this as a kind of vehicle
 * @author Ambika Kabra, kabraambika19
 */
public class VehicleCar extends AbstractVehicle{

  /**
   * @param vehicleID a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel represented as a MakeModel, a custom class
   * @param msrp Manufacturer Suggested Retail Price, represented as a Double
   */
  public VehicleCar(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp) {
    super(vehicleID, manufactureYr, makeModel, msrp);
  }
}
