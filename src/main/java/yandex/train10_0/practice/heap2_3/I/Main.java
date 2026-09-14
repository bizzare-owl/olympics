package yandex.train10_0.practice.heap2_3.I;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();

        PriorityQueue<Integer> sums = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            sums.add(scanner.nextInt());
        }

        double fee = 0;
        while (sums.size() > 1) {
            int f = sums.poll();
            int s = sums.poll();
            int sum = f + s;
            fee += sum * 0.05;
            sums.add(sum);
        }

        System.out.println(String.format("%.2f", fee));

        reader.close();
        writer.close();
    }
}