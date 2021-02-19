package info.md7.java.homeworks.hw_5.enums;

public enum TransportType {

  WATER_TRANSPORT ("водный транспорт"),
  AIR_TRANSPORT ("воздушный транспорт"),
  SPACE_TRANSPORT ("космический транспорт"),
  LAND_TRANSPORT ("наземный транспорт");

  public String name;

  TransportType(String name) {
    this.name = name;
  }

}
