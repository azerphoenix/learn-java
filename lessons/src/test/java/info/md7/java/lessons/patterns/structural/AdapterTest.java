package info.md7.java.lessons.patterns.structural;

import info.md7.java.lessons.patterns.structural.adapter.Database;
import info.md7.java.lessons.patterns.structural.adapter.DatabaseAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdapterTest {

  @Test
  void adapterTest() {
    Database database = new DatabaseAdapter();
    Assertions.assertEquals("Updating selected object", database.update());
    Assertions.assertEquals("New object was created!", database.create());
  }

}
