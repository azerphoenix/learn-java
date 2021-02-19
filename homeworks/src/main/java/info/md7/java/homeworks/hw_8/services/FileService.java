package info.md7.java.homeworks.hw_8.services;


import info.md7.java.homeworks.hw_8.exceptions.DeficiencyAmountOfMoneyException;
import info.md7.java.homeworks.hw_8.exceptions.ProductNotFoundException;
import info.md7.java.homeworks.hw_8.pojo.Customer;
import info.md7.java.homeworks.hw_8.pojo.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {

  /**
   * Метод создает временный файл в директории /tmp || /temp
   * @param customer
   * @throws IOException
   */
  public static void createFile(Customer customer)
      throws IOException {
    Path tempFilePath = Files.createTempFile(customer.getUsername(), ".txt");
    customer.setSavedDataPath(tempFilePath.toString());
  }

  /**
   * Метод создает файл для хранения сериализованной информации в указанной директории
   * @param customer
   * @throws IOException
   */
  public static void createSerializedFile(Customer customer) throws IOException {
    String path = System.getProperty("user.home") + File.separator + customer.getUsername() + "_purchaseList.txt";
    File file = new File(path);
    boolean fileCreationStatus = file.createNewFile();
    if (fileCreationStatus)
      customer.setSerializedDataPath(path);
  }

  /**
   * Метод проверяет наличие файла
   * @param customer
   * @return
   */
  public static boolean checkIfFileExists(Customer customer) {
    String path = System.getProperty("user.home") + File.separator + customer.getUsername() + "_purchaseList.txt";
    File file = new File(path);
    if (file.exists()) {
      return true;
    }
    return false;
  }

  /**
   * Метод записывает информацию в файл
   * @param filePath
   * @param text
   * @throws IOException
   */
  public static void writeToFile(String filePath, String text)
      throws IOException, ProductNotFoundException, DeficiencyAmountOfMoneyException {
    Files.write(Paths.get(filePath), text.getBytes());
    System.out.println("Ваши данные сохранены по пути: " + filePath);
    MenuService.showMainMenu();
  }

  /**
   * Записать сериализованные данные (товары)
   * @param customer
   */
  public static void writeSerializedData(Customer customer)
      throws DeficiencyAmountOfMoneyException, IOException, ProductNotFoundException {
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(customer.getSerializedDataPath())))
    {
      List<Product> products = customer.getPurchasedProducts();
      oos.writeObject(products);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    MenuService.showMainMenu();
  }

  /**
   * Метод для десериализации данных (товаров)
   * @param customer
   */
  public static void readSerializedData(Customer customer)
      throws DeficiencyAmountOfMoneyException, IOException, ProductNotFoundException {
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(customer.getSerializedDataPath())))
    {
      List<Product> products = (List<Product>) ois.readObject();
      products.forEach(System.out::println);
    } catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    MenuService.showMainMenu();
  }

}
