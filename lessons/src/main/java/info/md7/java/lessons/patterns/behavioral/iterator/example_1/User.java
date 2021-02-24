package info.md7.java.lessons.patterns.behavioral.iterator.example_1;

public class User implements Collection {

  private String[] skills;

  public User(String[] skills) {
    this.skills = skills;
  }

  @Override
  public Iterator getIterator() {
    return new SkillIterator();
  }

  private class SkillIterator implements Iterator {

    private int index;

    @Override
    public boolean hasNext() {
      if (index < skills.length) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      return skills[index++];
    }

  }
}
