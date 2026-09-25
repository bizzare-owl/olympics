package codeforces.r1123.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int ts = 0; ts < t; ts++) {

            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] gold = new int[n];

            for (int i = 0; i < n; i++) {
                gold[i] = scanner.nextInt();
            }

            long g = x;
            long sum = 0;
            while (true) {
                boolean isContinue = false;
                long maxG = g;
                int indexMax = 0;
                for (int i = 0; i < n; i++) {
                    if (gold[i] <= 0) {
                        continue;
                    }

                    g = gcd(gold[i], g);
                    if (g != 1) {
                        if (maxG <= g) {
                            maxG = g;
                            indexMax = i;
                        }
                        isContinue = true;
                    }
                }

                if (!isContinue) {
                    break;
                } else {
                    sum += Math.max(maxG, gold[indexMax]);
                    gold[indexMax] = (int)Math.max(0, gold[indexMax] - maxG);
                }
            }

            System.out.println(sum);

        }

    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}