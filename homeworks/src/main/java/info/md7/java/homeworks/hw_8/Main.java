package info.md7.java.homeworks.hw_8;

import OrkhanHasanli_Task8.exceptions.DeficiencyAmountOfMoneyException;
import OrkhanHasanli_Task8.exceptions.ProductNotFoundException;
import OrkhanHasanli_Task8.services.CustomerService;
import OrkhanHasanli_Task8.services.MenuService;
import OrkhanHasanli_Task8.services.ProductService;
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
