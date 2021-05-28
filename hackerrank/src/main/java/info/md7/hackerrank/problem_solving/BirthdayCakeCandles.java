package info.md7.hackerrank.problem_solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem
public class BirthdayCakeCandles {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        integerList.add(3);
        System.out.println(birthdayCakeCandles(integerList));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        Collections.sort(candles);
        return Collections.frequency(candles, candles.get(candles.size() - 1));
    }
}
