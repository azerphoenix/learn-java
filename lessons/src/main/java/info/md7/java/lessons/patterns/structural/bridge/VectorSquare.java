package info.md7.java.lessons.patterns.structural.bridge;

public class VectorSquare extends Square
{
  private Renderer renderer;
  public VectorSquare(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String toString()
  {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }
}
