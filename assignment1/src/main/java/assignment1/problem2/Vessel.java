package assignment1.problem2;

/**
 * Kind of Vehicle, Vessel, extends AbstractVehicle
 */
public class Vessel extends AbstractVehicle{

  /**
   * @param vehicleID a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel represented as a MakeModel
   * @param msrp Manufacturer Suggested Retail Price, represented as a Double
   */
  public Vessel(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp) {
    super(vehicleID, manufactureYr, makeModel, msrp);
  }
}