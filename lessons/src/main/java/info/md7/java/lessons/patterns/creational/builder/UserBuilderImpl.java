package info.md7.java.lessons.patterns.creational.builder;

public class UserBuilderImpl implements UserBuilder {

  private User user = new User();

  @Override
  public UserBuilder setName(String name) {
    user.setName(name);
    return this;
  }

  @Override
  public UserBuilder setSurname(String surname) {
    user.setSurname(surname);
    return this;
  }

  @Override
  public UserBuilder setLogin(String login) {
    user.setLogin(login);
    return this;
  }

  @Override
  public UserBuilder setPassword(String password) {
    user.setPassword(password);
    return this;
  }

  @Override
  public User build() {
    return user;
  }
}
