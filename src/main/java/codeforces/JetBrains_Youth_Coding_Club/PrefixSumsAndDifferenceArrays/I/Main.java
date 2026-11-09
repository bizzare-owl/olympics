package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static BufferedReader rin = new BufferedReader(new InputStreamReader(System.in));

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.print(object + "\n");
    }

    public static void println() {
        System.out.println();
    }

    public static long[] psa(long[] a) {
        long[] b = new long[a.length + 1];

        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] + a[i - 1];
        }

        return b;
    }

    public static long[] da(long[] a) {
        if (a.length == 0) {
            return new long[]{};
        }

        long[] d = new long[a.length + 1];
        d[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            d[i] = a[i] - a[i - 1];
        }
        d[a.length] = -a[a.length - 1];

        return d;
    }

    public static int maxi(long[] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[index] < a[i]) {
                index = i;
            }
        }
        return index;
    }

    public static int won(char f, char s) {
        if (f == 'P') {
            return s == 'H' ? 1 : 0;
        } else if (f == 'S') {
            return s == 'P' ? 1 : 0;
        } else {
            return s == 'S' ? 1 : 0;
        }
    }

    public static void solution() throws IOException {
        Scanner scanner = new Scanner(rin);
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        Map<Long, Long> map = new HashMap<>();

        long count = 0;
        long p = 0;
        for (int i = 0; i < n; i++) {
            p = ((p + a[i]) % s + s) % s;

            if (p == 0) {
                count++;
            }

            count += map.getOrDefault(p, 0L);
            map.put(p, map.getOrDefault(p, 0L) + 1L);
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}