package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.flyweight.Vehicle;
import info.md7.java.lessons.patterns.structural.flyweight.VehicleFactory;
import java.awt.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlyWeightTest {

  @Test
  void flyweightTest() {
    Vehicle vehicle = VehicleFactory.createVehicle(Color.BLACK);
    Vehicle vehicle1 = VehicleFactory.createVehicle(Color.BLACK);
    Assertions.assertEquals(vehicle, vehicle1);
  }

}
