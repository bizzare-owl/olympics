package yandex.train10_0.practice.recursion1_4.J;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();

        move(n, 1, 3);

        reader.close();
        writer.close();
    }

    public static void move(int n, int from, int to) {
        if (n == 1) {
            System.out.printf("%d %d %d\n", n, from, to);
            return;
        }

        int unused = 6 - from - to;
        move(n - 1, from, unused);
        System.out.printf("%d %d %d\n", n, from, to);
        move(n - 1, unused, to);
    }
}