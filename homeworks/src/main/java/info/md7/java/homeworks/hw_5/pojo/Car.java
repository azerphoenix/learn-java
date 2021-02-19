package info.md7.java.homeworks.hw_5.pojo;


import info.md7.java.homeworks.hw_5.enums.CarBodyType;
import info.md7.java.homeworks.hw_5.enums.CarBrand;
import info.md7.java.homeworks.hw_5.enums.State;
import info.md7.java.homeworks.hw_5.enums.TransportType;
import java.util.Date;
import java.util.Objects;

public class Car extends Transport {

  private CarBodyType carBodyType;
  private CarBrand carBrand;

  public Car() {}

  public Car(String name, String num, String color, Date dateOfIssue, TransportType transportType,
      CarBodyType carBodyType, CarBrand carBrand) {
    super(name, num, color, dateOfIssue, transportType);
    this.carBodyType = carBodyType;
    this.carBrand = carBrand;
  }

  public void slowDown() {
    super.setState(State.STOPS);
    System.out.println("Машина тормозит. Состояние машины: " + getState().state);
  }

  @Override
  public void move() {
    super.setState(State.MOVING);
    System.out.println("Машина едет. Состояние машины: " + getState().state);
  }

  @Override
  public void stop() {
    super.setState(State.STOPPED);
    System.out.println("Машина остановилась. Состояние машины: " + getState().state);
  }

  public CarBodyType getCarBodyType() {
    return carBodyType;
  }

  public void setCarBodyType(CarBodyType carBodyType) {
    this.carBodyType = carBodyType;
  }

  public CarBrand getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(CarBrand carBrand) {
    this.carBrand = carBrand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Car car = (Car) o;
    return carBodyType == car.carBodyType &&
        carBrand == car.carBrand;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), carBodyType, carBrand);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Car: ").append("\t");
    stringBuilder.append("carBodyType: ").append(carBodyType).append(", ");
    stringBuilder.append("carBrand: ").append(carBrand).append(", ");
    stringBuilder.append("name: ").append(name).append(", ");
    stringBuilder.append("num: ").append(num).append(", ");
    stringBuilder.append("color: ").append(color).append(", ");
    stringBuilder.append("dateOfIssue: ").append(getDateOfIssue()).append(", ");
    stringBuilder.append("transportType: ").append(transportType).append(", ");
    stringBuilder.append("state: ").append(state);
    return stringBuilder.toString();
  }

}
