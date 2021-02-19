package info.md7.java.homeworks.hw_9.pojo;

import java.time.LocalDate;

public abstract class Transport {

  protected String name;
  protected String color;
  protected LocalDate dateOfIssue;
  protected Double price;

  public Transport(String name, String color, LocalDate dateOfIssue, Double price) {
    this.name = name;
    this.color = color;
    this.dateOfIssue = dateOfIssue;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public LocalDate getDateOfIssue() {
    return dateOfIssue;
  }

  public void setDateOfIssue(LocalDate dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
