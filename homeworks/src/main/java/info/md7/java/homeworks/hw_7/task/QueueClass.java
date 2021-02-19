package info.md7.java.homeworks.hw_7.task;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class QueueClass {

  public void printPatients() {
    String[] patientsList = new String[]{
        "Василий Иванович", "Николай Петрович","Анастасия Сергеевна", "Наталья Игоревна",
        "Евгений Петрович", "Александр Николаевич", "Игорь Александрович",
        "Владимир Исаевич", "Евгения Александровна", "Анастасия Владимировна",
        "Мария Игоревна", "Лидия Николаевна", "Андрей Григорьевич"
    };
    Deque<String> patientsQueue = new LinkedList<>();
    Arrays.stream(patientsList).forEach(patientsQueue::offer);
    System.out.println("Очередь пациентов");
    patientsQueue.forEach(System.out::println);

    System.out.println("Прием пациентов начался: ");
    for (int i = 0; i < patientsQueue.size(); i++) {
      if((i+1) % 3 == 0) {
        System.out.println("Подошла очередь пациента (каждая 3-я итерация) - " + patientsQueue.pollLast());
      }
      System.out.println("Подошла очередь пациента - " + patientsQueue.pollFirst());
    }
  }

  public void printKnockoutRaceResults() {
    String[] cars = new String[] {
        "Car 1", "Car 2", "Car 3", "Car 4", "Car 5", "Car 6", "Car 7", "Car 8", "Car 9",
        "Car 9", "Car 10", "Car 11", "Car 12", "Car 13", "Car 14", "Car 15", "Car 17"
    };
    List<String> carsList = Arrays.asList(cars);
    Collections.shuffle(carsList);
    Deque<String> racingCars = new ArrayDeque<>(carsList);
    for (int i = 0; i < racingCars.size(); i++) {
      System.out.println("Машина " + racingCars.pollLast() + " выбыла из игры");
    }
  }

}
