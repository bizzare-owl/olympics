package yandex.train10_0.competitive.block3.c1;

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
        long a = scanner.nextLong(), b = scanner.nextLong();

        long count = 0;
        while (a > 0 && b > 0) {
            count += Math.max(a, b) / Math.min(a, b);
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        System.out.println(count);

        reader.close();
        writer.close();
    }
}