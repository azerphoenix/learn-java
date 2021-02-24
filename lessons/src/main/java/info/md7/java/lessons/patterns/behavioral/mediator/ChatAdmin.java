package info.md7.java.lessons.patterns.behavioral.mediator;

public class ChatAdmin implements User {

  private Chat chat;
  private String name;

  public ChatAdmin(Chat chat, String name) {
    this.chat = chat;
    this.name = name;
  }

  @Override
  public String sendMessage(String message) {
    chat.sendMessage(message, this);
    return message;
  }

  @Override
  public String getMessage(String message) {
    return message;
  }
}
