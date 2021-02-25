package info.md7.java.lessons.patterns.behavioral.template_method.example_1;

public abstract class WebsiteTemplate {

  public void showPage() {
    System.out.println("Header");
    showPageContent();
    System.out.println("Footer");
  }

  public abstract void showPageContent();
}
