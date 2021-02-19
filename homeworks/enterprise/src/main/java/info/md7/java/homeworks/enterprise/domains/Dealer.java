package info.md7.java.homeworks.enterprise.domains;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dealer {

  private Long id;
  private String name;
  private String address;
  private int capacity;
  private Timestamp created;
  private Timestamp changed;
  private Date yearOfFoundation;
  private String country;

}
