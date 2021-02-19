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
public class User {

  private Long id;
  private String name;
  private String surname;
  private Date birthDate;
  private String login;
  private String password;
  @Builder.Default
  private Gender gender = Gender.NOT_SELECTED;
  private Timestamp created;
  private Timestamp changed;
  @Builder.Default
  private Boolean isBlocked = false;
  private Float weight;
  private String country;

}
