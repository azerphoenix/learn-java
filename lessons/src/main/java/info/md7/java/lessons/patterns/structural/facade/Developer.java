package info.md7.java.lessons.patterns.structural.facade;

public class Developer {

  public String makeProjectBeforeDeadline(BugTracker bugTracker) {
    if (bugTracker.isActiveSprint()) {
      return "Developer working!";
    } else {
      return "Developer is relaxing!";
    }
  }

}
