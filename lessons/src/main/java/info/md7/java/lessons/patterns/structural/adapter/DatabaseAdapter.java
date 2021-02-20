package info.md7.java.lessons.patterns.structural.adapter;

public class DatabaseAdapter extends AnotherDatasource implements Database {

  @Override
  public String create() {
    return save();
  }

  @Override
  public String read() {
    return get();
  }

  @Override
  public String update() {
    return change();
  }

  @Override
  public String delete() {
    return remove();
  }
}
