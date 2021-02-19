package info.md7.java.homeworks.hw_6.pojo;

import info.md7.java.homeworks.hw_6.enums.State;
import info.md7.java.homeworks.hw_6.enums.TransportType;
import info.md7.java.homeworks.hw_6.interfaces.Movable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Transport implements Movable, Serializable {

  protected String name;
  protected String num;
  protected String color;
  protected Date dateOfIssue;
  protected TransportType transportType;
  protected State state;
  protected Double price;

  public Transport() {
    this.state = State.STOPPED;
  }

  public Transport(String name, String num, String color, Date dateOfIssue,
      TransportType transportType, Double price) {
    this.name = name;
    this.num = num;
    this.color = color;
    this.dateOfIssue = dateOfIssue;
    this.transportType = transportType;
    this.price = price;
    this.state = State.STOPPED;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getDateOfIssue() {
    String pattern = "dd-MM-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return simpleDateFormat.format(dateOfIssue);
  }

  public void setDateOfIssue(Date dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  public TransportType getTransportType() {
    return transportType;
  }

  public void setTransportType(TransportType transportType) {
    this.transportType = transportType;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transport transport = (Transport) o;
    return Objects.equals(name, transport.name) &&
        Objects.equals(num, transport.num) &&
        Objects.equals(color, transport.color) &&
        Objects.equals(dateOfIssue, transport.dateOfIssue) &&
        transportType == transport.transportType &&
        state == transport.state;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, num, color, dateOfIssue, transportType, state);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Transport: ").append("\t");
    stringBuilder.append("name: ").append(name).append(", ");
    stringBuilder.append("num: ").append(num).append(", ");
    stringBuilder.append("color: ").append(color).append(", ");
    stringBuilder.append("dateOfIssue: ").append(getDateOfIssue()).append(", ");
    stringBuilder.append("transportType: ").append(transportType).append(", ");
    stringBuilder.append("price: ").append(price).append(", ");
    stringBuilder.append("state: ").append(state);
    return stringBuilder.toString();
  }

}
