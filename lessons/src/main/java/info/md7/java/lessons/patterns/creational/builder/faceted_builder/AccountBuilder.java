package info.md7.java.lessons.patterns.creational.builder.faceted_builder;

public class AccountBuilder extends UserBuilder {

  public AccountBuilder(User user) {
    this.user = user;
  }

  public AccountBuilder setLogin(String login) {
    user.setUsername(login);
    return this;
  }

  public AccountBuilder setPassword(String password) {
    user.setPassword(password);
    return this;
  }

}
