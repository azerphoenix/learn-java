package info.md7.java.homeworks.cinema.services;

import de.vandermeer.asciitable.AsciiTable;
import info.md7.java.homeworks.cinema.controllers.MenuController;
import info.md7.java.homeworks.cinema.db.HibernateUtil;
import info.md7.java.homeworks.cinema.enums.Role;
import info.md7.java.homeworks.cinema.models.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.commons.codec.binary.Hex;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserService {

  private static User authUser;
  private static String salt = "@92'.4(Qc*[:*Pg";

  /**
   * Метод создает нового пользователя
   *
   * @param username имя пользователя
   * @param password пароль
   * @param role enum Role роль пользователя
   */
  public static void createUser(String username, String password, Role role) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncryption(password));
    user.setRole(role);
    user.setAmountOfMoney(1000d);
    session.save(user);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Метод для обновления профиля пользователя
   * @param userId id пользователя, профиль которого нужно обновить
   * @param username новое имя пользователя
   * @param password новый пароль
   * @param role новая роль
   */
  public static void updateUser(Long userId, String username, String password, String role) {
    User userFromDb = getUserById(userId);
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    if (username != null && !username.isEmpty()) {
      userFromDb.setUsername(username);
    }
    if (password != null && !password.isEmpty()) {
      userFromDb.setPassword(passwordEncryption(password));
    }
    Role[] roles = Role.values();
    boolean isRolePresent = Arrays.stream(roles)
        .anyMatch(role1 -> role1.name().equalsIgnoreCase(role));
    if (role != null && !role.isEmpty() && isRolePresent) {
      userFromDb.setRole(Role.valueOf(role.toUpperCase()));
    }
    session.update(userFromDb);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Метод возвращает общее кол-во пользователей
   */
  public static Long countUsers() {
    Session session = HibernateUtil.getSession();
    Query<Long> usersCountQuery = session.createQuery("SELECT COUNT(*) FROM User users");
    Long count =  usersCountQuery.uniqueResult();
    session.close();
    return count;
  }

  /**
   * Возвращает пользователя по его логину
   *
   * @param username имя пользователя
   * @return User
   */
  public static User getUser(String username) {
    Session session = HibernateUtil.getSession();
    Query<User> getUserQuery = session.createQuery("FROM User WHERE username=:username");
    getUserQuery.setParameter("username", username);
    User user = getUserQuery.uniqueResult();
    session.close();
    return user;
  }

  /**
   * Метод возвращает пользователя по его id
   * @param userId id пользователя
   * @return User
   */
  public static User getUserById(Long userId) {
    Session session = HibernateUtil.getSession();
    Query<User> getUserQuery = session.createQuery("FROM User WHERE userId=:userId");
    getUserQuery.setParameter("userId", userId);
    User user = getUserQuery.uniqueResult();
    session.close();
    return user;
  }

  /**
   * Метод удаляет выбранного пользователя по его userId
   */
  public static void deleteUserById(Long userId) {
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    Query<User> getUserQuery = session.createQuery("FROM User WHERE userId=:userId");
    getUserQuery.setParameter("userId", userId);
    User selectedUser = getUserQuery.uniqueResult();
    session.delete(selectedUser);
    session.getTransaction().commit();
    session.close();
  }

  /**
   * Распечатать информацию о пользователе
   */
  public static void printUserInfo(User user) {
    System.out.println("Ваш логин: " + user.getUsername() + ", пароль (указанный при регистрации)");
    LoggerService.addMessage("Вы запросили информацию о вашем профиле");
    MenuController.backToMenu();
  }

  /**
   * Метод проверяет наличие пользователя в БД
   */
  public static Boolean isUserExists(String username) {
    Session session = HibernateUtil.getSession();
    Query<Boolean> existsQuery = session.createQuery(
        "SELECT 1 FROM User WHERE EXISTS (SELECT 1 FROM User u WHERE username=:username)");
    existsQuery.setParameter("username", username);
    Boolean isUserExists = existsQuery.uniqueResult() != null;
    session.close();
    return isUserExists;
  }

  /**
   * Метод проверяет наличие пользователя в БД по его ID
   */
  public static Boolean isUserExistsById(Long userId) {
    Session session = HibernateUtil.getSession();
    Query<Boolean> existsQuery = session.createQuery(
        "SELECT 1 FROM User WHERE EXISTS (SELECT 1 FROM User u WHERE userId=:userId)");
    existsQuery.setParameter("userId", userId);
    Boolean isUserExists = existsQuery.uniqueResult() != null;
    session.close();
    return isUserExists;
  }

  /**
   * Метод проверяет введенный пользователем пароль и сравнивает с паролем хранимым в БД
   */
  public static Boolean isUserPasswordCorrect(String username, String password) {
    User user = getUser(username);
    if (!user.getPassword().equals(passwordEncryption(password))) {
      return false;
    }
    return true;
  }

  /**
   * Метод выводит информацию о приобретенных билетах текущим пользователем
   */
  public static void printPurchasedTickets(User currentUser) {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow( "Id", "Название фильма", "Номер места", "Стоимость");
    at.addRule();
    User userFromDb = UserService.getUser(currentUser.getUsername());
    userFromDb.getTickets().forEach(ticket -> {
      at.addRow(ticket.getTicketId(), ticket.getMovie().getMovieTitle(),
          ticket.getSeatNumber(), ticket.getPrice());
      at.addRule();
    });
    System.out.println(at.render());
  }

  /**
   * Метод выводит информацию о всех пользователях
   */
  public static void printUsers() {
    Session session = HibernateUtil.getSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<User> criteria = builder.createQuery(User.class);
    criteria.from(User.class);
    List<User> users = session.createQuery(criteria).getResultList();
    session.close();
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Id", "Имя пользователя", "Баланс", "Роль");
    at.addRule();
    users.forEach(user -> {
      at.addRow(user.getUserId(), user.getUsername(), user.getAmountOfMoney(), user.getRole());
      at.addRule();
    });
    System.out.println(at.render());
  }

  /**
   * Создает сессию для текущего пользователя
   *
   * @param username имя пользователя
   * @return User
   */
  public static User setCurrentUser(String username) {
    if (username.equals("null")) {
      authUser = null;
      return null;
    }
    authUser = UserService.getUser(username);
    return authUser;
  }

  /**
   * Возвращает сессию текущего авторизованного пользователя
   *
   * @return User
   */
  public static User getCurrentUser() {
    return authUser;
  }

  /**
   * Мето для хеширования паролей
   *
   * @param password String пароль пользователя
   * @return String хеш пароля
   */
  public static String passwordEncryption(String password) {
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 10000, 512);
      SecretKey key = skf.generateSecret(spec);
      byte[] res = key.getEncoded();
      return Hex.encodeHexString(res);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }

}
