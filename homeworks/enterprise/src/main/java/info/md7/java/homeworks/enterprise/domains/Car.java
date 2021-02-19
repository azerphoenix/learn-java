package info.md7.java.homeworks.enterprise.domains;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

  private Long id;
  private String model;
  private Timestamp guaranteeExpirationDate;
  private Double price;
  private Long dealerId;
  private Long userId;
  private int year;
  private String country;

}
