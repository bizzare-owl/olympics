package codeforces.educational.r195.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void solution() throws IOException {
        int a = sc.nextInt(), b = sc.nextInt();

        int result = gcd(a, b);
        if ((result != 1 || b == 1)) {
            out.println(result);
        } else {
            out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}