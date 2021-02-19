package info.md7.java.lessons.patterns.creational.builder.fluent_builder;

public class EmployeeBuilderImpl extends UserBuilderImpl<EmployeeBuilderImpl> {

  public EmployeeBuilderImpl setPosition(String position) {
    user.setPosition(position);
    return this;
  }

}
