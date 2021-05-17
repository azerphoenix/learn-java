package info.md7.java.homeworks.hw_8;



import info.md7.java.homeworks.hw_8.exceptions.DeficiencyAmountOfMoneyException;
import info.md7.java.homeworks.hw_8.exceptions.ProductNotFoundException;
import info.md7.java.homeworks.hw_8.services.CustomerService;
import info.md7.java.homeworks.hw_8.services.MenuService;
import info.md7.java.homeworks.hw_8.services.ProductService;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    CustomerService.initDefaultCustomers();
    ProductService.initDefaultProducts();
    try {
      MenuService.showAuthMenu();
    } catch (ProductNotFoundException exception) {
      exception.printStackTrace();
    } catch (DeficiencyAmountOfMoneyException exception) {
      exception.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
