package info.md7.java.lessons.patterns.creational.singleton;

public enum EnumSingleton {

  INSTANCE;

  public static EnumSingleton getInstance() {
    return INSTANCE;
  }

}
