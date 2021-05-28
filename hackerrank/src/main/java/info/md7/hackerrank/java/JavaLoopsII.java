package info.md7.hackerrank.java;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops/problem
public class JavaLoopsII {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int k = 0; k < n; k++) {
                a += (int) Math.pow(2, k) * b;
                System.out.print(a +" ");
            }
            System.out.println();
        }
        in.close();

    }

}

