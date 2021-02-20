package info.md7.java.lessons.patterns.structural.bridge;

public class Square extends Shape {

  public Square(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String getName()
  {
    return "Square";
  }

}
