package info.md7.java.lessons.patterns.structural.decorator.example_2;

public class Dragon {

  private int age;

  private Lizard lizard;

  private Bird bird;

  public Dragon() {
    lizard = new Lizard();
    bird = new Bird();
  }

  public String fly() {
    return bird.fly();
  }

  public String crawl() {
    return lizard.crawl();
  }

  public void setAge(int age) {
    this.age = age;
    lizard.age = age;
    bird.age = age;
  }

}
