package info.md7.java.lessons.patterns.structural.composite.example_2;

import java.util.ArrayList;
import java.util.List;

public class DevTeam {

  private List<Developer> developers = new ArrayList<>();

  public void addDeveloper(Developer developer) {
    developers.add(developer);
  }

  public void removeDeveloper(Developer developer) {
    developers.remove(developer);
  }

  public void createWebsite() {
    developers.forEach(Developer::writeCode);
  }

}
