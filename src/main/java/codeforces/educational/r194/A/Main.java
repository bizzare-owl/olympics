package codeforces.educational.r194.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            int easy = 0;
            boolean firstEasy = false;
            boolean lastEasy = false;
            for (int j = 0; j < k; j++) {
                int s = scanner.nextInt();
                if (j == 0 && s == 0) {
                    firstEasy = true;
                }

                if (j == k - 1 && s == 0) {
                    lastEasy = true;
                }

                if (s == 0) {
                    easy++;
                }
            }

            if (easy < 2) {
                System.out.println(-1);
            } else {
                System.out.println(2 - (firstEasy ? 1 : 0) - (lastEasy ? 1 : 0));
            }
        }

    }
}