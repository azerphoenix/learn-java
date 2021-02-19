package info.md7.java.homeworks.hw_5.pojo;


import info.md7.java.homeworks.hw_5.enums.BoatBrand;
import info.md7.java.homeworks.hw_5.enums.State;
import info.md7.java.homeworks.hw_5.enums.TransportType;
import java.util.Date;
import java.util.Objects;

public class Boat extends Transport {

  private BoatBrand boatBrand;

  public Boat() {}

  public Boat(String name, String num, String color, Date dateOfIssue,
      TransportType transportType, BoatBrand boatBrand) {
    super(name, num, color, dateOfIssue, transportType);
    this.boatBrand = boatBrand;
  }

  public void ranAground() {
    super.setState(State.STOPPED);
    System.out.println("Лодка села на мель. Состояние лодки: " + getState().state);
  }

  @Override
  public void move() {
    super.setState(State.MOVING);
    System.out.println("Лодка плывет. Состояние лодки: " + getState().state);
  }

  @Override
  public void stop() {
    super.setState(State.STOPPED);
    System.out.println("Лодка остановилась. Состояние лодки: " + getState().state);
  }

  public BoatBrand getBoatBrand() {
    return boatBrand;
  }

  public void setBoatBrand(BoatBrand boatBrand) {
    this.boatBrand = boatBrand;
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
    Boat boat = (Boat) o;
    return boatBrand == boat.boatBrand;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), boatBrand);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Boat: ").append("\t");
    stringBuilder.append("boatBrand: ").append(boatBrand).append(", ");
    stringBuilder.append("name: ").append(name).append(", ");
    stringBuilder.append("num: ").append(num).append(", ");
    stringBuilder.append("color: ").append(color).append(", ");
    stringBuilder.append("dateOfIssue: ").append(getDateOfIssue()).append(", ");
    stringBuilder.append("transportType: ").append(transportType).append(", ");
    stringBuilder.append("state: ").append(state);
    return stringBuilder.toString();
  }
}
