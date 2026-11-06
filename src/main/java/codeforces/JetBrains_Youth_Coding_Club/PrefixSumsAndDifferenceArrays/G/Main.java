package codeforces.JetBrains_Youth_Coding_Club.PrefixSumsAndDifferenceArrays.G;

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
        int n = Integer.parseInt(rin.readLine());
        char[] v = new char[n];
        for (int i = 0; i < n; i++) {
            v[i] = rin.readLine().charAt(0);
        }

        int[] p = new int[n];
        int[] s = new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = won('P', v[i]);
            s[i] = won('S', v[i]);
            h[i] = won('H', v[i]);
        }

        long[] pa = psa(Arrays.stream(p).asLongStream().toArray());
        long[] sa = psa(Arrays.stream(s).asLongStream().toArray());
        long[] ha = psa(Arrays.stream(h).asLongStream().toArray());

        long max = Math.max(pa[n], Math.max(sa[n], ha[n]));
        for (int i = 0; i < n; i++) {
            long pav = pa[i + 1] + Math.max(sa[n] - sa[i + 1], ha[n] - ha[i + 1]);
            if (pav > max) {
                max = pav;
            }

            long sav = sa[i + 1] + Math.max(pa[n] - pa[i + 1], ha[n] - ha[i + 1]);
            if (sav > max) {
                max = sav;
            }

            long hav = ha[i + 1] + Math.max(sa[n] - sa[i + 1], pa[n] - pa[i + 1]);
            if (hav > max) {
                max = hav;
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}