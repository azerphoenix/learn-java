package info.md7.java.homeworks.hw_5.enums;

public enum State {

  MOVING ("движется"),
  STOPS ("останавливается"),
  STOPPED ("остановлен");

  public String state;

  State(String state) {
    this.state = state;
  }

}
