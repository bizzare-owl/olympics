package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String[] nq = rin.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);

        long[] a = new long[n];
        String[] nums = rin.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(nums[i]);
        }

        long[] b = da(a);
        for (int i = 0; i < q; i++) {
            String[] lrn = rin.readLine().split(" ");
            int l = Integer.parseInt(lrn[0]), r = Integer.parseInt(lrn[1]), num = Integer.parseInt(lrn[2]);
            b[l - 1] += num;
            b[r] -= num;
        }

        long current = 0;
        for (int i = 0; i < b.length - 1; i++) {
            long value = current + b[i];
            print(value + " ");
            current = value;
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}