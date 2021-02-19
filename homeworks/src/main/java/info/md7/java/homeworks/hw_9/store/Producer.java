package info.md7.java.homeworks.hw_9.store;

import info.md7.java.homeworks.hw_9.enums.CarBrand;
import info.md7.java.homeworks.hw_9.pojo.Car;
import java.time.LocalDate;

public class Producer implements Runnable {

  private Store<Car> store;

  public Producer(Store<Car> store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 0; i <= 3; i++) {
      Car car = new Car("Car " + i, "#ffffff", LocalDate.now(), 25_000d, CarBrand.TOYOTA);
      store.put(car);
      System.out.println("Новое поступление в магазин: " + car.getName());
    }
  }

}