package info.md7.java.lessons.patterns.creational.singleton;

public class LazySingleton {

  private static LazySingleton instance;

  private LazySingleton() {}

  // Using synchronized for thread safety
  public static synchronized LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }

}
