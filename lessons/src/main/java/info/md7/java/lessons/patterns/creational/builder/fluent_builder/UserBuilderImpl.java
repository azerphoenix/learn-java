package info.md7.java.lessons.patterns.creational.builder.fluent_builder;

public class UserBuilderImpl<T extends UserBuilderImpl<T>> {

  protected User user = new User();
  
  public T setName(String name) {
    user.setName(name);
    return self();
  }
  
  public T setSurname(String surname) {
    user.setSurname(surname);
    return self();
  }

  public T setLogin(String login) {
    user.setLogin(login);
    return self();
  }
  
  public T setPassword(String password) {
    user.setPassword(password);
    return self();
  }
  
  public User build() {
    return user;
  }

  @SuppressWarnings("all")
  private T self() {
    return (T) this;
  }
  
}
