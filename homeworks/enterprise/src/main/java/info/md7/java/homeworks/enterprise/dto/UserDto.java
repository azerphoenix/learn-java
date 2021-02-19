package info.md7.java.homeworks.enterprise.dto;


import info.md7.java.homeworks.enterprise.domains.Gender;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

  private String name;
  private String surname;
  private String login;
  private String password;
  private Gender gender;
  private String country;
  private Date birthDate;
  private Float weight;
}
