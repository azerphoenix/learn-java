package info.md7.java.lessons.patterns.behavioral.memento.example_2;

public class Originator {

  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Memento saveState() {
    return new Memento(this.state);
  }

  public void restoreState(Memento memento) {
    this.state = memento.state;
  }

  public static class Memento {

    private String state;

    public Memento(String state) {
      this.state = state;
    }
  }

}
