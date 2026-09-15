package yandex.train10_0.practice.kstats3_2.D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            ys[i] = scanner.nextInt();
            xs[i] = scanner.nextInt();
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        int result = 0;
        int median = xs[xs.length / 2];
        int y = 1;
        for (int i = 0; i < n; i++, y++) {
            result += Math.abs(xs[i] - median) + Math.abs(ys[i] - y);
        }
        System.out.println(result);

        reader.close();
        writer.close();
    }
}