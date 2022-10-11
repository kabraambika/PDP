package assignment1.problem2;

import java.util.Objects;

/**
 * Child class of Vessel, named as VesselBoat
 * @author Ambika Kabra, kabraambika19
 */
public class VesselBoat extends Vessel{
  private Float boatLength;
  private Integer passengerNum;
  private PropulsionType propulsionType;

  /**
   * VesselBoat constructor
   * @param vehicleID a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel represented as a MakeModel
   * @param msrp Manufacturer Suggested Retail Price, represented as a Double
   * @param boatLength boat length, represented as a Float
   * @param passengerNum represented as an Integer
   * @param propulsionType represented as an PropulsionType, a custom enumeration
   */
  public VesselBoat(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp, Float boatLength, Integer passengerNum, PropulsionType propulsionType) {
    super(vehicleID, manufactureYr, makeModel, msrp);
    this.boatLength = boatLength;
    this.passengerNum = passengerNum;
    this.propulsionType = propulsionType;
  }

  /**
   * Get boat length, represented as a Float
   * @return this.boatLength
   */
  public Float getBoatLength() {
    return this.boatLength;
  }

  /**
   * Get number of passengers, represented as an Integer
   * @return this.passengerNum
   */
  public Integer getPassengerNum() {
    return this.passengerNum;
  }

  /**
   * Get propulsion type, represented as an PropulsionType, possible value: Sail Power, Inboard Engine,
   * Outboard Engine, Jet Propulsion.
   * @return this.propulsionType;
   */
  public PropulsionType getPropulsionType() {
    return this.propulsionType;
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
    VesselBoat vesselBoat = (VesselBoat) obj;
    return Objects.equals(getBoatLength(), vesselBoat.getBoatLength()) && Objects.equals(
        getPassengerNum(), vesselBoat.getPassengerNum()) && getPropulsionType() == vesselBoat.getPropulsionType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBoatLength(), getPassengerNum(), getPropulsionType());
  }

  @Override
  public String toString() {
    return "VesselBoat{" +
        "boatLength=" + getBoatLength() +
        ", passengerNum=" + getPassengerNum() +
        ", propulsionType=" + getPropulsionType() +
        '}';
  }
}
