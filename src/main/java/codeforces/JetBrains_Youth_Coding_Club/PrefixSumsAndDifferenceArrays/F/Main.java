package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.F;

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
        int n = Integer.parseInt(rin.readLine());
        long[] a = new long[n];
        String[] nums = rin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(nums[i]);
        }

        long maxSum = a[0];
        long result = a[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + a[i], a[i]);
            result = Math.max(result, maxSum);
        }

        println(result);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}