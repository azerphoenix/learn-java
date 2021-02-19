package info.md7.java.lessons.patterns.creational;

import info.md7.java.lessons.patterns.creational.factory.AudiFactory;
import info.md7.java.lessons.patterns.creational.factory.Car;
import info.md7.java.lessons.patterns.creational.factory.CarFactory;
import info.md7.java.lessons.patterns.creational.factory.MercedesFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactoryTest {

  @Test
  void testMercedes() {
    CarFactory carFactory = new MercedesFactory();
    Car car = carFactory.createCar();
    Assertions.assertEquals("Mercedes is running", car.drive() );
  }

  @Test
  void testAudi() {
    CarFactory carFactory = new AudiFactory();
    Car car = carFactory.createCar();
    Assertions.assertEquals("Audi is running", car.drive() );
  }

}
