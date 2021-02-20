package info.md7.java.lessons.patterns.structural.bridge;

public class VectorRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "lines";
  }

}
