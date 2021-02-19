package info.md7.java.homeworks.cinema.controllers;

import de.vandermeer.asciitable.AsciiTable;
import info.md7.java.homeworks.cinema.models.Log;
import info.md7.java.homeworks.cinema.models.User;
import info.md7.java.homeworks.cinema.services.LoggerService;
import info.md7.java.homeworks.cinema.services.UserService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class LoggerController {

  /**
   * Метод для просмотра логов
   * @param isAdmin флаг является ли пользователь админом
   * В зависимости от этого флага пользователю отображаются различные методы
   * для админа и простого пользователя
   */
  public static void viewLogs(boolean isAdmin) {
    if (isAdmin) {
      UserService.printUsers();
      boolean scannerLoop = true;
      Long userId = 0L;
      while (scannerLoop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Выберите пользователя логи которого хотите посмотреть. \n" +
            "Для выбора пользователя введите его идентификатор:\n" +
            "-----------------------------------------------------\n"
        );
        userId = scanner.nextLong();
        if (!UserService.isUserExistsById(userId)) {
          System.out.println("Вы указали недействительный Id пользователя!");
          continue;
        }
        User selectedUser = UserService.getUserById(userId);
        List<Log> logs = LoggerService.getLogs(selectedUser);
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Сообщение", "Дата и время");
        at.addRule();
        logs.forEach(log -> {
          at.addRow(log.getMessage(), log.getDateTime());
          at.addRule();
        });
        System.out.println(at.render());
        scannerLoop = false;
      }
      String message = String.format("Вы удалили пользователя с id %s", userId);
      LoggerService.addMessage(message, UserService.getCurrentUser());
      MenuController.backToMenu();
    } else {
      List<Log> logs = LoggerService.getLogs(UserService.getCurrentUser());
      AsciiTable at = new AsciiTable();
      at.addRule();
      at.addRow("Сообщение", "Дата и время");
      at.addRule();
      logs.forEach(log -> {
        at.addRow(log.getMessage(), log.getDateTime());
        at.addRule();
      });
      System.out.println(at.render());
    }
    MenuController.backToMenu();
  }

  /**
   * Метод для экспорта сообщений логов.
   */
  public static void exportLogs() {
    User currentUser = UserService.getCurrentUser();
    String path = System.getProperty("user.home") + File.separator + currentUser.getUsername() + "_"
        + LocalDateTime.now() + ".log";
    File file = new File(path);
    boolean fileCreationStatus = false;
    try {
      fileCreationStatus = file.createNewFile();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    if (fileCreationStatus) {
      PrintWriter pw = null;
      try {
        pw = new PrintWriter(new FileOutputStream(path));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      for (Log log : currentUser.getLogs()) {
        pw.println(log.getDateTime() + " | " + log.getMessage());
      }
      pw.close();
      System.out.println("Вы успешно экспортировали логи системы!");
    }
    MenuController.backToMenu();
  }

}
