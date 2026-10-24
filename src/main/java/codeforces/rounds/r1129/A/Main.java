package codeforces.rounds.r1129.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];

        if (k > n) {
            out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        a = Arrays.stream(a).sorted().toArray();
        int max = a[0];
        for (int i = 0; i < k; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }



        if (max > 0) {
            out.println(0);
            return;
        } else {
            out.println(Arrays.stream(a).distinct().max().orElse(0) + 1);
            return;
        }
/*
        int[] maxes = new int[n / k];
        for (int i = 0, m = 0; i < a.length - (a.length % k); i += k, m++) {
            int maxi = a[i];
            for (int j = 0; j < k; j++) {
                if (maxi < a[i + j]) {
                    maxi = a[i + j];
                }
            }
            maxes[m] = maxi;
        }

        int prev = maxes[0];
        for (int i = 1; i < maxes.length; i++) {
            if (maxes[i] - prev > 1) {
                out.println(prev + 1);
                return;
            }
            prev = a[i];
        }

        out.println(maxes[maxes.length - 1] + 1);

 */

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}