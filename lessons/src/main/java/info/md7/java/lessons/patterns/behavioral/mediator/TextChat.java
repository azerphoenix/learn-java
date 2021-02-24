package info.md7.java.lessons.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {

  private ChatAdmin admin;
  private List<Employee> employees = new ArrayList<>();

  public void addEmployeeToChat(Employee user) {
    employees.add(user);
  }

  public void setAdmin(ChatAdmin admin) {
    this.admin = admin;
  }

  @Override
  public String sendMessage(String message, User user) {
    for (User usr : employees) {
      if (usr != user) {
        usr.getMessage(message);
      }
    }
    admin.getMessage(message);
    return message;
  }
}
