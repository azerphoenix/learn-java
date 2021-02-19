package info.md7.java.homeworks.hw_5.enums;

public enum CarBodyType {

  SEDAN ("седан"),
  STATION_WAGON ("универсал"),
  HATCHBACK ("хэтчбек"),
  COUPE ("купе"),
  LIMOUSINE ("лимузин"),
  MINIVAN ("минивэн"),
  CABRIOLET ("кабриолет");

  public String carBodyType;

  CarBodyType(String carBodyType) {
    this.carBodyType = carBodyType;
  }

}
