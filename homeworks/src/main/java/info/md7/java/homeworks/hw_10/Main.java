package info.md7.java.homeworks.hw_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Main {

  public static final String FILE_PATH = "src/Orkhan_Hasanli_Task10/books1.xml";
  public static final String AUTHOR_NAME = "Франц Кафка";

  public static void main(String[] args)
      throws IOException, ParserConfigurationException, SAXException {
    Main main = new Main();
    main.domParser();
    main.saxParser();
  }

  private void domParser() throws IOException {
    List<Book> books = new ArrayList<>();
    try {
      books = DOMParser.parse(FILE_PATH);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
    System.out.println("Информация о спарсенных книгах: " + System.lineSeparator());
    Path filePath = Files.createTempFile("booksDOMcontent", ".txt");
    FileWriter fileWriter = new FileWriter(filePath.toFile());
    books.forEach(book -> {
      try {
        fileWriter.write(book.toString() + System.lineSeparator());
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    });
    fileWriter.close();
    System.out.println("Список всех авторов: " + System.lineSeparator());
    books.forEach(book -> {
      System.out.println(book.getAuthor());
    });
    System.out.println("---------");
    System.out.println("Книги автора: " + AUTHOR_NAME);
    books.stream().filter(book -> book.getAuthor().equals(AUTHOR_NAME)).forEach(book -> {
      System.out.println(book.getTitle());
    });
    System.out.println("Кол-во книг в списке: " + books.size());
    System.out.println("Название 5-й книги из списка: " + books.get(4).getTitle());
    System.out.println("---------");
    System.out.println("Список всех книг: " + System.lineSeparator());
    books.forEach(book -> {
      System.out.println(book.getTitle());
    });
    System.out.println("---------");
    System.out.println(String.format("Название и имя автора 3-й книги из списка: %s - %s", books.get(2).getTitle(), books.get(2).getAuthor()));
  }

  private void saxParser() throws ParserConfigurationException, SAXException, IOException {
    File file = new File(FILE_PATH);
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
    SAXParser SAXParser = new SAXParser();
    saxParser.parse(file, SAXParser);
    List<Book> books = SAXParser.getBooks();
    System.out.println("Информация о спарсенных книгах: " + System.lineSeparator());
    Path filePath = Files.createTempFile("booksSAXcontent", ".txt");
    FileWriter fileWriter = new FileWriter(filePath.toFile());
    books.forEach(book -> {
      try {
        fileWriter.write(book.toString() + System.lineSeparator());
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    });
    fileWriter.close();
    System.out.println("Список всех авторов: " + System.lineSeparator());
    books.forEach(book -> {
      System.out.println(book.getAuthor());
    });
    System.out.println("---------");
    System.out.println("Книги автора: " + AUTHOR_NAME);
    books.stream().filter(book -> book.getAuthor().equals(AUTHOR_NAME)).forEach(book -> {
      System.out.println(book.getTitle());
    });
    System.out.println("Кол-во книг в списке: " + books.size());
    System.out.println("Название 5-й книги из списка: " + books.get(4).getTitle());
    System.out.println("---------");
    System.out.println("Список всех книг: " + System.lineSeparator());
    books.forEach(book -> {
      System.out.println(book.getTitle());
    });
    System.out.println("---------");
    System.out.println(String.format("Название и имя автора 3-й книги из списка: %s - %s", books.get(2).getTitle(), books.get(2).getAuthor()));
  }

}
