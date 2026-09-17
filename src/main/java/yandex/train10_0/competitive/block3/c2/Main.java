package yandex.train10_0.competitive.block3.c2;

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
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int median = arr[arr.length / 2];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                count += Math.abs(arr[i] - median + k / 2);
            } else {
                count += Math.abs(arr[i] - median - k / 2);
            }
        }

        System.out.println(count);

        reader.close();
        writer.close();
    }
}