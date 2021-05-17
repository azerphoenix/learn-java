package info.md7.java.lessons.other;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerExample {

    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("Hello");
        stringJoiner.add("World");
        System.out.println(stringJoiner);

        String phoneNumber = String.join("-", "375", "29", "899", "77", "61");
        System.out.println(phoneNumber);

        List<String> databases = Arrays.asList("OracleDB", "Mongo", "PostgreSQL", "MySQL");
        String string = String.join(", ", databases);
        System.out.println(string);

        List<String> frameworks = Arrays.asList("Spring", "Hibernate", "JPA", "JSF");
        String collect = frameworks.stream()
                .collect(Collectors.joining("; "));
        System.out.println(collect);


    }

}
