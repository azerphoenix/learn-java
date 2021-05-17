package info.md7.java.lessons.other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Введите первое число:");
            int a = sc.nextInt();

            sc.nextLine();

            System.out.println("Введите операцию:");
            char operator = sc.nextLine().charAt(0);

            System.out.println("Введите второе число:");
            int b = sc.nextInt();

            int result = 0;
            if (operator == '+') {
                result = a + b;
            } else if (operator == '-') {
                result = a - b;
            } else if (operator == '*') {
                result = a * b;
            } else if (operator == '/') {
                result = a / b;
            }
            System.out.println("Результат: " + result);

            sc.nextLine();

            System.out.println("Для выхода из программы введите - q");
            char c = sc.nextLine().charAt(0);
            if (c == ('q')) {
                System.exit(0);
            }

        } while (true);
    }

}