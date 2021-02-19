package info.md7.java.homeworks.enterprise.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDto {

  private String model;
  private Double price;
  private int year;
  private String country;

}
