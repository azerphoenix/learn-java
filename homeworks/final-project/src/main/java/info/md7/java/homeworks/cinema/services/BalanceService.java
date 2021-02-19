package info.md7.java.homeworks.cinema.services;


import info.md7.java.homeworks.cinema.controllers.MenuController;
import info.md7.java.homeworks.cinema.db.HibernateUtil;
import info.md7.java.homeworks.cinema.models.User;
import org.hibernate.Session;

public class BalanceService {

  /**
   * Распечатать баланс пользователя
   */
  public static void getBalance() {
    User user = UserService.getCurrentUser();
    System.out.println("Баланс вашего лицевого счета: " + user.getAmountOfMoney());
    LoggerService.addMessage("Вы запросили проверку остатка на лицевом счете");
    MenuController.backToMenu();
  }

  /**
   * Метод для удержания нужной суммы со счета пользователя
   *
   * @param amount сумма к удержанию
   * @param user пользователь
   * @return boolean
   */
  public static boolean withdrawMoney(Double amount, User user) {
    Double balance = user.getAmountOfMoney();
    if (balance >= amount) {
      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      user.setAmountOfMoney(balance - amount);
      session.merge(user);
      session.getTransaction().commit();
      session.close();
      String message = String.format("С вашего счета была удержана сумма в размере %s", amount);
      LoggerService.addMessage(message, user);
      return true;
    }
    return false;
  }

  /**
   * Метод для пополнения счета пользователя после возврата билета
   *
   * @param amount сумма
   */
  public static void refundMoney(Double amount, User user) {
    Double balance = user.getAmountOfMoney();
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    user.setAmountOfMoney(balance + amount);
    session.merge(user);
    session.getTransaction().commit();
    session.close();
    String message = String.format("Денежные средства в размере %s были возвращены на Ваш счет", amount);
    LoggerService.addMessage(message, user);
  }

}
