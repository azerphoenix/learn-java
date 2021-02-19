package info.md7.java.homeworks.hw_6.pojo;

import info.md7.java.homeworks.hw_6.enums.CarBodyType;
import info.md7.java.homeworks.hw_6.enums.CarBrand;
import info.md7.java.homeworks.hw_6.enums.FuelType;
import info.md7.java.homeworks.hw_6.enums.State;
import info.md7.java.homeworks.hw_6.enums.TankMaterial;
import info.md7.java.homeworks.hw_6.enums.TransportType;
import java.util.Date;
import java.util.Objects;

public class Car extends Transport {

  private CarBodyType carBodyType;
  private CarBrand carBrand;
  private GasTank gasTank;

  public Car() {}

  public Car(String name, String num, String color, Date dateOfIssue, TransportType transportType,
      CarBodyType carBodyType, CarBrand carBrand, double price, GasTank gasTank) {
    super(name, num, color, dateOfIssue, transportType, price);
    this.carBodyType = carBodyType;
    this.carBrand = carBrand;
    this.gasTank = gasTank;
  }

  public Car(String name, String num, String color, Date dateOfIssue, TransportType transportType,
      CarBodyType carBodyType, CarBrand carBrand, double price) {
    super(name, num, color, dateOfIssue, transportType, price);
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
    stringBuilder.append("price: ").append(price).append(", ");
    stringBuilder.append("state: ").append(state);
    return stringBuilder.toString();
  }

  public static class GasTank {

    private double tankVolume;
    private TankMaterial material;
    private String color;
    private FuelType fuelType;

    public GasTank() {}

    public GasTank(double tankVolume, TankMaterial material, String color,
        FuelType fuelType) {
      this.tankVolume = tankVolume;
      this.material = material;
      this.color = color;
      this.fuelType = fuelType;
    }

    public double getTankVolume() {
      return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
      this.tankVolume = tankVolume;
    }

    public TankMaterial getMaterial() {
      return material;
    }

    public void setMaterial(TankMaterial material) {
      this.material = material;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public FuelType getFuelType() {
      return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
      this.fuelType = fuelType;
    }

  }

}
