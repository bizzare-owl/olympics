package codeforces.r1125.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int R = sc.nextInt();

        for (int x0 = x - R; x0 <= x + R; x0++) {
            for (int y0 = y - R; y0 <= y + R; y0++) {
                double r = Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2));
                if (R == r) {
                    out.println(x0 + " " + y0);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}