package info.md7.java.lessons.patterns.behavioral.chain_of_responsibility;

public class MessagePrintHandler extends MessageHandler {

  public MessagePrintHandler(
      MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    System.out.println(message);
  }
}
