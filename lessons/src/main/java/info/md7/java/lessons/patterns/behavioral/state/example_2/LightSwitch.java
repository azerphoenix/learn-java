package info.md7.java.lessons.patterns.behavioral.state.example_2;

public class LightSwitch {

  private State state;

  public void setState(State state) {
    this.state = state;
  }

  public LightSwitch() {
    this.state = new OffState();
  }

  public void on() {
    state.on(this);
  }

  public void off() {
    state.off(this);
  }
}
