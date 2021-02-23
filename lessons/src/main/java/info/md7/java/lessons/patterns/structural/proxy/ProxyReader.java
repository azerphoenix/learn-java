package info.md7.java.lessons.patterns.structural.proxy;

public class ProxyReader implements Reader {

  private CustomReader customReader;

  @Override
  public String read(String someText) {
    if (customReader == null) {
      customReader = new CustomReader();
    }
    System.out.println("Starting reading data");
    System.out.println(someText);
    customReader.read(someText);
    System.out.println("Ending reading data");
    return someText;
  }

}
