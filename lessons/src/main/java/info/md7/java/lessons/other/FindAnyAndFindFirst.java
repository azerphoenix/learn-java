package info.md7.java.lessons.other;

import java.util.List;
import java.util.Optional;

public class FindAnyAndFindFirst {

    public static void main(String[] args) {

        Optional<Book> first = getBooks().stream().peek(System.out::println).findFirst();
        System.out.println(first.get());

        Optional<Book> second = getBooks().stream().findAny();
        System.out.println(second.get());

        Optional<Book> third = getBooks().stream().filter(book -> book.getBookName().contains("Сто")).findFirst();
        System.out.println(third.get());

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
