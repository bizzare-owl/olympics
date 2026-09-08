package codeforces.educational.r194.B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            long k = scanner.nextLong();

            long sum = 0;
            int pred = y - x;
            int d = 0;
            while (d < k) {
                if ((y + d) % (x + d) == pred) {
                    break;
                }

                sum += (y + d) % (x + d);
                d++;
            }

            if (d <= k) {
                sum += pred * (k - d);
            }

            System.out.println(sum);

        }

    }
}