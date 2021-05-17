package info.md7.java.lessons.other;

import java.util.Optional;

public class JavaOptional {

    public static void main(String[] args) {

        Optional<String> str1 = Optional.of("Hello World");
        System.out.println(str1.get());

        Optional<String> str2 = Optional.ofNullable(null);
        System.out.println(str2.isPresent());
        str2.ifPresent(s -> System.out.println(s));

        Optional<String> str3 = Optional.ofNullable(null);
        System.out.println(str3.orElse("Возвращаем другое значение"));

        Optional<String> str4 = Optional.ofNullable(null);
        System.out.println(str4.orElseGet(() -> "Вот, так и живем"));

        /*Optional<String> str5 = Optional.ofNullable(null);
        System.out.println(str5.orElseThrow( () -> new IllegalStateException()) );*/

       /* Optional<String> str5 = Optional.ofNullable(null);
        System.out.println(str5.orElseThrow(IllegalStateException::new));*/

        Optional<String> str6 = Optional.of("Hello World");
        System.out.println(str6.map(String::toUpperCase).get());
    }

}
