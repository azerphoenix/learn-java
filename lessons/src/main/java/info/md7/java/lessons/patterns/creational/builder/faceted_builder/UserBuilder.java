package info.md7.java.lessons.patterns.creational.builder.faceted_builder;

public class UserBuilder {

  protected User user = new User();

  public UserBuilder setName(String name) {
    user.setName(name);
    return this;
  }

  public UserBuilder setSurname(String surname) {
    user.setSurname(surname);
    return this;
  }

  public EmployeeBuilder setEmployee() {
    return new EmployeeBuilder(user);
  }

  public AccountBuilder setAccount() {
    return new AccountBuilder(user);
  }

  public User build() {
    return user;
  }

}
