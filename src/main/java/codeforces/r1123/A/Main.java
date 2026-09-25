package codeforces.r1123.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int k = 0; k < n; k++) {

            int l = scanner.nextInt();
            char s = scanner.nextLine().charAt(1);
            String str = scanner.nextLine();

            int count = 0;
            for (int i = 0; i < l / 2; i++) {
                char left = str.charAt(i);
                char right = str.charAt(l - i - 1);
                if (left != right) {
                    if (left == s || right == s) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }

            System.out.println(count);

        }
    }
}