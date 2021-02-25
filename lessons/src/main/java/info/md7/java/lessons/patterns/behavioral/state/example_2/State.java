package info.md7.java.lessons.patterns.behavioral.state.example_2;

public class State {

  public void on(LightSwitch lightSwitch) {
    System.out.println("Light is already on");
  }

  public void off(LightSwitch lightSwitch) {
    System.out.println("Light is already off");
  }

}

class OnState extends State{

  public OnState() {
    System.out.println("Light turned on");
  }

  @Override
  public void off(LightSwitch lightSwitch) {
    System.out.println("Switching light off");
    lightSwitch.setState(new OffState());
  }
}

class OffState extends State{

  public OffState() {
    System.out.println("Light turned off");
  }

  @Override
  public void on(LightSwitch lightSwitch) {
    System.out.println("Switching light on");
    lightSwitch.setState(new OnState());
  }
}