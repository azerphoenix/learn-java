package info.md7.java.homeworks.hw_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {

  public static void main(String[] args) {
    List<User> users = demoDataInitializer();
    getFriends(users.get(0), 3);
  }

  /**
   * Метод для инициализации демо данных
   *
   * @return List of users
   */
  private static List<User> demoDataInitializer() {
    List<User> users = new ArrayList<>();
    for (int i = 0; i <= 50; i++) {
      User user = new User();
      user.setId(new Random().nextLong());
      user.setName(UUID.randomUUID().toString());
      user.setSurname(UUID.randomUUID().toString());
      users.add(user);
    }
    userFriendsRandomizer(users);
    return users;
  }

  /**
   * Метод добавляет рандомное количество друзей для каждого юзера
   *
   * @param users список пользователей
   * @return List of Users with friends
   */
  private static List<User> userFriendsRandomizer(List<User> users) {
    for (User user : users) {
      int randomNumberOfFriends = new Random().nextInt(5);
      for (int i = 0; i <= randomNumberOfFriends; i++) {
        int randomFriendIndex = new Random().nextInt(50);
        User randomFriend = users.get(randomFriendIndex);
        user.addFriend(randomFriend);
      }
    }
    return users;
  }

  /**
   * Метод для рекурсивного получения друзей
   * @param user пользователь
   * @param depth глубина рекурсии
   */
  private static void getFriends(User user, int depth) {
    if (depth > 1) {
      for (User friend : user.getFriends()) {
        getFriends(friend, depth - 1);
      }
    }
    printData(user, user.getFriends());
  }

  /**
   * Метод для распечатки списка пользователей
   * @param list список пользователей
   */
  private static void printData(User currentUser, List<User> list){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Пользователь: ");
    stringBuilder.append(currentUser.getName());
    stringBuilder.append("\n");
    stringBuilder.append("Друзья: ");
    for (User user : list) {
      stringBuilder.append(user.getName());
      stringBuilder.append(", ");
    }
    stringBuilder.append("\n");
    System.out.println(stringBuilder.toString());
  }

}