package info.md7.hackerrank.problem_solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        /*integerList.add(1);
        integerList.add(5);
        integerList.add(3);
        integerList.add(9);
        integerList.add(7);*/
        integerList.add(256741038);
        integerList.add(623958417);
        integerList.add(467905213);
        integerList.add(714532089);
        integerList.add(938071625);
        miniMaxSum(integerList);
    }


    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long minSum = (long)arr.get(0) + (long)arr.get(1) + (long)arr.get(2) + (long)arr.get(3);
        long maxSum = (long)arr.get(1) + (long)arr.get(2) + (long)arr.get(3) + (long)arr.get(4);

        System.out.println(minSum + " " + maxSum);
    }

}
