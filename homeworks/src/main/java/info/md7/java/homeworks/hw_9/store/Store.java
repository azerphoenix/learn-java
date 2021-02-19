package info.md7.java.homeworks.hw_9.store;


import info.md7.java.homeworks.hw_9.pojo.Transport;
import java.util.List;

public class Store<T extends Transport> {

  private double amountOfMoney = 1_000_000;
  private volatile List<T> products;

  public Store(List<T> products) {
    this.products = products;
  }

  /**
   * Метод распечатывает список продуктов
   */
  public void printProducts() {
    for (int i = 0; i < products.size(); i++) {
      T transport = products.get(i);
      System.out.println("Индекс товара: " + i + "\n" + transport);
    }
  }

  /**
   * Метод для добавления товара в магазин
   * @param product
   */
  public synchronized void put (T product) {
    while (products.size() >= 3) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (product != null) {
      products.add(product);
    }
    notify();
  }

  /**
   * Метод для приобретения товара из магазина
   * @param productIndex Индекс товара в списке ArrayList
   * @param preferredPrice Предпочитаемая стоимость товара
   * @param consumer Покупатель
   * @return Transport
   */
  public synchronized T get(int productIndex, double preferredPrice, Consumer consumer) {
    while (products.size() < 1) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    T product = this.products.get(productIndex);
    if(consumer.getBalance() >= product.getPrice()) {
      if (preferredPrice < product.getPrice()) {
        System.out.println("Вы не можете приобрести этот товар по указанной стоимости\n");
      } else {
        consumer.setBalance(consumer.getBalance() - preferredPrice);
        amountOfMoney += preferredPrice;
        products.remove(product);
        System.out.println("Поздравляем, Вы успешно приобрели товар: " + product.getName());
        if (preferredPrice > product.getPrice()) {
          double changeFromMoney = preferredPrice - product.getPrice();
          consumer.setBalance(consumer.getBalance() - changeFromMoney);
          amountOfMoney -= changeFromMoney;
          System.out.println("Ваша сдача составляет: " + changeFromMoney + " \n");
        }
      }
    }
    notify();
    return product;
  }

  public List<T> getProducts() {
    return products;
  }

}
