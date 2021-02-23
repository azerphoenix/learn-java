package info.md7.java.lessons.patterns.behavioral.chain_of_responsibility;

public abstract class MessageHandler {

  protected MessageHandler messageHandler;

  public MessageHandler(
      MessageHandler messageHandler) {
    this.messageHandler = messageHandler;
  }

  public abstract void handle(String message);

}
