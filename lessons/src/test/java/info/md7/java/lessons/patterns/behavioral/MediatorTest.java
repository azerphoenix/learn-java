package info.md7.java.lessons.patterns.behavioral;

import info.md7.java.lessons.patterns.behavioral.mediator.ChatAdmin;
import info.md7.java.lessons.patterns.behavioral.mediator.TextChat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MediatorTest {

  @Test
  void mediatorTest() {
    TextChat chat = new TextChat();
    ChatAdmin admin = new ChatAdmin(chat, "Administrator");
    info.md7.java.lessons.patterns.behavioral.mediator.Employee user1 = new info.md7.java.lessons.patterns.behavioral.mediator.Employee(chat, "User 1");
    info.md7.java.lessons.patterns.behavioral.mediator.Employee user2 = new info.md7.java.lessons.patterns.behavioral.mediator.Employee(chat, "User 2");
    chat.setAdmin(admin);
    chat.addEmployeeToChat(user1);
    chat.addEmployeeToChat(user2);
    Assertions.assertEquals("Hello!", user1.sendMessage("Hello!"));
    Assertions.assertEquals("Hi!", user2.sendMessage("Hi!"));
  }

}
