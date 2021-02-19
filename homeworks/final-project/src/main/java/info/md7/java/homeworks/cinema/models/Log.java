package info.md7.java.homeworks.cinema.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_logs")
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long logId;
  @Column(length = 1000)
  private String message;
  @Column(updatable = false)
  private LocalDateTime dateTime;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

}
