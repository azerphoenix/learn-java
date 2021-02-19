package info.md7.java.homeworks.hw_8.services;


import info.md7.java.homeworks.hw_8.exceptions.DeficiencyAmountOfMoneyException;
import info.md7.java.homeworks.hw_8.exceptions.ProductNotFoundException;
import info.md7.java.homeworks.hw_8.pojo.Customer;
import java.io.IOException;
import java.util.Scanner;

public class MenuService {

  /**
   * Метод выводит меню авторизации пользователя
   */
  public static void showAuthMenu()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    Scanner authScanner = new Scanner(System.in);
    System.out.println("Здравствуйте! Выберите соответствующий пункт: \n"
        + "1 - Регистрация\n"
        + "2 - Вход");
    int selection = authScanner.nextInt();
    switch (selection) {
      case 1:
        CustomerService.addNewCustomer();
        break;
      case 2:
        CustomerService.customerLogin();
        break;
      default:
        System.out.println("Вы указали некорректое значение!");
    }
  }

  /**
   * Метод выводит главное меню пользователя
   */
  public static void showMainMenu()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    Customer currentCustomer = CustomerService.currentCustomer;
    Scanner mainMenuScanner = new Scanner(System.in);
    System.out.println("Главное меню - "
        + "Для навигации выберите соответствующий пункт меню:\n"
        + "1 - Просмотреть список доступных товаров\n"
        + "2 - Просмотреть список покупок\n"
        + "3 - Проверить лицевой счет\n"
        + "4 - Посмотреть профиль\n"
        + "5 - Экспортировать мои покупки\n"
        + "6 - Экспортировать (сериализовать) данные\n"
        + "7 - Распечатать сериализованные данные\n"
        + "8 - Выход их программы"
    );
    int selection = mainMenuScanner.nextInt();
    switch (selection) {
      case 1:
        ProductService.printAllProducts();
        break;
      case 2:
        CustomerService.getPurchasedProducts(currentCustomer);
        break;
      case 3:
        CustomerService.getBalance(currentCustomer);
        break;
      case 4:
        CustomerService.printCustomerInfo(currentCustomer);
        break;
      case 5:
        FileService.createFile(currentCustomer);
        FileService.writeToFile(currentCustomer.getSavedDataPath(), currentCustomer.getPurchasedProducts().toString());
        break;
      case 6:
        FileService.writeSerializedData(currentCustomer);
        break;
      case 7:
        FileService.readSerializedData(currentCustomer);
        break;
      case 8:
        System.exit(0);
        break;
      default:
        System.out.println("Вы указали некорректое значение!");
    }
  }

}
