package info.md7.java.lessons;

import info.md7.java.lessons.multithreading.CallableImpl;
import info.md7.java.lessons.multithreading.RunnableImpl;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.lang3.SerializationUtils;

public class Main {

  public static void main(String[] args) {
    prototype();
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
   * Multithreading via implementing Runnable
   */
  public static void multithreadingRunnable() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i <= 100; i++) {
      executorService.execute(new RunnableImpl(i));
    }
    executorService.shutdown();
  }

  /**
   * Multithreading via implementing Callable
   */
  public static void multithreadingCallable() {
    ExecutorService executorService = Executors.newCachedThreadPool();
    List<Future<String>> futureList = new ArrayList<>();
    for (int i = 0; i <= 100; i++) {
      Future<String> a = executorService.submit(new CallableImpl());
      futureList.add(a);
    }
    executorService.shutdown();
    for (Future<String> future : futureList) {
      try {
        System.out.println(future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }


}
