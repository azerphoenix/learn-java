package info.md7.java.lessons.patterns;

import info.md7.java.lessons.patterns.behavioral.chain_of_responsibility.MessageCheckHandler;
import info.md7.java.lessons.patterns.behavioral.chain_of_responsibility.MessageHandler;
import info.md7.java.lessons.patterns.behavioral.chain_of_responsibility.MessagePrintHandler;
import info.md7.java.lessons.patterns.behavioral.chain_of_responsibility.MessageUppercaseHandler;
import info.md7.java.lessons.patterns.behavioral.command.example_1.Button;
import info.md7.java.lessons.patterns.behavioral.command.example_1.CopyCommand;
import info.md7.java.lessons.patterns.behavioral.command.example_1.PasteCommand;
import info.md7.java.lessons.patterns.behavioral.command.example_2.BankAccount;
import info.md7.java.lessons.patterns.behavioral.command.example_2.BankAccountCommand;
import info.md7.java.lessons.patterns.behavioral.command.example_2.BankAccountCommand.Operation;
import info.md7.java.lessons.patterns.behavioral.interpreter.example_1.Expression;
import info.md7.java.lessons.patterns.behavioral.interpreter.example_1.Runner;
import info.md7.java.lessons.patterns.behavioral.iterator.example_1.Iterator;
import info.md7.java.lessons.patterns.behavioral.iterator.example_2.Employee;
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
import info.md7.java.lessons.patterns.structural.composite.example_1.Circle;
import info.md7.java.lessons.patterns.structural.composite.example_1.Graphic;
import info.md7.java.lessons.patterns.structural.composite.example_1.Triangle;
import info.md7.java.lessons.patterns.structural.composite.example_2.DevTeam;
import info.md7.java.lessons.patterns.structural.composite.example_2.PythonDeveloper;
import info.md7.java.lessons.patterns.structural.composite.example_2.RubyDeveloper;
import info.md7.java.lessons.patterns.structural.decorator.example_1.Developer;
import info.md7.java.lessons.patterns.structural.decorator.example_1.SeniorPythonDeveloper;
import info.md7.java.lessons.patterns.structural.decorator.example_2.Dragon;
import info.md7.java.lessons.patterns.structural.facade.Workflow;
import info.md7.java.lessons.patterns.structural.flyweight.Vehicle;
import info.md7.java.lessons.patterns.structural.flyweight.VehicleFactory;
import info.md7.java.lessons.patterns.structural.proxy.example_1.CustomReader;
import info.md7.java.lessons.patterns.structural.proxy.example_1.ProxyReader;
import info.md7.java.lessons.patterns.structural.proxy.example_1.Reader;
import info.md7.java.lessons.patterns.structural.proxy.example_2.ReaderInvocationHandler;
import java.awt.Color;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

  public static void main(String[] args) {
    iterator();
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
    Developer developer = new info.md7.java.lessons.patterns.structural.decorator.example_1.PythonDeveloper();
    System.out.println(developer.writeCode());
    SeniorPythonDeveloper developer1 = new SeniorPythonDeveloper(developer);
    System.out.println(developer1.writeCode());

    Dragon dragon = new Dragon();
    dragon.crawl();
    dragon.fly();
  }

  /**
   * Facade
   */
  public static void facade() {
    Workflow workflow = new Workflow();
    System.out.println(workflow.start());
  }

  /**
   * Flyweight
   */
  public static void flyweight() {
    Vehicle vehicle = VehicleFactory.createVehicle(Color.BLACK);
    Vehicle vehicle1 = VehicleFactory.createVehicle(Color.BLACK);
    System.out.println(vehicle + " " + vehicle1);
  }

  /**
   * Proxy
   */
  public static void proxy() {
    String a = new CustomReader().read("Hello World");
    System.out.println(a);
    new ProxyReader().read("John Smith");

    // Dynamic proxy via InvocationHandler
    InvocationHandler readerInvocationHandler = new ReaderInvocationHandler();
    Object proxyInstance = Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Reader.class},
        readerInvocationHandler);
    ((Reader) proxyInstance).read("Brave new world");
  }

  /**
   * Chain of responsibility
   */
  public static void chainOfResponsibility() {
    MessageHandler messageHandler = new MessageCheckHandler(new MessageUppercaseHandler(new MessagePrintHandler(null)));
    messageHandler.handle("Abra Kadabra");
  }

  /**
   * Command
   */
  public static void command() {
    BankAccount bankAccount = new BankAccount();
    bankAccount.deposit(10000);
    List<BankAccountCommand> bankAccountCommands = List.of(
        new BankAccountCommand(bankAccount, Operation.DEPOSIT, 100),
        new BankAccountCommand(bankAccount, Operation.DEPOSIT, 200),
        new BankAccountCommand(bankAccount, Operation.WITHDRAW, 400),
        new BankAccountCommand(bankAccount, Operation.DEPOSIT, 500),
        new BankAccountCommand(bankAccount, Operation.WITHDRAW, 800)
    );
    bankAccountCommands.forEach(BankAccountCommand::call);

    Button copyButton = new Button();
    copyButton.pressButton(new CopyCommand());
    Button pasteButton = new Button();
    pasteButton.pressButton(new PasteCommand());
  }

  /**
   * Interpreter
   */
  public static void interpreter() {
    Expression isJavaDeveloper = Runner.getJavaExpression();
    Expression isJavaEEDeveloper = Runner.getJavaEEExpression();
    System.out.println(isJavaDeveloper.interpret("Java Core"));
    System.out.println(isJavaEEDeveloper.interpret("Java Spring"));
  }

  /**
   * Iterator
   */
  public static void iterator() {
    String[] skills = {"Java", "Python", "WordPress", "Django", "Spring"};
    info.md7.java.lessons.patterns.behavioral.iterator.example_1.User user = new info.md7.java.lessons.patterns.behavioral.iterator.example_1.User(skills);
    Iterator iterator = user.getIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }

    List<String> employeeSkills = List.of(skills);
    Employee employee = new Employee(employeeSkills);
    for (String skill : employee) {
      System.out.println(skill);
    }
  }
}
