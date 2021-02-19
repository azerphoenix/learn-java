package info.md7.java.homeworks.hw_5.pojo;


import info.md7.java.homeworks.hw_5.enums.PlaneBrand;
import info.md7.java.homeworks.hw_5.enums.State;
import info.md7.java.homeworks.hw_5.enums.TransportType;
import java.util.Date;
import java.util.Objects;

public class Plane extends Transport {

  private PlaneBrand planeBrand;

  public Plane() {}

  public Plane(String name, String num, String color, Date dateOfIssue,
      TransportType transportType, PlaneBrand planeBrand) {
    super(name, num, color, dateOfIssue, transportType);
    this.planeBrand = planeBrand;
  }

  public void takesOff() {
    super.setState(State.MOVING);
    System.out.println("Самолет взлетает. Состояние самолета: " + getState().state);
  }

  public void landing() {
    super.setState(State.STOPS);
    System.out.println("Самолет приземляется. Состояние самолета: " + getState().state);
  }

  @Override
  public void move() {
    super.setState(State.MOVING);
    System.out.println("Самолет летит. Состояние самолета: " + getState().state);
  }

  @Override
  public void stop() {
    super.setState(State.STOPPED);
    System.out.println("Самолет приземлился. Состояние самолета: " + getState().state);
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
    Plane plane = (Plane) o;
    return planeBrand == plane.planeBrand;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), planeBrand);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Plane: ").append("\t");
    stringBuilder.append("planeBrand: ").append(planeBrand).append(", ");
    stringBuilder.append("name: ").append(name).append(", ");
    stringBuilder.append("num: ").append(num).append(", ");
    stringBuilder.append("color: ").append(color).append(", ");
    stringBuilder.append("dateOfIssue: ").append(getDateOfIssue()).append(", ");
    stringBuilder.append("transportType: ").append(transportType).append(", ");
    stringBuilder.append("state: ").append(state);
    return stringBuilder.toString();
  }
}
