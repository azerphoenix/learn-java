package info.md7.java.homeworks.hw_8.services;


import info.md7.java.homeworks.hw_8.exceptions.DeficiencyAmountOfMoneyException;
import info.md7.java.homeworks.hw_8.exceptions.ProductNotFoundException;
import info.md7.java.homeworks.hw_8.pojo.Customer;
import info.md7.java.homeworks.hw_8.pojo.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

  private static List<Customer> customers = new ArrayList<>();
  public static Customer currentCustomer = null;

  /**
   * Инициализируем дефолтных пользователей
   */
  public static void initDefaultCustomers() {
    customers.add(new Customer("admin", "admin", 5000));
    customers.add(new Customer("user", "user", 4500));
  }

  /**
   * Регистрация нового заказчика
   */
  public static void addNewCustomer()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    boolean scannerLoop = true;
    String username = null, password = null;
    double amountOfMoney = 0;
    while (scannerLoop) {
      System.out.println("Регистрация на сайте:");
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите имя пользователя:");
      username = scanner.nextLine();
      if (username == null || checkIfUsernameExists(username)) {
        System.out.println("Указанный вами пользователь существует!");
        continue;
      }
      System.out.println("Введите пароль:");
      password = scanner.nextLine();
      System.out.println("Пополните ваш счет:");
      amountOfMoney = scanner.nextDouble();
      scannerLoop = false;
    }
    Customer customer = new Customer(username, password, amountOfMoney);
    customers.add(customer);
    System.out.println("Поздравляем! Вы успешно зарегистрировались в системе!");
    printCustomerInfo(customer);
    customerLogin();
  }

  /**
   * Распечатать информацию о пользователе
   * @param customer
   */
  public static void printCustomerInfo(Customer customer)
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    System.out.println(customer);
    MenuService.showMainMenu();
  }

  /**
   * Распечатать баланс пользователя
   * @param customer
   */
  public static void getBalance(Customer customer)
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    System.out.println("Баланс вашего лицевого счета: " + customer.getAmountOfMoney());
    MenuService.showMainMenu();
  }

  /**
   * Распечатать список покупок пользователя
   * @param customer
   */
  public static void getPurchasedProducts(Customer customer)
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    List<Product> products = customer.getPurchasedProducts();
    System.out.println("Список ваших покупок: ");
    products.forEach(System.out::println);
    MenuService.showMainMenu();
  }

  /**
   * Метод для авторизации пользователя
   * @return
   */
  public static void customerLogin()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    boolean scannerLoop = true;
    while (scannerLoop) {
      System.out.println("Авторизация на сайте:");
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите логин:");
      String username = scanner.nextLine();
      if (username == null || !checkIfUsernameExists(username)) {
        System.out.println("Указанный вами пользователь не существует!");
        continue;
      }
      System.out.println("Введите пароль:");
      String password = scanner.nextLine();
      if (password == null || !checkIfPasswordIsCorrect(username, password)) {
        System.out.println("Введенный вами пароль некорректен!");
        continue;
      }
      System.out.println("Вы успешно авторизовались в системе! "
          + "Теперь, вы можете совершать покупки!");
      initCustomer(username);
      scannerLoop = false;
    }
    if (!FileService.checkIfFileExists(currentCustomer)) {
      FileService.createSerializedFile(currentCustomer);
    }
    MenuService.showMainMenu();
  }

  /**
   * Метод проверяет существует ли имя пользователя
   * @param username - имя пользователя
   * @return boolean
   */
  public static boolean checkIfUsernameExists(String username) {
    for (Customer customer : customers) {
      if (username.equals(customer.getUsername()))
        return true;
    }
    return false;
  }

  /**
   * Метод проверяет введенный пользователем пароль на корректность
   * @param username имя пользователя
   * @param password пароль
   * @return boolean
   */
  public static boolean checkIfPasswordIsCorrect(String username, String password) {
    for (Customer customer : customers) {
      if (username.equals(customer.getUsername()) && password.equals(customer.getPassword()))
        return true;
    }
    return false;
  }

  /**
   * Метод инициализирует сессию текущего пользователя
   * @param username имя пользователя
   * @return Customer
   */
  public static Customer initCustomer(String username) {
    for (Customer customer : customers) {
      if (username.equals(customer.getUsername())) {
        currentCustomer = customer;
      }
    }
    return currentCustomer;
  }

}
