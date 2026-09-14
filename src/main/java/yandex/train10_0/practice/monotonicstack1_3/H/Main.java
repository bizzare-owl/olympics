package yandex.train10_0.practice.monotonicstack1_3.H;

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
        int n = scanner.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        Deque<Integer> indices = new LinkedList<>();
        Deque<Integer> pivots = new LinkedList<>();
        long maxArea = 0;
        for (int i = 0; i < h.length + 1; i++) {
            int pivotIndex = i;
            while (!indices.isEmpty() && i == h.length || !indices.isEmpty() && h[indices.getFirst()] > h[i]) {
                int index = indices.pollFirst();
                int pivot = pivots.pollFirst();
                pivotIndex = pivot;
                maxArea = Math.max(maxArea, (long) h[index] * (i - pivot));
            }
            indices.addFirst(i);
            pivots.addFirst(pivotIndex);
        }

        System.out.println(maxArea);

        reader.close();
        writer.close();
    }

}