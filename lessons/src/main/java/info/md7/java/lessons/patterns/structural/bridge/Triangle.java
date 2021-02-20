package info.md7.java.lessons.patterns.structural.bridge;

public class Triangle extends Shape {

  public Triangle(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String getName()
  {
    return "Triangle";
  }
}
