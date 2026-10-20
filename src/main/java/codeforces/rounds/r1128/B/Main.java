package codeforces.rounds.r1128.B;

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
        if (n == 1) {
            out.println(sc.nextInt());
            return;
        }

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int max = values[0], min = values[0];
        for (int i = 0; i < n; i++) {
            if (values[i] > max) {
                max = values[i];
            }

            if (values[i] < min) {
                min = values[i];
            }
        }

        out.println(solve(max, min));

    }

    public static int solve(int max, int min) {
        if (min == max) {
            return max;
        }

        int powerMax = (int)Math.floor(Math.log(max) / Math.log(2));
        int power = (int)Math.pow(2, powerMax);

        if (min < power) {
            return (power << 1) - 1;
        }

        return power + solve(max - power, min - power);

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}