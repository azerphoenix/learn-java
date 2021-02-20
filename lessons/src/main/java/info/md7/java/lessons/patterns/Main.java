package info.md7.java.lessons.patterns;

import info.md7.java.lessons.patterns.creational.abstractFactory.BackendDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.FrontEndDeveloper;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebDesigner;
import info.md7.java.lessons.patterns.creational.abstractFactory.WebsiteTeamFactory;
import info.md7.java.lessons.patterns.creational.abstractFactory.website.WebsiteTeamFactoryImpl;
import info.md7.java.lessons.patterns.creational.builder.User;
import info.md7.java.lessons.patterns.creational.builder.UserBuilderImpl;
import info.md7.java.lessons.patterns.creational.builder.faceted_builder.UserBuilder;
import info.md7.java.lessons.patterns.creational.builder.fluent_builder.EmployeeBuilderImpl;
import info.md7.java.lessons.patterns.creational.factory.CarFactory;
import info.md7.java.lessons.patterns.creational.factory.CarService;
import info.md7.java.lessons.patterns.creational.factory.ECar;
import info.md7.java.lessons.patterns.creational.prototype.Address;
import info.md7.java.lessons.patterns.creational.prototype.Doctor;
import info.md7.java.lessons.patterns.creational.singleton.EnumSingleton;
import info.md7.java.lessons.patterns.creational.singleton.InnerStaticSingleton;
import info.md7.java.lessons.patterns.creational.singleton.LazySingleton;
import info.md7.java.lessons.patterns.creational.singleton.Singleton;
import info.md7.java.lessons.patterns.creational.singleton.multiton.Device;
import info.md7.java.lessons.patterns.creational.singleton.multiton.OS;
import info.md7.java.lessons.patterns.structural.adapter.Database;
import info.md7.java.lessons.patterns.structural.adapter.DatabaseAdapter;
import info.md7.java.lessons.patterns.structural.bridge.Square;
import info.md7.java.lessons.patterns.structural.bridge.VectorRenderer;
import info.md7.java.lessons.patterns.structural.composite.Circle;
import info.md7.java.lessons.patterns.structural.composite.Graphic;
import info.md7.java.lessons.patterns.structural.composite.Triangle;
import info.md7.java.lessons.patterns.structural.composite.another_example.DevTeam;
import info.md7.java.lessons.patterns.structural.composite.another_example.PythonDeveloper;
import info.md7.java.lessons.patterns.structural.composite.another_example.RubyDeveloper;
import info.md7.java.lessons.patterns.structural.decorator.Developer;
import info.md7.java.lessons.patterns.structural.decorator.SeniorPythonDeveloper;
import info.md7.java.lessons.patterns.structural.facade.Workflow;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

  public static void main(String[] args) {
    facade();
  }

  /**
   * Abstract Factory
   */
  public static void abstractFactory() {
    WebsiteTeamFactory websiteTeamFactory = new WebsiteTeamFactoryImpl();
    WebDesigner webDesigner = websiteTeamFactory.getWebDesigner();
    BackendDeveloper backendDeveloper = websiteTeamFactory.getBackendDeveloper();
    FrontEndDeveloper frontEndDeveloper = websiteTeamFactory.getFrontendDeveloper();
    System.out.println(webDesigner.design());
    System.out.println(backendDeveloper.writeCode());
    System.out.println(frontEndDeveloper.writeCode());
  }

  /**
   * Factory and factory method
   */
  public static void factory() {
    CarFactory carFactory = CarService.createCarFactoryByBrand(ECar.MERCEDES);
    System.out.println(carFactory.createCar().drive());
  }

  /**
   * Singleton
   * Lazy initialized singleton
   * Inner static singleton
   * Enumerated singleton
   */
  public static void singleton() {
    System.out.println(Singleton.getInstance().toString());
    System.out.println(LazySingleton.getInstance().toString());
    System.out.println(InnerStaticSingleton.getInstance().toString());
    System.out.println(EnumSingleton.getInstance());
  }

  /**
   * MultiTon
   */
  public static void multiTon() {
    System.out.println(Device.getInstance(OS.LINUX).toString());
  }

  /**
   * Builder
   * Fluent Builder
   * Faceted builder
   */
  public static void builder() {
    User user = new UserBuilderImpl().setName("Hello").setSurname("World")
        .setLogin("Test").setPassword("12345").build();
    System.out.println(user.toString());
    info.md7.java.lessons.patterns.creational.builder.fluent_builder.User user1 = new EmployeeBuilderImpl()
        .setName("Hello").setSurname("World")
        .setLogin("Test").setPassword("12345").setPosition("Admin").build();
    System.out.println(user1.toString());
    info.md7.java.lessons.patterns.creational.builder.faceted_builder.User user2 = new UserBuilder()
        .setName("Hello").setSurname("World")
        .setAccount()
        .setLogin("admin")
        .setPassword("12345")
        .setEmployee()
        .setPosition("Developer")
        .build();
    System.out.println(user2);
  }

  /**
   * Prototype via constructor
   * Prototype via serialization
   */
  public static void prototype() {
    info.md7.java.lessons.patterns.creational.prototype.User user =
        new info.md7.java.lessons.patterns.creational.prototype.User("Hello", "World",
            new Address("a", "b", "c"));
    info.md7.java.lessons.patterns.creational.prototype.User user1 = new info.md7.java.lessons.patterns.creational.prototype.User(user);
    user1.setName("John");
    user1.getAddress().setCity("d");
    System.out.println(user1.getName() + " " + user1.getAddress().getCity());
    System.out.println(user.getName() + " " + user.getAddress().getCity());

    Doctor doctor = new Doctor("Helga", "Smith");
    Doctor doctor1 = SerializationUtils.roundtrip(doctor);
    doctor1.setName("John");
    System.out.println(doctor.getName());
    System.out.println(doctor1.getName());
  }

  /**
   * Adapter pattern
   */
  public static void adapter() {
    Database database = new DatabaseAdapter();
    System.out.println(database.update());
    System.out.println(database.create());
  }

  /**
   * Bridge pattern
   */
  public static void bridge() {
    String s = new Square(new VectorRenderer()).toString();
    System.out.println(s);
  }

  /**
   * Composite
   */
  public static void composite() {
    Graphic graphic = new Graphic();
    graphic.addGraphic(new Triangle("#ff0000"));
    graphic.addGraphic(new Circle("#cccccc"));
    graphic.addGraphic(new Circle("#ffffff"));
    graphic.addGraphic(new Triangle("#000000"));
    System.out.println(graphic);

    DevTeam devTeam = new DevTeam();
    devTeam.addDeveloper(new PythonDeveloper());
    devTeam.addDeveloper(new RubyDeveloper());
    devTeam.createWebsite();
  }

  /**
   * Decorator
   */
  public static void decorator() {
    Developer developer = new info.md7.java.lessons.patterns.structural.decorator.PythonDeveloper();
    System.out.println(developer.writeCode());
    SeniorPythonDeveloper developer1 = new SeniorPythonDeveloper(developer);
    System.out.println(developer1.writeCode());
  }

  /**
   * Facade
   */
  public static void facade() {
    Workflow workflow = new Workflow();
    System.out.println(workflow.start());
  }


}
