package yandex.train10_0.competitive.block1.c2;

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
        int k = scanner.nextInt();

        Map<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            ints.put(v, ints.getOrDefault(v, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = new HashSet<>(ints.entrySet());

        int toRemove = 0;
        for (Map.Entry<Integer, Integer> e : entries) {
            if (!ints.containsKey(e.getKey())) {
                continue;
            }

            if (k - e.getKey() == e.getKey()) {
                toRemove += e.getValue() - 1;
                ints.remove(e.getKey());
            } else if (ints.containsKey(k - e.getKey())) {
                int c = ints.get(k - e.getKey());
                if (c > e.getValue()) {
                    toRemove += e.getValue();
                    ints.remove(e.getKey());
                } else {
                    toRemove += c;
                    ints.remove(k - e.getKey());
                }
            }
        }

        System.out.println(toRemove);

        reader.close();
        writer.close();
    }
}