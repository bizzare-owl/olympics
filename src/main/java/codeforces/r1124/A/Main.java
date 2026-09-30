package codeforces.r1124.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int ts = 0; ts < t; ts++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            System.out.println(Math.powExact(2, n - k + 1) + (n - k + 1) * 2);

        }

    }
}