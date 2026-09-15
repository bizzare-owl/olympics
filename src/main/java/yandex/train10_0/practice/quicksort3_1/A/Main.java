package yandex.train10_0.practice.quicksort3_1.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static int partition(int[] arr, int x, int l, int r) {
        int e = l, b = l, c = l;
        for (int i = l; i < r; i++) {
            if (arr[c] == x) {
                arr[c] = arr[b];
                arr[b] = x;
                b++;
                c++;
            } else if (arr[c] > x) {
                c++;
            } else {
                int temp = arr[c];
                arr[c] = arr[b];
                arr[b] = arr[e];
                arr[e] = temp;
                e++;
                b++;
                c++;
            }
        }
        return e - l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int p = partition(arr, x, 0, n);

        System.out.println(p + "\n" + (n - p));

        reader.close();
        writer.close();
    }
}