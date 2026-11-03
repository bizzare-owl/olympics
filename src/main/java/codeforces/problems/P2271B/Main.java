package codeforces.problems.P2271B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] summary = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            summary[num]++;
        }

        for (int j : summary) {
            if (j < 2 * k) {
                out.println(j == 2 * k - 1 ? "YES" : "NO");
                return;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}