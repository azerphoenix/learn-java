package info.md7.java.homeworks.hw_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("Car X", "#ff0000", LocalDate.now(), 25_000d, CarBrand.MERCEDES));
    cars.add(new Car("Car Y", "#000000", LocalDate.now(), 25_000d, CarBrand.AUDI));
    cars.add(new Car("Car Z", "#ffffff", LocalDate.now(), 25_000d, CarBrand.TESLA));
    Store<Car> carStore = new Store<>(cars);
    Producer producer = new Producer(carStore);
    Thread producerThread = new Thread(producer);
    producerThread.start();
    Consumer consumer = new Consumer(carStore);
    Thread consumerThread = new Thread(consumer);
    consumerThread.start();
    System.out.println("Consumer thread: " + producerThread.getState());
    System.out.println("Producer thread: " + consumerThread.getState());
    System.out.println("Consumer thread: " + producerThread.isAlive());
    System.out.println("Producer thread: " + consumerThread.isAlive());
  }

}
