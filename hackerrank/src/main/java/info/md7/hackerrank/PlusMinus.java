package info.md7.hackerrank;

import java.util.List;

// https://www.hackerrank.com/challenges/plus-minus/problem
public class PlusMinus {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(-4, 3, -9, 0, 4, 1);
        plusMinus(integerList);
    }

    /**
     * Count positive, negative & zero number
     * Then get ratio of this counts
     * @param arr
     */
    public static void plusMinus(List<Integer> arr) {
        int arrSize = arr.size();
        int positivesCount = 0;
        int negativesCount = 0;
        int zerosCount = 0;
        for (int i : arr) {
            if (i > 0) {
                positivesCount++;
            } else if (i < 0) {
                negativesCount++;
            } else {
                zerosCount++;
            }
        }
        System.out.println((double) positivesCount / arrSize);
        System.out.println((double) negativesCount / arrSize);
        System.out.println((double) zerosCount / arrSize);
    }
}
