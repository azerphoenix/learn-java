package info.md7.java.homeworks.hw_10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

  /**
   * Метод парсит xml файл и возвращает список спарсенных книг
   * @param filePath Путь к xml файлу
   * @return List\<Book\>
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws SAXException
   */
  public static List<Book> parse(String filePath) throws ParserConfigurationException, IOException, SAXException {
    List<Book> books = new ArrayList<>();
    File file = new File(filePath);
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse(file);
    document.getDocumentElement().normalize();
    NodeList nodeList = document.getElementsByTagName("book");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String title = element.getElementsByTagName("title").item(0).getTextContent();
        String author = element.getElementsByTagName("author").item(0).getTextContent();
        String shot_content = element.getElementsByTagName("shot_content").item(0).getTextContent();
        books.add(new Book(title, author, shot_content));
      }
    }
    return books;
  }

}
