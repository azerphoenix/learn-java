package info.md7.java.lessons.patterns.behavioral.state.example_1;

public class Developer {

  private Activity activity;

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public void changeActivity() {
    if (activity instanceof Sleeping) {
      setActivity(new Coding());
    } else if (activity instanceof Coding) {
      setActivity(new Reading());
    } else if (activity instanceof Reading) {
      setActivity(new Sleeping());
    }
  }

  public void doSomething() {
    activity.doSomething();
  }

}
