package codeforces.edu.itmo.z_function.step2.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int k = sc.nextInt();
        int j = sc.nextInt();
        gray(k, j);
    }

    public static void gray(int k, int j) {
        if (k == 1) {
            out.println(0);
            return;
        }

        if (k == 2) {
            out.println(j == 2 ? 1 : 0);
            return;
        }

        int mid = ((int)Math.pow(2, k) - 3) / 2;
        if (mid == (j - 2)) {
            out.println((int)Math.pow(2, k - 1) - 1);
            return;
        }

        gray(k - 1, (j - 2) > mid ? j - mid - 2 : j);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int ts = 0; ts < t; ts++) {
            solution();
        }
    }
}