package assignment1.problem2;

import org.junit.jupiter.api.BeforeEach;

class VehicleCarTest {

  VehicleCar vehicleCar;
  MakeModel makeModel;

  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("2010", "Sedan");
    vehicleCar = new VehicleCar("abcdef", 2015, makeModel, 2500.0);
  }
}