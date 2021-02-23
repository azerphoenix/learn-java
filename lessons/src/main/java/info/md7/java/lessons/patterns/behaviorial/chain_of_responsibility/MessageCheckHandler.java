package info.md7.java.lessons.patterns.behaviorial.chain_of_responsibility;

public class MessageCheckHandler extends MessageHandler {

  public MessageCheckHandler(
      MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    if (message.length() > 0) {
      messageHandler.handle(message);
    }
  }
}
