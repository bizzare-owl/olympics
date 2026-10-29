package codeforces.problems.P2274A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int[] a = new int[sc.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int target = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int d = Math.abs(target - a[i]);
            target = a[i] + (target < a[i] ? d : -d);
        }

        out.println(target / 2);
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}