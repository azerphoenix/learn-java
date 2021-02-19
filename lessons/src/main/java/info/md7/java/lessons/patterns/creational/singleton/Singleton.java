package info.md7.java.lessons.patterns.creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return INSTANCE;
  }

  /*
    Fixing problem with multiple instances due serialization
   */
  protected Object readResolve() {
    return INSTANCE;
  }

}
