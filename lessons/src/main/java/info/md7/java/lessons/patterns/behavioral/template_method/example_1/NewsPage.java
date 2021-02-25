package info.md7.java.lessons.patterns.behavioral.template_method.example_1;

public class NewsPage extends WebsiteTemplate {

  @Override
  public void showPageContent() {
    System.out.println("Here is list of news");
  }
}
