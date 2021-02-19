package info.md7.java.homeworks.hw_11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

  private Long id;
  private String name;
  private String surname;
  private List<User> friends = new ArrayList<>();

  public User() {}

  public User(Long id, String name, String surname, List<User> friends) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.friends = friends;
  }

  /**
   * Метод для добавления друга в список друзей
   * @param user - пользователь, которого нужно добавить в список друзей
   */
  public void addFriend(User user) {
    this.friends.add(user);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public List<User> getFriends() {
    return friends;
  }

  public void setFriends(List<User> friends) {
    this.friends = friends;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(name, user.name) &&
        Objects.equals(surname, user.surname) &&
        Objects.equals(friends, user.friends);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, friends);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        '}';
  }
}
