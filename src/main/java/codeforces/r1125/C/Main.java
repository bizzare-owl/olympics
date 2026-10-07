package codeforces.r1125.C;

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
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long result = 0;
        for (int ss = 0; ss < 6; ss++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = ss; i < n - 5; i += 6) {
                int f = a[i] + a[i + 2] - a[i + 4];
                int s = a[i + 1] + a[i + 3] - a[i + 5];

                map.put(f, map.getOrDefault(f, 0) + 1);
                map.put(s, map.getOrDefault(s, 0) + 1);

                if (ss == 5) {
                    int p = a[0] + a[2] - a[4];
                    map.put(p, map.getOrDefault(p, 0) + 1);
                }

                out.print(f + " " + s + "\n");
            }

            result += map.values().stream().filter(integer -> integer > 1).mapToInt(m -> (m * (m - 1) / 2)).sum();
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