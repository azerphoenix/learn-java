package info.md7.java.lessons.patterns.structural.facade;

public class BugTracker {

  private boolean activeSprint;

  public boolean isActiveSprint() {
    return activeSprint;
  }

  public String startSprint() {
    activeSprint = true;
    return "Sprint is active";
  }

  public String stopSprint() {
    activeSprint = false;
    return "Sprint is stopped";
  }

}
