package info.md7.java.homeworks.hw_7.workbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercise_27 {

  public static void main(String[] args) {
    List<Integer> randomIntegersList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i <= 100; i++){
      randomIntegersList.add(random.nextInt(30));
    }
    System.out.println("Список случайных чисел:");
    randomIntegersList.forEach(System.out::println);

    List<Integer> listWithoutDuplicates = randomIntegersList.stream().distinct().collect(Collectors.toList());
    System.out.println("Список случайных чисел после удаления дубликатов:");
    listWithoutDuplicates.forEach(System.out::println);

    System.out.println("Размер списка после удаления дубликатов: " + listWithoutDuplicates.size());
  }

}
