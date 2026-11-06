package codeforces.rounds.r1132.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)Math.pow(2, sc.nextInt());
        }

        Arrays.sort(a);

        long[] pa = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pa[i] = pa[i - 1] + a[i - 1];
        }

        int s = n;
        while ((pa[n] - pa[s - 1]) / pa[s - 1] < 1) {
            s--;
        }

        out.println((pa[n] - pa[s - 1]) * (pa[s - 1]));
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}