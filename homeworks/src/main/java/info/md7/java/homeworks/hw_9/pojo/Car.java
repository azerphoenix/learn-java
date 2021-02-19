package info.md7.java.homeworks.hw_9.pojo;


import info.md7.java.homeworks.hw_9.enums.CarBrand;
import java.time.LocalDate;

public class Car extends Transport{

  private CarBrand carBrand;

  public Car(String name, String color, LocalDate dateOfIssue, Double price, CarBrand carBrand) {
    super(name, color, dateOfIssue, price);
    this.carBrand = carBrand;
  }

  public CarBrand getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(CarBrand carBrand) {
    this.carBrand = carBrand;
  }

  @Override
  public String toString() {
    return String.format("Название автомобиля: %s \nЦвет: %s \n"
        + "Дата выпуска: %s \nСтоимость: %s \nБренд: %s \n%s",
        name, color, dateOfIssue, price, carBrand, System.lineSeparator());
  }

}
