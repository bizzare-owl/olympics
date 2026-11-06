package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
            return new long[] {};
        }

        long[] d = new long[a.length + 1];
        d[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            d[i] = a[i] - a[i - 1];
        }
        d[a.length] = -a[a.length - 1];

        return d;
    }

    public static void solution() throws IOException {
        int[] values = Arrays.stream(rin.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(rin.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] da = da(Arrays.stream(a).mapToLong(Long::valueOf).toArray());
        for (int i = 0; i < values[1]; i++) {
            int[] vals = Arrays.stream(rin.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            da[vals[0] - 1] += vals[2];
            da[vals[1]] -= vals[2];
        }

        long[] b = psa(psa(da));
        for (int i = 0; i < values[2]; i++) {
            int[] vals = Arrays.stream(rin.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            println(b[vals[1] + 1] - b[vals[0]]);
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}