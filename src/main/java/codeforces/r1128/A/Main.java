package codeforces.r1128.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int min = -1, max = min;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
                if (min == -1) {
                    min = i;
                } else {
                    max = i;
                }
            }
        }

        if (max == -1) {
            out.println(0);
        } else if (count == 2) {
            out.println(1);
        } else {
            out.println(max - min);
        }
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}