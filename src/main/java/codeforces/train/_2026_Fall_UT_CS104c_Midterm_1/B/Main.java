package codeforces.train._2026_Fall_UT_CS104c_Midterm_1.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        String[] doubles = reader.readLine().split(" ");
        double c = Double.parseDouble(doubles[0]), r = Double.parseDouble(doubles[1]);
        int F = sc.nextInt(), n = sc.nextInt();
        out.printf("%.10f%n", (F / Math.pow(1 + r / 100, n)) + IntStream.range(1, n + 1).mapToDouble(
                i -> F * c / 100 / Math.pow(1 + r / 100, i)
        ).sum());
    }

    public static void main(String[] args) throws IOException {
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            solution();
//        }
        solution();
    }
}