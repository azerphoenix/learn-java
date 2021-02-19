package info.md7.java.lessons.patterns.creational;

import info.md7.java.lessons.patterns.creational.singleton.EnumSingleton;
import info.md7.java.lessons.patterns.creational.singleton.InnerStaticSingleton;
import info.md7.java.lessons.patterns.creational.singleton.LazySingleton;
import info.md7.java.lessons.patterns.creational.singleton.MonoState;
import info.md7.java.lessons.patterns.creational.singleton.Singleton;
import info.md7.java.lessons.patterns.creational.singleton.multiton.Device;
import info.md7.java.lessons.patterns.creational.singleton.multiton.OS;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void singletonTest() {
    String a1 = Singleton.getInstance().toString();
    String a2 = Singleton.getInstance().toString();
    Assertions.assertEquals(a1, a2);
  }

  @Test
  void lazySingletonTest() {
    String a1 = LazySingleton.getInstance().toString();
    String a2 = LazySingleton.getInstance().toString();
    Assertions.assertEquals(a1, a2);
  }

  @Test
  void innerStaticSingletonTest() {
    String a1 = InnerStaticSingleton.getInstance().toString();
    String a2 = InnerStaticSingleton.getInstance().toString();
    Assertions.assertEquals(a1, a2);
  }

  @Test
  void enumSingletonTest() {
    String a1 = EnumSingleton.getInstance().toString();
    String a2 = EnumSingleton.getInstance().toString();
    Assertions.assertEquals(a1, a2);
  }

  @Test
  void monoStateTest() {
    MonoState monoState = new MonoState();
    monoState.setName("Hello");
    monoState.setSurname("World");
    MonoState monoState1 = new MonoState();
    Assertions.assertEquals(monoState1.getName(), monoState.getName());
  }

  @Test
  void multiTonTest() {
    Device a1 = Device.getInstance(OS.LINUX);
    Device a2 = Device.getInstance(OS.LINUX);
    Assertions.assertEquals(a1, a2);
    BooleanSupplier func = () -> a1.equals(a2);
    Assertions.assertTrue(func);
  }

}
