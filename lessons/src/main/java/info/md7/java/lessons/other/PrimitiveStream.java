package info.md7.java.lessons.other;

import java.util.stream.IntStream;

public class PrimitiveStream {

    public static void main(String[] args) {
        /*IntStream intStream1 = IntStream.range(1, 100).filter(i -> i % 2 == 0);*/
        /*intStream1.forEach(System.out::println);*/
        int sum = IntStream.range(1, 100).filter(i -> i % 2 == 0).sum();

        System.out.println("Сумма: " + sum);

    }
}
