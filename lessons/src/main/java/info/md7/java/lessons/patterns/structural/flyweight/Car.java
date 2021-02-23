package info.md7.java.lessons.patterns.structural.flyweight;

import java.awt.Color;

public class Car implements Vehicle {

  private Engine engine;
  private Color color;

  public Car(Engine engine, Color color) {
    this.engine = engine;
    this.color = color;
  }

  @Override
  public void start() {
    System.out.println("Started");
  }

  @Override
  public void stop() {
    System.out.println("Stopped");
  }

  @Override
  public Color getColor() {
    return null;
  }

}
