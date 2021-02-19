package info.md7.java.lessons.patterns.creational;

import info.md7.java.lessons.patterns.creational.builder.User;
import info.md7.java.lessons.patterns.creational.builder.UserBuilderImpl;
import info.md7.java.lessons.patterns.creational.builder.faceted_builder.UserBuilder;
import info.md7.java.lessons.patterns.creational.builder.fluent_builder.EmployeeBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuilderTest {

  @Test
  void builderTest() {
    User user = new UserBuilderImpl().setName("Hello").setSurname("World")
        .setLogin("Test").setPassword("12345").build();
    Assertions.assertEquals("Hello", user.getName());
    Assertions.assertEquals("Test", user.getLogin());
  }

  @Test
  void fluentBuilderTest() {
    info.md7.java.lessons.patterns.creational.builder.fluent_builder.User user = new EmployeeBuilderImpl()
        .setName("Hello").setSurname("World")
        .setLogin("Test").setPassword("12345").setPosition("Developer").build();
    Assertions.assertEquals("Hello", user.getName());
    Assertions.assertEquals("Test", user.getLogin());
    Assertions.assertEquals("Developer", user.getPosition());
  }

  @Test
  void facetedBuilderTest() {
    info.md7.java.lessons.patterns.creational.builder.faceted_builder.User user = new UserBuilder()
        .setName("Hello").setSurname("World")
        .setAccount()
        .setLogin("admin")
        .setPassword("12345")
        .setEmployee()
        .setPosition("Developer")
        .build();
    Assertions.assertEquals("Hello", user.getName());
    Assertions.assertEquals("admin", user.getUsername());
    Assertions.assertEquals("Developer", user.getPosition());
  }

}
