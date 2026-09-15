package yandex.train10_0.practice.median2_4.J;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
        }

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> larger = new PriorityQueue<>();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int v = in[i];

            if (smaller.peek() == null || smaller.peek() > v) {
                smaller.add(v) ;
            } else {
                larger.add(v);
            }

            if (smaller.size() > larger.size() + 1) {
                larger.add(smaller.poll());
            } else if (larger.size() > smaller.size() + 1){
                smaller.add(larger.poll());
            }

            result[i] = smaller.size() >= larger.size() ? smaller.peek() : larger.peek();
        }

        System.out.println(Arrays.stream(result).mapToObj(i -> i + "").collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}