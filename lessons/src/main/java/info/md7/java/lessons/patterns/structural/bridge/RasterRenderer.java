package info.md7.java.lessons.patterns.structural.bridge;

public class RasterRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "pixels";
  }

}
