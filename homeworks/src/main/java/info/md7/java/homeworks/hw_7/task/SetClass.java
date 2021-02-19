package info.md7.java.homeworks.hw_7.task;


import info.md7.java.homeworks.hw_7.task.pojo.BankCard;
import info.md7.java.homeworks.hw_7.task.pojo.Item;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {

  public static final double ITEM_MAX_WEIGHT = 10;

  /**
   * Метод создает Set с банковскими карточками и выводит их в консоль.
   * @return Set\<BankCard\>
   */
  public void printBankCards(){
    Set<BankCard> bankCards = new HashSet<>();
    bankCards.add(new BankCard("John Smith", "1234_5678_9000_0000", 123, LocalDate.now() ));
    bankCards.add(new BankCard("Mark Jacobs", "1133_2485_7896_4200", 657, LocalDate.now() ));
    bankCards.add(new BankCard("Jane Eyre", "4000_1111_9080_7800", 243, LocalDate.now() ));
    bankCards.add(new BankCard("Selena Johns", "4869_1781_0580_7450", 644, LocalDate.now() ));
    bankCards.forEach(System.out::println);
  }

  /**
   * Метод создает TreeSet товаров после чего суммирует их вес и удаляет поочередно лишние
   * элементы из сета приравнивая общий вес к константе обозначенной выше и распечатывает
   * список товаров
   */
  public void printItems() {
    TreeSet<Item> items = new TreeSet<>();
    items.add(new Item(1,"Dell Inspiron N5110", 4.5));
    items.add(new Item(2, "Dell Inspiron N5000", 4.7));
    items.add(new Item(3,"Dell Inspiron N5050", 4.87));
    items.add(new Item(4,"Dell Inspiron N3000", 4.10));
    System.out.println("Исходный список товаров: ");
    items.forEach(System.out::println);

    double totalWeight = 0;
    boolean normalWeight = true;
    while(normalWeight) {
      for (Item item : items) {
        totalWeight += item.getWeight();
      }
      if (totalWeight >= ITEM_MAX_WEIGHT) {
        items.pollFirst();
        totalWeight = 0;
      } else {
        normalWeight = false;
      }
    }
    System.out.println("Итоговый суммарный вес товаров после удаления лишних: " + totalWeight);
    System.out.println("Итоговый список товаров: ");
    items.forEach(System.out::println);
  }

}
