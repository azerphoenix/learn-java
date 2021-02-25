package info.md7.java.lessons.patterns.behavioral.visitor.example_1;

public class Project implements ProjectElement{

  private ProjectElement[] projectElements;

  public Project() {
    this.projectElements = new ProjectElement[]{
        new ProjectClass(), new Database(), new Test()
    };
  }

  @Override
  public void beWritten(Developer developer) {
    for (ProjectElement projectElement : projectElements) {
      projectElement.beWritten(developer);
    }
  }
}
