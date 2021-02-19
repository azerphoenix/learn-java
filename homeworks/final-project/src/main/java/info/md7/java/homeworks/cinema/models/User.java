package info.md7.java.homeworks.cinema.models;


import info.md7.java.homeworks.cinema.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;
  private String username;
  @Column(length = 5000)
  private String password;
  private Double amountOfMoney;
  @Enumerated(EnumType.STRING)
  private Role role;
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Ticket> tickets = new ArrayList<>();
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Log> logs = new ArrayList<>();

  public void setTickets(List<Ticket> tickets) {
    if (tickets != null && !tickets.isEmpty()) {
      tickets.forEach(ticket -> ticket.setUser(this));
    }
    this.tickets = tickets;
  }

  public void setLogs(List<Log> logs) {
    if (logs != null && !logs.isEmpty()) {
      logs.forEach(log -> log.setUser(this));
    }
    this.logs = logs;
  }

}
