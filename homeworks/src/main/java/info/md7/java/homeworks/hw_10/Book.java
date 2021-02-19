package info.md7.java.homeworks.hw_10;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

  private String title;
  private String author;
  private String shortContent;

  public Book() { }

  public Book(String title, String author, String shortContent) {
    this.title = title;
    this.author = author;
    this.shortContent = shortContent;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getShortContent() {
    return shortContent;
  }

  public void setShortContent(String shortContent) {
    this.shortContent = shortContent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(title, book.title) &&
        Objects.equals(author, book.author) &&
        Objects.equals(shortContent, book.shortContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, shortContent);
  }

  @Override
  public String toString() {
    return String.format(
        "Автор: %s \n"
        + "Название книги: %s\n"
        + "Краткое содержание: %s\n"
        + "---------",
        author, title, shortContent
    );
  }

}
