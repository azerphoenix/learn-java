package info.md7.java.homeworks.enterprise.dto;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DealerDto {

  private String name;
  private String address;
  private int capacity;
  private Date yearOfFoundation;
  private String country;

}
