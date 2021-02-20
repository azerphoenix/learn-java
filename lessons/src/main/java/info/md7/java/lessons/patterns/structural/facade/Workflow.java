package info.md7.java.lessons.patterns.structural.facade;

public class Workflow {

  private Developer developer = new Developer();
  private Project project = new Project();
  private BugTracker bugTracker = new BugTracker();

  public String start() {
    String a = project.makeProject();
    String b = bugTracker.startSprint();
    String c = developer.makeProjectBeforeDeadline(bugTracker);
    return a + " " + b + " " + c;
  }

}
