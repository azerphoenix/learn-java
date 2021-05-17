package info.md7.java.lessons.other;

import java.util.List;
import java.util.stream.Collectors;

public class CollectGroupingBy {

    public static void main(String[] args) {

        var collect = getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getBookAuthor));
        System.out.println(collect);

        var collect1 = getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getBookAuthor, Collectors.counting()));
        System.out.println(collect1);

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
