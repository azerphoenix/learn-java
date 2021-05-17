package info.md7.java.lessons.other;

import java.util.List;

public class StreamMatch {

    public static void main(String[] args) {

        boolean one = getBooks().stream().allMatch(book -> book.getBookName().contains("Гарри"));
        boolean two = getBooks().stream().anyMatch(book -> book.getBookName().contains("Гарри"));
        System.out.println(one);
        System.out.println(two);
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
