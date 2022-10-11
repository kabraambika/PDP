package assignment1.problem2;

import org.junit.jupiter.api.BeforeEach;

class VesselTest {

  Vessel vessel;
  MakeModel makeModel;
  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("2010", "BMW");
    vessel = new Vessel("abcdef", 2015, makeModel, 2500.0);
  }
}