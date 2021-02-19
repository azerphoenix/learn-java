package info.md7.java.lessons.patterns.creational.builder;

public interface UserBuilder {

  UserBuilder setName(String name);

  UserBuilder setSurname(String surname);

  UserBuilder setLogin(String login);

  UserBuilder setPassword(String password);

  User build();

}
