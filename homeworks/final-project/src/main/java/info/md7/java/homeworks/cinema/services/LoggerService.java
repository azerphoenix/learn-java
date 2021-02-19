package info.md7.java.homeworks.cinema.services;


import info.md7.java.homeworks.cinema.db.HibernateUtil;
import info.md7.java.homeworks.cinema.models.Log;
import info.md7.java.homeworks.cinema.models.User;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;

public class LoggerService {

  /**
   * Метод для добавления сообщения (лога) для текущего пользователя
   * @param message сообщение (лог)
   */
  public static void addMessage(String message) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Log log = new Log();
    log.setMessage(message);
    log.setDateTime(LocalDateTime.now());
    log.setUser(UserService.getCurrentUser());
    session.save(log);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Метод для добавления сообщения (лога) для указанного пользователя
   * @param message сообщение (лог)
   * @param target пользователь
   */
  public static void addMessage(String message, User target) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Log log = new Log();
    log.setMessage(message);
    log.setDateTime(LocalDateTime.now());
    log.setUser(target);
    session.save(log);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Получить логи выбранного пользователя
   * @param user пользователь
   * @return List\<Log\>
   */
  public static List<Log> getLogs(User user) {
    User userFromDb = UserService.getUserById(user.getUserId());
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    List<Log> logs = userFromDb.getLogs();
    session.close();
    return logs;
  }

}
