package info.md7.java.homeworks.hw_7.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListClass {

  /**
   * Метод создает список и добавляет строки в начало и конец списка
   * @return List\<String\>
   */
  public List<String> createList() {
    List<String> customList = new ArrayList<>();
    customList.add("Re in secunda tollere animos, in mala demittere");
    customList.add("Rebus in adversis animam amittere noli, spem retine");
    customList.add("Rebus in adversis melius sperare memento");
    customList.add(0, "Recoctus senex");
    customList.add(0, "Recte facti fecisse merces est");
    customList.add(0, "Reddere oleo tranquilliorem");
    customList.add(0, "Reductio ad absurdum");
    customList.add(customList.size(), "Refert, quam quis bene vivat, quam diu non refert");
    return customList;
  }

  /**
   * Метод реализует основные принципы игры Дженга
   */
  public void jenga() {
    List<String> customList = createList();
    Random random = new Random();
    int index = getRandomNumWithExclusion(random, 0, customList.size(), 0, customList.size());
    String randomString = customList.get(index);
    customList.remove(index);
    customList.add(customList.size(), randomString);
    customList.forEach(System.out::println);
  }

  /**
   * Метод возвращает рандомное число за исключением выбранных чисел
   * @param rnd Random
   * @param start начальное число
   * @param end конечное число
   * @param exclude числа, которые нужно исключить из рандома
   * @return случайное число
   */
  private int getRandomNumWithExclusion(Random rnd, int start, int end, int... exclude) {
    int random = start + rnd.nextInt(end - start + 1 - exclude.length);
    for (int ex : exclude) {
      if (random < ex) {
        break;
      }
      random++;
    }
    return random;
  }

}
