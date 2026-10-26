package codeforces.rounds.r1130.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[j] = a[i];
        a[j] = temp;
    }

    public static int mex(int[] a, int to) {
        int[] summary = new int[a.length];
        for (int i = 0; i < to; i++) {
            summary[a[i]]++;
        }

        for (int i = 0; i < summary.length; i++) {
            if (summary[i] == 0) {
                return i;
            }
        }

        return to + 1;
    }

    public static void solution() throws IOException {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int f = -1, s = -1;
        int max = mex(a, n - k + 1);
        for (int first = 0; first < n; first++) {
            for (int second = 0; second < n; second++) {
                swap(a, first, second);
                int current = mex(a, n - k + 1);
                if (current > max) {
                    max = current;
                    f = first;
                    s = second;
                }
                swap(a, first, second);
            }
        }

        if (f == -1) {
            out.println(-1);
        } else {
            out.println((f + 1) + " " + (s + 1));
        }

    }

    public static void solutionEffective() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (k == 1) {
            out.println(-1);
            return;
        }

        int max = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (a[max] < a[i]) {
                max = i;
            }
        }

        int min = n - k + 1;
        for (int i = n - k + 1; i < n; i++) {
            if (a[min] > a[i]) {
                min = i;
            }
        }

        if (a[max] < a[min]) {
            out.println(-1);
        } else {
            out.println((max + 1) + " " + (min + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //solution();
            solutionEffective();
        }
    }
}