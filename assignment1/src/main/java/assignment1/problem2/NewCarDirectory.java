package assignment1.problem2;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a singleton class
 * Registes all new cars in Map of this class
 */
public class NewCarDirectory {

  /**
   * Stores map of new cars by key as car ID and NewCar object
   */
  private Map<String, NewCar> newCarMap = new HashMap<>();

  /**
   * Static variable reference of type NewCarDirectory
   */
  private static NewCarDirectory carDirectory;

  /**
   * To make this class Singleton, Constructor
   * Here we will be creating private constructor restricted to this class itself
   */
  private NewCarDirectory() {}

  /**
   * Static method to create instance of Singleton class
   * @return Instance of NewCarDirectory
   */
  public static NewCarDirectory getInstance(){
    if(carDirectory == null) {
      carDirectory = new NewCarDirectory();
    }
    return carDirectory;
  }

  /**
   * Add new car to the directory
   * @param newCar Instance of NewCar
   */
  protected void updateDirectory(NewCar newCar) {
    newCarMap.put(newCar.getVehicleID(), newCar);
  }

  /**
   * Get the track of all the new Car available in directory
   * @return size of the map keeping track of new Cars
   */
  protected Integer getDirectorySize() {
    return this.newCarMap.size();
  }
}