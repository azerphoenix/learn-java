package info.md7.java.homeworks.hw_7.task;

import java.util.HashMap;
import java.util.Map;

public class MapClass {

  private Map<String, String> users;

  {
    users = new HashMap<>();
    users.put("admin", "Администратор");
    users.put("user1", "Иванов Иван Иванович");
    users.put("user2", "Василий Петрович");
  }

  public MapClass() {}

  public MapClass(Map<String, String> users) {
    this.users = users;
  }

  /**
   * Вывести список всех пользователей
   */
  public void printUsers() {
    System.out.println("Список пользователей: ");
    for (Map.Entry<String, String> entry : users.entrySet()){
      System.out.println("Имя пользователя: " + entry.getKey() + " " + "ФИО: " + entry.getValue());
    }
  }

  /**
   * Метод добавляет нового пользователя
   * @param username - имя пользователя
   * @param fullname - ФИО пользователя
   * @return - boolean status
   */
  public boolean addNewUser(String username, String fullname) {
    for (Map.Entry<String, String> entry : users.entrySet()){
      if(username == null || username.equals("") || fullname == null || fullname.equals("")) {
        System.out.println("Вы указали некорректное имя пользователя или ФИО!");
        return false;
      } else if (username.equals(entry.getKey())){
        System.out.println("Выбранное вам имя пользователя уже занято!");
        return false;
      }
    }
    users.put(username, fullname);
    System.out.println("Вы успешно зарегистрировались в системе!");
    return true;
  }

  /**
   * Метод для удаления выбранного пользователя
   * @param username логин пользователя
   * @return boolean status
   */
  public boolean deleteUser(String username) {
    for (Map.Entry<String, String> entry : users.entrySet()){
      if(username != null && username.equals(entry.getKey())){
        users.remove(entry.getKey());
        System.out.println("Вы успешно удалили профиль!");
        return true;
      }
    }
    System.out.println("Во время удаления возникли проблемы. Возможно, указанное вами имя "
        + "пользователя отсутствует в системе!");
    return false;
  }

  public Map<String, String> getUsers() {
    return users;
  }

  public void setUsers(Map<String, String> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "MapClass{" +
        "users=" + users +
        '}';
  }

}
