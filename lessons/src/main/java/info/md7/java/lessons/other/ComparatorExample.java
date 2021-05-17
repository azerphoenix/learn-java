package info.md7.java.lessons.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>(getBooks());
        System.out.println("До сортировки:");
        books.forEach(System.out::println);

        Comparator<Book> bookComparable = Comparator.comparingInt(Book::getYear);
        books.sort(bookComparable.reversed());

        System.out.println();
        System.out.println("После сортировки:");
        books.forEach(System.out::println);
    }


    private static List<Book> getBooks() {

        return List.of(
                new Book("Гарри Поттер и Философский камень", "Джоан Роулинг", 1998),
                new Book("Гарри Поттер и Тайная комната", "Джоан Роулинг", 1999),
                new Book("Гарри Поттер и Узник Азкабана", "Джоан Роулинг", 2000),
                new Book("Гарри Поттер и Дары смерти", "Джоан Роулинг", 2009),
                new Book("Сто лет одиночества", "Габриель Гарсия Маркес", 1990)
        );

    }


}
