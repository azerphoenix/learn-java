package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.bridge.Square;
import info.md7.java.lessons.patterns.structural.bridge.VectorRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeTest {

  @Test
  void bridgeTest() {
    String s = new Square(new VectorRenderer()).toString();
    Assertions.assertEquals("Drawing Square as lines", s);
  }

}
