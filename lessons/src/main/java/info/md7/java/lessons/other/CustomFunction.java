package info.md7.java.lessons.other;

import java.util.function.Function;

public class CustomFunction {

    public static void main(String[] args) {

        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("10");
        System.out.println(integer);

        Function<String, Integer> toInteger2 = CustomFunction::parse;
        Integer integer1 = toInteger2.apply("20");
        System.out.println(integer1);

    }


    private static Integer parse(String intStr) {
        return Integer.parseInt(intStr);
    }


}
