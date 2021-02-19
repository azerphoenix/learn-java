package info.md7.java.homeworks.hw_5;


import info.md7.java.homeworks.hw_5.enums.BoatBrand;
import info.md7.java.homeworks.hw_5.enums.CarBodyType;
import info.md7.java.homeworks.hw_5.enums.CarBrand;
import info.md7.java.homeworks.hw_5.enums.PlaneBrand;
import info.md7.java.homeworks.hw_5.enums.TransportType;
import info.md7.java.homeworks.hw_5.interfaces.Movable;
import info.md7.java.homeworks.hw_5.pojo.Boat;
import info.md7.java.homeworks.hw_5.pojo.Car;
import info.md7.java.homeworks.hw_5.pojo.Plane;
import info.md7.java.homeworks.hw_5.pojo.Transport;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    Car car1 = new Car("Car 1", "1234AB-1", "#ff0000", new Date(),
        TransportType.LAND_TRANSPORT, CarBodyType.SEDAN, CarBrand.AUDI);
    System.out.println(car1);
    car1.move();
    car1.slowDown();
    car1.stop();

    Plane plane1 = new Plane("Plane 1", "ABC 123", "#ffffff", new Date(),
        TransportType.AIR_TRANSPORT, PlaneBrand.AIRBUS);
    System.out.println(plane1);
    plane1.takesOff();
    plane1.move();
    plane1.landing();
    plane1.stop();

    Boat boat1 = new Boat("Boat 1", "AAA 123", "#ff0000", new Date(),
        TransportType.WATER_TRANSPORT, BoatBrand.MASTERCRAFT);
    System.out.println(boat1);
    boat1.move();
    boat1.stop();
    boat1.ranAground();

    Movable movable1 = new Car("Car 2", "1234AC-2", "#000000", new Date(),
        TransportType.LAND_TRANSPORT, CarBodyType.CABRIOLET, CarBrand.MERCEDES);
    System.out.println(movable1);

    Transport transport1 = new Plane("Plane 2", "ACC 345", "#CCCCCC", new Date(),
        TransportType.AIR_TRANSPORT, PlaneBrand.BOEING);
    System.out.println(transport1);

  }

}
