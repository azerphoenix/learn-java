package info.md7.java.homeworks.cinema.controllers;

import de.vandermeer.asciitable.AsciiTable;
import info.md7.java.homeworks.cinema.enums.Role;
import info.md7.java.homeworks.cinema.models.User;
import info.md7.java.homeworks.cinema.services.BalanceService;
import info.md7.java.homeworks.cinema.services.LoggerService;
import info.md7.java.homeworks.cinema.services.MovieService;
import info.md7.java.homeworks.cinema.services.UserService;
import java.util.Scanner;

public class MenuController {

  /**
   * Метод выводит меню авторизации пользователя
   */
  public static void showAuthMenu() {
    Scanner authScanner = new Scanner(System.in);
    printAuthMenuOptions();
    int selection = authScanner.nextInt();
    switch (selection) {
      case 1:
        UserController.userRegistration();
        break;
      case 2:
        UserController.userLogin();
        break;
      default:
        System.out.println("Вы указали некорректное значение!");
    }
  }

  /**
   * Метод выводит главное меню для пользователя
   */
  public static void showMainMenu() {
    User currentUser = UserService.getCurrentUser();
    Scanner mainMenuScanner = new Scanner(System.in);
    int selection;
    if (currentUser.getRole() == Role.USER) {
      printUserMenuOptions();
      selection = mainMenuScanner.nextInt();
      userMenuOptions(selection, currentUser);
    } else if (currentUser.getRole() == Role.MANAGER) {
      printManagerMenuOptions();
      selection = mainMenuScanner.nextInt();
      managerMenuOptions(selection, currentUser);
    } else if (currentUser.getRole() == Role.ADMIN) {
      printAdminMenuOptions();
      selection = mainMenuScanner.nextInt();
      adminMenuOptions(selection, currentUser);
    }
    LoggerService.addMessage("Открыто главное меню");
  }

  /**
   * Метод для возврата в главное меню
   */
  public static void backToMenu() {
    System.out.println("Для возврата в главное меню введите \\q");
    Scanner scanner = new Scanner(System.in);
    String exit = scanner.nextLine();
    if(exit.equals("\\q")) {
      LoggerService.addMessage("Произведен переход обратно в главное меню");
      MenuController.showMainMenu();
    }
  }

  /**
   * Распечатать меню авторизации
   */
  private static void printAuthMenuOptions() {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Здравствуйте! Для продолжения работы в приложении Вам необходимо авторизоваться. Выберите соответствующий пункт: ");
    at.addRule();
    at.addRow("1 - Регистрация");
    at.addRule();
    at.addRow("2 - Вход");
    at.addRule();
    System.out.println(at.render());
  }

  /**
   * Распечатать меню для юзера
   */
  private static void printUserMenuOptions() {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Главное меню - Выберите соответствующий пункт меню");
    at.addRule();
    at.addRow("1 - Просмотреть список доступных фильмов");
    at.addRule();
    at.addRow("2 - Купить билет");
    at.addRule();
    at.addRow("3 - Вернуть приобретенный билет");
    at.addRule();
    at.addRow("4 - Просмотреть список приобретенных билетов");
    at.addRule();
    at.addRow("5 - Проверить лицевой счет");
    at.addRule();
    at.addRow("6 - Посмотреть профиль");
    at.addRule();
    at.addRow("7 - Посмотреть лог");
    at.addRule();
    at.addRow("8 - Экспортировать лог");
    at.addRule();
    at.addRow("9 - Выйти из системы");
    at.addRule();
    at.addRow("10 - Выход из программы");
    at.addRule();
    System.out.println(at.render());
  }

  /**
   * Распечатать меню для менеджера
   */
  private static void printManagerMenuOptions() {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Главное меню - Выберите соответствующий пункт меню");
    at.addRule();
    at.addRow("1 - Просмотреть список фильмов");
    at.addRule();
    at.addRow("2 - Изменить фильм");
    at.addRule();
    at.addRow("3 - Оформить возврат билета");
    at.addRule();
    at.addRow("4 - Выйти из системы");
    at.addRule();
    at.addRow("5 - Выход из программы");
    at.addRule();
    System.out.println(at.render());
  }

  /**
   * Распечатать меню для админа
   */
  private static void printAdminMenuOptions() {
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow("Главное меню - Выберите соответствующий пункт меню");
    at.addRule();
    at.addRow("1 - Просмотреть список пользователей");
    at.addRule();
    at.addRow("2 - Изменить пользователя");
    at.addRule();
    at.addRow("3 - Удалить пользователя");
    at.addRule();
    at.addRow("4 - Просмотреть список фильмов");
    at.addRule();
    at.addRow("5 - Изменить фильм");
    at.addRule();
    at.addRow("6 - Удалить фильм");
    at.addRule();
    at.addRow("7 - Посмотреть логи системы");
    at.addRule();
    at.addRow("8 - Выйти из системы");
    at.addRule();
    at.addRow("9 - Выход из программы");
    at.addRule();
    System.out.println(at.render());
  }

  /**
   * Логика работы меню юзера
   */
  private static void userMenuOptions(int selection, User currentUser) {
    switch (selection) {
      case 1:
        MovieService.printMovies();
        MenuController.backToMenu();
        break;
      case 2:
        TicketController.buyTicket();
        break;
      case 3:
        TicketController.returnTicket(false);
        break;
      case 4:
        UserService.printPurchasedTickets(currentUser);
        MenuController.backToMenu();
        break;
      case 5:
        BalanceService.getBalance();
        break;
      case 6:
        UserService.printUserInfo(currentUser);
        break;
      case 7:
        LoggerController.viewLogs(false);
        break;
      case 8:
        LoggerController.exportLogs();
        break;
      case 9:
        UserController.logout();
        break;
      case 10:
        LoggerService.addMessage("Пользователь завершил работу с приложением");
        System.exit(0);
        break;
      default:
        System.out.println("Вы указали некорректное значение!");
    }
  }

  /**
   * Логика работы меню менеджера
   */
  private static void managerMenuOptions(int selection, User currentUser) {
    switch (selection) {
      case 1:
        MovieService.printMovies();
        MenuController.backToMenu();
        break;
      case 2:
        MovieController.editMovie();
        break;
      case 3:
        TicketController.returnTicket(true);
        break;
      case 4:
        UserController.logout();
        break;
      case 5:
        LoggerService.addMessage("Пользователь завершил работу с приложением");
        System.exit(0);
        break;
      default:
        System.out.println("Вы указали некорректное значение!");
    }
  }

  /**
   * Логика работы меню админа
   */
  private static void adminMenuOptions(int selection, User currentUser) {
    switch (selection) {
      case 1:
        UserService.printUsers();
        MenuController.backToMenu();
        break;
      case 2:
        UserController.editUser();
        break;
      case 3:
        UserController.deleteUser();
        break;
      case 4:
        MovieService.printMovies();
        MenuController.backToMenu();
        break;
      case 5:
        MovieController.editMovie();
        break;
      case 6:
        MovieController.deleteMovie();
        break;
      case 7:
        LoggerController.viewLogs(true);
        break;
      case 8:
        UserController.logout();
        break;
      case 9:
        LoggerService.addMessage("Пользователь завершил работу с приложением");
        System.exit(0);
        break;
      default:
        System.out.println("Вы указали некорректное значение!");
    }
  }

}
