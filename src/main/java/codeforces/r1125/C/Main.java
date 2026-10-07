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

        Map<Integer, Integer> map = new HashMap<>();
        int[] v = new int[n - 4];
        for (int i = 0; i < n - 4; i++) {
            v[i] = a[i] + a[i + 2] - a[i + 4]; // вычисляется результат для трезвучия
            map.put(v[i], map.getOrDefault(v[i], 0) + 1); // подсчитывается количество одинаковых значений трезвучий
        }

        long result = map.values().stream().mapToLong(x -> (long) x * (x - 1) / 2).sum(); // вычисляем количество пар
        for (int i = 0; i < n - 4; i++) {
            if (i + 2 < n - 4 && v[i] == v[i + 2]) result--;
            if (i + 4 < n - 4 && v[i] == v[i + 4]) result--;
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