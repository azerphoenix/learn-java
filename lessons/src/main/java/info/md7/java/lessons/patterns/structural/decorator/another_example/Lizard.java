package info.md7.java.lessons.patterns.structural.decorator.another_example;

public class Lizard {

  public int age;

  public String crawl()
  {
    return (age > 1) ? "crawling" : "too young";
  }

}
