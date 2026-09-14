package yandex.train10_0.practice.heap2_3.H;

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
        final int w = scanner.nextInt();
        PriorityQueue<int[]> heap = new PriorityQueue<>((l, r) -> {
            if (l[0] == r[0] && l[1] == r[1]) {
                return 0;
            }

            boolean isIntersect = Math.abs(l[0] - r[0]) < Math.min(l[1], r[1]);
            if (isIntersect) {
                return Integer.compare(l[1], r[1]);
            } else {
                return 0;
            }
        });

        for (int i = 0; i < n; i++) {
            heap.add(new int[]{scanner.nextInt(), scanner.nextInt(), i});
        }

        StringBuilder stringBuilder = new StringBuilder();
        int layers = 1;
        int[] prev = null;
        while (!heap.isEmpty()) {
            int[] r = heap.poll();
            boolean isIntersect = prev != null && Math.abs(prev[0] - r[0]) < Math.min(prev[1], r[1]);
            if (isIntersect) {
                layers++;
                prev =null;
            } else {
                prev = r;
            }

            stringBuilder.append(r[2] + 1).append(' ');
        }

        System.out.println(layers);
        System.out.println(stringBuilder);

        reader.close();
        writer.close();
    }
}