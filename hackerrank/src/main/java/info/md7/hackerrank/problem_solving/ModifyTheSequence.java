package info.md7.hackerrank.problem_solving;

import java.util.Iterator;
import java.util.List;

//https://www.hackerrank.com/challenges/modify-the-sequence/problem
public class ModifyTheSequence {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 7, 10, 2, 20, 22);
//        List<Integer> integerList = List.of(4, 10, 20);
        System.out.println(modifySequence(integerList));

    }

    public static int modifySequence(List<Integer> arr) {
        int seqModificationsCount = 0;
//        Iterator<Integer> integerIterator = arr.listIterator();
        /*while (integerIterator.hasNext()) {
            int num1 = integerIterator.next();
            int num2 = integerIterator.next() + 1;
            if (num2 < num1) {
                seqModificationsCount++;
            }
        }*/
        for (int i = 0; i < arr.size()-1; i++) {
            int num1 = arr.get(i);
            int num2 = arr.get(i+1);
            if (num2 < num1) {
                seqModificationsCount++;
            }
        }
        /*for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int num1 = arr.get(i);
                int num2 = arr.get(j);
                if (num2 < num1) {
                    seqModificationsCount++;
                }
            }
        }*/
        return seqModificationsCount;
    }
}
