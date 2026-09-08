package codeforces.educational.r194.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int ops = 0;
            int opsMax = 0;
            int max = x ^ y;
            while (x >= 0) {
                if (max < (x ^ y)) {
                    max = (x ^ y);
                    ops = opsMax;
                }

                opsMax++;
                x--;
                y++;
            }

            System.out.println(max + " " + ops);
        }

    }
}