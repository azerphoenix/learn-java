package info.md7.java.lessons.patterns.behavioral.strategy.example_1;

public class Developer {

  private Activity activity;

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public void executeActivity() {
    activity.doSomething();
  }
}
