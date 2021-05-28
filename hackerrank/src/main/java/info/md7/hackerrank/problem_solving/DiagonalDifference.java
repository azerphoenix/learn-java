package info.md7.hackerrank.problem_solving;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/plus-minus/problem
public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1, 2, 3));
        lists.add(List.of(4, 5, 6));
        lists.add(List.of(7, 8, 9));

        printListElems(lists);
        System.out.println("-----------");
        int sum = diagonalDifference(lists);
        System.out.println(sum);
    }

    /**
     * Print each element of list of lists
     * @param lists
     */
    public static void printListElems(List<List<Integer>> lists) {
        for (List<Integer> integerList : lists) {
            for (int integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * Get all diagonals from list of lists
     * Get difference between sum of diagonal elems
     * @param arr
     * @return
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumOfFirstDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    sumOfFirstDiagonal += arr.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if ((i + j) == arr.size() - 1) {
                    sumOfSecondaryDiagonal += arr.get(i).get(j);
                }
            }
        }

        return Math.abs(sumOfFirstDiagonal - sumOfSecondaryDiagonal);
    }

}
