package yandex.train10_0.practice.recursion1_4.I;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        double a = scanner.nextDouble();
        int n = scanner.nextInt();

        System.out.println(fastPower(a, n));

        reader.close();
        writer.close();
    }

    public static double fastPower(double a, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return a;
        }

        if (n % 2 == 0) {
            return fastPower(a * a, n / 2);
        }

        return a * fastPower(a, n - 1);
    }
}