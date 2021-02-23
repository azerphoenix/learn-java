package info.md7.java.lessons.patterns.structural.decorator.example_2;

public class Bird {

  public int age;

  public String fly()
  {
    return age < 10 ? "flying" : "too old";
  }

}
