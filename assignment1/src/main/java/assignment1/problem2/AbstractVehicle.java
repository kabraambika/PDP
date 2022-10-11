package assignment1.problem2;

import java.util.Objects;

/**
 * Abstract class for two type of Vessel and car vehicles
 * @author Ambika Kabra, kabraambika19
 */
public abstract class AbstractVehicle {

  /**
   * a unique identifier of a vehicle, represented as a String
   */
  protected String vehicleID;
  /**
   * a year vehicle was manufactured, represented as an Integer
   */
  protected Integer manufactureYr;
  /**
   * represented as a MakeModel, a custom class consists of vehicle make and vehicle model
   */
  protected MakeModel makeModel;
  /**
   * Manufacturer Suggested Retail Price, represented as a Double
   */
  protected Double msrp;

  /**
   * Constructor of AbstractVehicle
   * @param vehicleID a unique identifier of a vehicle, represented as a String
   * @param manufactureYr a year vehicle was manufactured, represented as an Integer
   * @param makeModel represented as a MakeModel, a custom class consists of vehicle make and vehicle model
   * @param msrp Manufacturer Suggested Retail Price, represented as a Double
   */
  public AbstractVehicle(String vehicleID, Integer manufactureYr, MakeModel makeModel, Double msrp) {
    this.vehicleID = vehicleID;
    this.manufactureYr = manufactureYr;
    this.makeModel = makeModel;
    this.msrp = msrp;
  }

  /**
   * get a unique identifier of a vehicle
   * @return this.vehicleID represented as a String
   */
  public String getVehicleID() {
    return this.vehicleID;
  }

  /**
   * get a year vehicle was manufactured
   * @return this.manufactureYr represented as an Integer
   */
  public Integer getManufactureYr() {
    return this.manufactureYr;
  }

  /**
   * object of MakeModel custom class
   * @return this.makeModel, represented as a MakeModel
   */
  public MakeModel getMakeModel() {
    return this.makeModel;
  }

  /**
   * get Manufacturer Suggested Retail Price
   * @return this.msrp represented as a double
   */
  public Double getMsrp() {
    return this.msrp;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractVehicle that = (AbstractVehicle) obj;
    return Objects.equals(getVehicleID(), that.getVehicleID()) && Objects.equals(getManufactureYr(),
        that.getManufactureYr()) && Objects.equals(getMakeModel(), that.getMakeModel())
        && Objects.equals(getMsrp(), that.getMsrp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicleID(), getManufactureYr(), getMakeModel(), getMsrp());
  }

  @Override
  public String toString() {
    return "AbstractVehicle{" +
        "vehicleID='" + getVehicleID() + '\'' +
        ", manufactureYr=" + getManufactureYr() +
        ", makeModel=" + getMakeModel() +
        ", msrp=" + getMsrp() +
        '}';
  }

}
