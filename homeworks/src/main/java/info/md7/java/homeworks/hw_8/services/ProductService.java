package info.md7.java.homeworks.hw_8.services;


import info.md7.java.homeworks.hw_8.exceptions.DeficiencyAmountOfMoneyException;
import info.md7.java.homeworks.hw_8.exceptions.ProductNotFoundException;
import info.md7.java.homeworks.hw_8.pojo.Customer;
import info.md7.java.homeworks.hw_8.pojo.Product;
import info.md7.java.homeworks.hw_8.pojo.ProductType;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductService {

  private static List<Product> products = new ArrayList<>();

  /**
   * Инициализируем дефолтные товары
   */
  public static void initDefaultProducts() {
    products.add(new Product(1, "Электрогитара - Ibanez RG 421",
        ProductType.MUSICAL_INSTRUMENTS, LocalDate.now(), 600));
    products.add(new Product(2, "Смартфон - Samsung A70",
        ProductType.PHONES_TABLETS, LocalDate.now(), 800));
    products.add(new Product(3, "Телевизор - Philips PFL 550",
        ProductType.TV_AUDIO_PHOTO_VIDEO, LocalDate.now(), 1200));
    products.add(new Product(4, "Стиральная машина - Beko A100",
        ProductType.APPLIANCES, LocalDate.now(), 300));
    products.add(new Product(5, "Ноутбук - Dell Inspiron 5515",
        ProductType.COMPUTERS, LocalDate.now(), 1000));
    products.add(new Product(6, "Ноутбук - Apple MacBook Air",
        ProductType.COMPUTERS, LocalDate.now(), 9000));
  }

  /**
   * Распечатать информацию о продуктах
   */
  public static void printAllProducts()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException { ;
    products.forEach(System.out::println);
    productsStore();
  }

  /**
   * Метод для совершения покупок в магазине
   */
  public static void productsStore()
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите один или несколько productId's (через запятую)"
        + " для приобретения выбранных товаров. Например, 1,2,3");
    String productIds = scanner.nextLine();
    String[] productIdsStringArr = productIds.split(",");
    List<Integer> productIdsList = new ArrayList<>();
    Arrays.stream(productIdsStringArr).forEach(productId -> {
      productIdsList.add(Integer.parseInt(productId));
    });
    buyProducts(productIdsList);
  }

  /**
   * Проверяет существует ли товар с указанным productId
   * @param productId
   * @return
   */
  public static boolean existsByProductId(long productId) {
    for (Product product : products) {
      if(product.getProductId() == productId)
        return true;
    }
    return false;
  }

  /**
   * Метод для приобретения товаров. Проверяет наличие товара и при наличии снимает с продажи
   * сняв нужную сумму со счета пользователя
   * @param productIds
   */
  public static void buyProducts(List<Integer> productIds)
      throws ProductNotFoundException, DeficiencyAmountOfMoneyException, IOException {
    Customer currentCustomer = CustomerService.currentCustomer;
    for (int productId : productIds) {
      if (!existsByProductId(productId)) {
        throw new ProductNotFoundException("Вы указали несуществующий productId товара");
      }
      for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
        Product product = iterator.next();
        if (productId == product.getProductId()) {
          if (currentCustomer.getAmountOfMoney() >= product.getCost()) {
            currentCustomer.getPurchasedProducts().add(product);
            iterator.remove();
            currentCustomer
                .setAmountOfMoney(currentCustomer.getAmountOfMoney() - product.getCost());
            System.out.println("Вы успешно приобрели товар: " + product.getProductName());
            System.out.println("С вашего счета была снята сумма: " + product.getCost());
          } else {
            throw new DeficiencyAmountOfMoneyException("Для совершения операции на вашем лицевом счете "
                + "недостаточно средств");
          }
        }
      }
    }
    MenuService.showMainMenu();
  }

}
