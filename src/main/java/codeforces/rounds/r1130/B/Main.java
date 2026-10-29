package codeforces.rounds.r1130.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        int n = sc.nextInt();

        int c = 0;
        sc.nextLine();
        for (int i = 0; i < 2; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                c += s.charAt(j) == 'f' ? 1 : 0;
            }
        }

        out.println(c % 2);
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}