package info.md7.java.homeworks.cinema.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long movieId;
  private String movieTitle;
  private LocalDateTime startDateTime;
  @OneToMany(mappedBy = "movie", orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Ticket> tickets = new ArrayList<>();

  public void setTickets(List<Ticket> tickets) {
    if (tickets != null && !tickets.isEmpty()) {
      tickets.forEach(ticket -> ticket.setMovie(this));
    }
    this.tickets = tickets;
  }

}
