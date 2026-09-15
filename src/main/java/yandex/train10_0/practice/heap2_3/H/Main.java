package yandex.train10_0.practice.heap2_3.H;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final class Fig {
        public int a;
        public int w;
        public int r;
        public List<Integer> ids;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        int n = scanner.nextInt();
        final int w = scanner.nextInt();
        PriorityQueue<Fig> heap = new PriorityQueue<>(Comparator.comparingInt(f -> f.r));

        List<Fig> figs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Fig fig = new Fig();
            fig.a = scanner.nextInt();
            fig.w = scanner.nextInt();
            fig.r = fig.a + fig.w - 1;
            fig.ids = new ArrayList<>();
            fig.ids.add(i);
            figs.add(fig);
        }

        figs.sort(Comparator.comparingInt(f -> f.a));
        heap.add(figs.getFirst());

        for (int i = 1; i < figs.size(); i++) {
            Fig v = heap.peek();
            if (figs.get(i).a > v.r) {
                Fig f = figs.get(i);
                Fig s = heap.poll();
                s.ids.addAll(f.ids);
                s.r = f.r;
                heap.add(s);
            } else {
                heap.add(figs.get(i));
            }
        }

        System.out.println(heap.size());
        System.out.println(heap.stream().flatMap(f -> f.ids.stream()).map(i -> (i + 1) + "").collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}