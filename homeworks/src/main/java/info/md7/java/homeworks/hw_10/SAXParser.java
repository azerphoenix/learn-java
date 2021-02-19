package info.md7.java.homeworks.hw_10;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {

  private List<Book> books = new ArrayList<>();
  private Book book = null;
  private boolean currentElement = false;
  private String currentValue = null;

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    currentElement = true;
    if (qName.equalsIgnoreCase("book")) {
      book = new Book();
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) {
    currentElement = false;
    if (qName.equalsIgnoreCase("title")) {
      book.setTitle(currentValue);
    } else if (qName.equalsIgnoreCase("author")) {
      book.setAuthor(currentValue);
    } else if (qName.equalsIgnoreCase("shot_content")) {
      book.setShortContent(currentValue);
    } else if (qName.equalsIgnoreCase("book")) {
      books.add(book);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    if (currentElement) {
      currentValue = new String(ch, start, length);
      currentElement = false;
    }
  }

  public List<Book> getBooks() {
    return books;
  }

}
