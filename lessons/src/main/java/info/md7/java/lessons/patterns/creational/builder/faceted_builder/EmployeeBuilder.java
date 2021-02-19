package info.md7.java.lessons.patterns.creational.builder.faceted_builder;

public class EmployeeBuilder extends UserBuilder {

  public EmployeeBuilder(User user) {
    this.user = user;
  }

  public EmployeeBuilder setPosition(String position) {
    user.setPosition(position);
    return this;
  }

}
