package info.md7.java.homeworks.cinema.controllers;


import info.md7.java.homeworks.cinema.models.Movie;
import info.md7.java.homeworks.cinema.models.Ticket;
import info.md7.java.homeworks.cinema.models.User;
import info.md7.java.homeworks.cinema.services.LoggerService;
import info.md7.java.homeworks.cinema.services.MovieService;
import info.md7.java.homeworks.cinema.services.TicketService;
import info.md7.java.homeworks.cinema.services.UserService;
import java.util.Scanner;

public class TicketController {

  /**
   * Метод для приобретения билета на выбранный пользователем фильм
   */
  public static void buyTicket() {
    MovieService.printMovies();
    User currentUser = UserService.getCurrentUser();
    boolean scannerLoop = true;
    while (scannerLoop) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(
        "Выберите предпочитаемый фильм. \n" +
        "Для выбора фильма введите идентификатор этого фильма:\n" +
        "-----------------------------------------------------\n"
      );
      Long movieId = scanner.nextLong();
      Movie selectedMovie = MovieService.getMovieById(movieId);
      if (selectedMovie == null) {
        System.out.println("Вы ввели недействительное значение Id фильма!");
        continue;
      }
      System.out.println("Список доступных билетов для фильма - " + selectedMovie.getMovieTitle());
      TicketService.printUnboughtTickets(selectedMovie);
      System.out.println(
        "Выберите билет, который желаете приобрести. \n" +
        "Для приобретения билета введите идентификатор: \n" +
        "-----------------------------------------------------\n"
      );
      Long ticketId = scanner.nextLong();
      boolean status = TicketService.buySelectedTicket(ticketId, currentUser);
      if (status) {
        System.out.println(
          "Поздравляем! Вы успешно приобрели выбранный билет.\n" +
          "С Вашего счета удержана соответствующая сумма."
        );
        Ticket purchasedTicket = TicketService.getTicketById(ticketId);
        String message = String.format("Вы успешно приобрели билет на фильм: %s Номер места: %s", selectedMovie.getMovieTitle(), purchasedTicket.getSeatNumber());
        LoggerService.addMessage(message);
        scannerLoop = false;
      } else {
        System.out.println(
          "Возникли проблемы при покупке билета.\n" +
          "Возможно, на счету недостаточно денег. или вы указали некорректное значение id билета"
        );
      }

      MenuController.backToMenu();
    }
  }

  /**
   * Метод реализует возврат выбранного билета
   *
   * @param isManager флаг для проверки роли пользователя
   * В зависимости от этого флага отображаются различные методы
   * для менеджера или обычного пользователя
   */
  public static void returnTicket(boolean isManager) {
    if (isManager) {
      UserService.printUsers();
      boolean scannerLoop = true;
      while (scannerLoop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Выберите пользователя. \n" +
            "Для выбора пользователя введите его идентификатор:\n" +
            "-----------------------------------------------------\n"
        );
        Long userId = scanner.nextLong();
        User selectedUser = UserService.getUserById(userId);
        UserService.printPurchasedTickets(selectedUser);
        System.out.println(
            "Выберите возвращаемый билет. \n" +
            "Для выбора билета введите идентификатор этого билета:\n" +
            "-----------------------------------------------------\n"
        );
        Long ticketId = scanner.nextLong();
        TicketService.sellSelectedTicket(ticketId, selectedUser);
        System.out.println(
            "Вы успешно вернули билет в кинотеатр!\n" +
            "-----------------------------------------------------\n"
        );
        String managersMessage = String.format("Вы оформили возврат билета с id %s для пользователя %s", ticketId, selectedUser.getUsername());
        LoggerService.addMessage(managersMessage);
        String usersMessage = String.format("Менеджер системы оформил возврат билета с id %s", ticketId);
        LoggerService.addMessage(usersMessage, selectedUser);
        scannerLoop = false;
      }
    } else {
      User currentUser = UserService.getCurrentUser();
      UserService.printPurchasedTickets(currentUser);
      boolean scannerLoop = true;
      while (scannerLoop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Выберите возвращаемый билет. \n" +
            "Для выбора билета введите идентификатор этого билета:\n" +
            "-----------------------------------------------------\n"
        );
        Long ticketId = scanner.nextLong();
        TicketService.sellSelectedTicket(ticketId, currentUser);
        System.out.println(
            "Вы успешно вернули билет в кинотеатр!\n" +
            "-----------------------------------------------------\n"
        );
        String message = String.format("Вы оформили возврат билета с id %s", ticketId);
        LoggerService.addMessage(message);
        scannerLoop = false;
      }
    }
    MenuController.backToMenu();
  }

}
