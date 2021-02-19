package info.md7.java.homeworks.hw_9.store;


import info.md7.java.homeworks.hw_9.pojo.Car;
import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

  private Store<Car> store;
  private Double balance = 100_000d;
  private List<Car> cars;

  public Consumer(Store<Car> store) {
    this.store = store;
    this.cars = new ArrayList<>();
  }

  @Override
  public void run() {
    while (balance > 0) {
      store.get(0, 25_000, this);
      System.out.println("Ваш баланс составляет: " + balance);
    }
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

}
