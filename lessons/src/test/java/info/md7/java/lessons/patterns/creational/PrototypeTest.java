package info.md7.java.lessons.patterns.creational;

import info.md7.java.lessons.patterns.creational.prototype.Address;
import info.md7.java.lessons.patterns.creational.prototype.Doctor;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrototypeTest {

  @Test
  void prototypingViaConstructorTest() {
    info.md7.java.lessons.patterns.creational.prototype.User user =
        new info.md7.java.lessons.patterns.creational.prototype.User("Hello", "World",
            new Address("a", "b", "c"));
    info.md7.java.lessons.patterns.creational.prototype.User user1 = new info.md7.java.lessons.patterns.creational.prototype.User(user);
    user1.setName("John");
    user1.getAddress().setCity("d");
    Assertions.assertNotEquals(user.getName(), user1.getName());
    Assertions.assertNotEquals(user.getAddress().getCity(), user1.getAddress().getCity());
  }

  @Test
  void prototypingViaSerialization() {
    Doctor doctor = new Doctor("Helga", "Smith");
    Doctor doctor1 = SerializationUtils.roundtrip(doctor);
    doctor1.setName("John");
    Assertions.assertNotEquals(doctor.getName(), doctor1.getName());
  }

}
