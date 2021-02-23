package info.md7.java.lessons.patterns.structural.composite.example_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graphic {

  protected String name = "Graphic";
  protected String color;
  protected List<Graphic> graphics = new ArrayList<>();

  public void addGraphic(Graphic graphic) {
    graphics.add(graphic);
  }

  public void addGraphics(Graphic... graphicsArr) {
    graphics.addAll(List.of(graphicsArr));
  }

  private void print(StringBuilder stringBuilder, int depth) {
    stringBuilder.append(String.join("", Collections.nCopies(depth, "")))
        .append(depth > 0 ? "" : "")
        .append((color == null || color.isEmpty() ? " - " : color + " "))
        .append(name)
        .append(System.lineSeparator()).toString();
    for (Graphic childObject : graphics) {
      childObject.print(stringBuilder, depth + 1);
    }

  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    print(stringBuilder, 0);
    return stringBuilder.toString();
  }
}
