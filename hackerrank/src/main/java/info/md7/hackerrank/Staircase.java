package info.md7.hackerrank;

// https://www.hackerrank.com/challenges/staircase/problem
public class Staircase {

    public static void main(String[] args) {
        staircase(6);
    }

    /**
     * Staircase
     * @param n
     */
    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
