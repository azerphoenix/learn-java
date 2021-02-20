package info.md7.java.lessons.patterns.structural.bridge;

public abstract class Shape {

  private Renderer renderer;

  public Shape(Renderer renderer) {
    this.renderer = renderer;
  }

  public abstract String getName();

  @Override
  public String toString() {
    return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
  }

}
