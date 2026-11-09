package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static void solution() throws IOException {
        Scanner scanner = new Scanner(rin);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long[] da = da(a);
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long v = scanner.nextLong();

            if (l > r) {
                da[0] += v;
                da[r] -= v;

                da[l - 1] += v;
                da[da.length - 1] -= v;
            } else {
                da[l - 1] += v;
                da[r] -= v;
            }
        }

        long[] result = psa(da);
        System.out.println(Arrays.stream(result).mapToObj(Long::toString).skip(1).limit(da.length - 1).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}