package codeforces.r1122.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int[] a = new int[3];
            int p = scanner.nextInt();
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
            a[2] = scanner.nextInt();

            System.out.println(p - Math.min(a[0], Math.min(a[1], a[2])));


        }

    }
}