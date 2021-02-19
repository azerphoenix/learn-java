package info.md7.java.homeworks.hw_6.store;


import info.md7.java.homeworks.hw_6.pojo.Transport;
import java.lang.reflect.Array;

public class Store<T extends Transport> {

  private double amountOfMoney = 1_000_000;
  private T[] products;

  public Store(T[] products) {
    this.products = products;
  }

  /**
   * Метод распечатывает информацию об ассортименте товаров, имеющихся в магазине
   */
  @SuppressWarnings("unchecked")
  public void printProducts() {
    T[] storeProducts = (T[]) this.getProducts();
    StringBuilder productsInfo = new StringBuilder();
    productsInfo.append("Товары имеющиеся в наличии: \n");
    for (int i = 0; i < storeProducts.length; i++) {
      productsInfo.append("Индекс товара: ").append(i).append(" \n");
      productsInfo.append("Информация о товаре: ").append(storeProducts[i].toString()).append(" \n");
      productsInfo.append("---\n");
    }
    System.out.println(productsInfo);
  }

  /**
   * Метод для приобретения выбранного клиентом товара
   * @param productIndex индекс товара, который необходимо приобрести
   * @param preferredPrice предпочитаемая цена, за которую клиент хочет купить товар
   */
  public T purchase(int productIndex, double preferredPrice) {
    T product = products[productIndex];
    if(preferredPrice < product.getPrice()) {
      System.out.println("На вашем счету недостаточно средств для приобретения данного товара\n");
    } else {
      amountOfMoney += preferredPrice;
      products = removeProduct(products, productIndex, product.getClass());
      System.out.println("Поздравляем, Вы успешно приобрели товар!\n");
      if (preferredPrice > product.getPrice()) {
        double changeFromMoney = preferredPrice - product.getPrice();
        amountOfMoney -= changeFromMoney;
        System.out.println("Ваша сдача составляет: " + changeFromMoney + " \n");
      }
    }
    return product;
  }

  /**
   * Метод для продажи выбранного товара
   * @param product товар, подлежащий к продаже
   * @param askingPrice запрашиваемая цена
   */
  public void sell(T product, double askingPrice) {
    if(askingPrice > amountOfMoney) {
      System.out.println("В кассе нет достаточной суммы денег для приобретения вашего товара");
      return;
    }
    if(product.getPrice() < askingPrice) {
      System.out.println("Запрашиваемая стоимость за товар больше рыночной стоимости товара");
      return;
    }
    amountOfMoney -= askingPrice;
    products = addProduct(product, products, product.getClass());
    System.out.println("Поздравляем! Вы успешно продали ваш товар!");
  }

  /**
   * Метод для удаления приобретенного товара из массива.
   * @param products массив товаров
   * @param productIndex индекс приобретенного товара
   * @return оставшийся массив товаров
   */
  @SuppressWarnings("unchecked")
  private <T> T[] removeProduct(T[] products, int productIndex, Class<?> clazz) {
    T[] remainingProducts = (T[]) Array.newInstance(clazz, products.length - 1);
    for (int i = 0, k = 0; i < products.length; i++) {
      if (i == productIndex) {
        continue;
      }
      remainingProducts[k++] = products[i];
    }
    products = remainingProducts;
    return products;
  }

  @SuppressWarnings("unchecked")
  private <T> T[] addProduct(T product, T[] products, Class<?> clazz) {
    T[] remainingProducts = (T[]) Array.newInstance(clazz, products.length + 1);
    for (int i = 0; i < products.length; i++) {
      remainingProducts[i] = products[i];
    }
    remainingProducts[products.length] = product;
    products = remainingProducts;
    return products;
  }

  public double getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public T[] getProducts() {
    return products;
  }

  public void setProducts(T[] products) {
    this.products = products;
  }
}
