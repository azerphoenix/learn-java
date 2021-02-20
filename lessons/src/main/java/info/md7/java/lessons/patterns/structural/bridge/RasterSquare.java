package info.md7.java.lessons.patterns.structural.bridge;

public class RasterSquare extends Square
{
  private Renderer renderer;
  public RasterSquare(Renderer renderer) {
    super(renderer);
  }
  @Override
  public String toString()
  {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}
