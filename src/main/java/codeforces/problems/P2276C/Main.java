package codeforces.problems.P2276C;

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
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[n + 1];
        for (int i = 0; i < a.length; i++) {
            b[i + 1] = (b[i] + a[i]) % k;
        }

        long result = 0;
        int[] count = new int[k];
        for (int i = k + 1; i < b.length; i++) {
            count[b[i - k - 1]]++;
            result += count[b[i]];
        }

        out.println(result);

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}