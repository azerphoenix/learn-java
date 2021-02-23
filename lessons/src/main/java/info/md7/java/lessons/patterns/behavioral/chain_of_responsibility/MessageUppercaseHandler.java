package info.md7.java.lessons.patterns.behavioral.chain_of_responsibility;

public class MessageUppercaseHandler extends MessageHandler {

  public MessageUppercaseHandler(
      MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    messageHandler.handle(message.toUpperCase());
  }
}
