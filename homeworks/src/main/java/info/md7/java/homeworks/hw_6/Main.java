package info.md7.java.homeworks.hw_6;


import info.md7.java.homeworks.hw_6.enums.CarBodyType;
import info.md7.java.homeworks.hw_6.enums.CarBrand;
import info.md7.java.homeworks.hw_6.enums.FuelType;
import info.md7.java.homeworks.hw_6.enums.TankMaterial;
import info.md7.java.homeworks.hw_6.enums.TransportType;
import info.md7.java.homeworks.hw_6.pojo.Car;
import info.md7.java.homeworks.hw_6.pojo.Car.GasTank;
import info.md7.java.homeworks.hw_6.store.Store;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    Car[] cars = new Car[] {
        new Car("Car 1", "1234AB-1", "#ff0000", new Date(),
            TransportType.LAND_TRANSPORT, CarBodyType.SEDAN, CarBrand.AUDI, 25_000,
            new GasTank(1500, TankMaterial.ALUMINIUM, "#000000", FuelType.PETROL)),
        new Car("Car 2", "4567AC-1", "#000000", new Date(),
            TransportType.LAND_TRANSPORT, CarBodyType.SEDAN, CarBrand.MERCEDES, 60_000,
            new GasTank(2000, TankMaterial.STEEL, "#000000", FuelType.GAS)),
        new Car("Car 3", "9999DC-1", "#ffffff", new Date(),
            TransportType.LAND_TRANSPORT, CarBodyType.SEDAN, CarBrand.TESLA, 75_000),
        new Car("Car 4", "1342DC-1", "#0000ff", new Date(),
            TransportType.LAND_TRANSPORT, CarBodyType.SEDAN, CarBrand.TOYOTA, 75_000,
            new GasTank(1300, TankMaterial.ALUMINIUM, "#ff0000", FuelType.PETROL))
    };

    Store<Car> carStore = new Store<>(cars);

    carStore.printProducts();
    Car myNewCar = carStore.purchase(0, 25_000);
    System.out.println("Сумма в кассе: " + carStore.getAmountOfMoney() +"\n");

    carStore.printProducts();
    carStore.purchase(1, 25_000);
    System.out.println("Сумма в кассе: " + carStore.getAmountOfMoney() +"\n");

    carStore.printProducts();
    carStore.purchase(2, 10_000);
    System.out.println("Сумма в кассе: " + carStore.getAmountOfMoney() +"\n");

    carStore.printProducts();
    carStore.sell(myNewCar, 27_000);

    carStore.sell(myNewCar, 25_000);
    carStore.printProducts();
  }

}
