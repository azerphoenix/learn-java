package info.md7.java.homeworks.cinema.controllers;


import info.md7.java.homeworks.cinema.services.LoggerService;
import info.md7.java.homeworks.cinema.services.MovieService;
import java.util.Scanner;

public class MovieController {

  /**
   * Метод для удаления фильма
   */
  public static void deleteMovie() {
    MovieService.printMovies();
    Long movieId = 0L;
    boolean scannerLoop = true;
    while (scannerLoop) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(
          "Выберите удаляемый фильм. \n" +
          "Для выбора фильма введите его идентификатор:\n" +
          "-----------------------------------------------------\n"
      );
      movieId = scanner.nextLong();
      MovieService.deleteMovieById(movieId);
      System.out.println("Вы успешно удалили фильм!");
      scannerLoop = false;
    }
    String message = String.format("Вы успешно удалили фильм с id %s", movieId);
    LoggerService.addMessage(message);
    MenuController.backToMenu();
  }

  /**
   * Метод для редактирования выбранного фильма
   */
  public static void editMovie() {
    MovieService.printMovies();
    Long movieId = 0L;
    boolean scannerLoop = true;
    while (scannerLoop) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(
          "Выберите фильм для редактирования. \n" +
          "Для выбора фильма введите его идентификатор:\n" +
          "-----------------------------------------------------\n"
      );
      movieId = scanner.nextLong();
      if (!MovieService.isMovieExists(movieId)) {
        System.out.println("Вы указали недействительный Id фильма!");
        continue;
      }
      System.out.println("Введите новое название фильма.");
      scanner.nextLine();
      String movieTitle = scanner.nextLine();
      MovieService.editMovie(movieId, movieTitle);
      System.out.println("Вы успешно отредактировали фильм!");
      scannerLoop = false;
    }
    String message = String.format("Вы успешно обновили фильм с id %s", movieId);
    LoggerService.addMessage(message);
    MenuController.backToMenu();
  }

}
