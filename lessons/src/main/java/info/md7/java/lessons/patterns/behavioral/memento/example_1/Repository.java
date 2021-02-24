package info.md7.java.lessons.patterns.behavioral.memento.example_1;

public class Repository {

  private Save save;

  public Save getSave() {
    return save;
  }

  public void setSave(Save save) {
    this.save = save;
  }
}
