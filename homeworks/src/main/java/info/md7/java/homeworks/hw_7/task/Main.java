package info.md7.java.homeworks.hw_7.task;

public class Main {

  public static void main(String[] args) {
    ListClass listClass = new ListClass();
    System.out.println("Пример использования List'a");
    listClass.createList().forEach(System.out::println);
    System.out.println("Пример игры Дженга");
    listClass.jenga();

    MapClass mapClass = new MapClass();
    mapClass.addNewUser("user1", "Александр Иванович");
    mapClass.addNewUser("userrr", "Антон Григорьевич");
    mapClass.deleteUser("admin");
    mapClass.printUsers();

    SetClass setClass = new SetClass();
    System.out.println("Пример использования HashSet'a. \nСписок банковских карточек: ");
    setClass.printBankCards();
    System.out.println("Пример использования TreeSet'a.");
    setClass.printItems();

    SortingClass sortingClass = new SortingClass();
    sortingClass.printPupils();

    QueueClass queueClass = new QueueClass();
    queueClass.printPatients();
    queueClass.printKnockoutRaceResults();
  }

}
