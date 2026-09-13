package yandex.train10_0.practice.deque2_2.D;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        Deque<Integer> teams = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            teams.addLast(scanner.nextInt());
        }

        int q = scanner.nextInt(); // test
        Queue<Integer> k = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt();
            k.add(v);
            map.put(v, i);
        }

        int[][] results = new int[q][];
        int round = 1;
        while (!k.isEmpty()) {
            int f = teams.pollFirst();
            int s = teams.pollFirst();
            if (round == k.peek()) {
                int i = k.poll();
                results[map.get(i)] = new int[]{f,s};
            }

            if (f > s) {
                teams.addFirst(f);
                teams.addLast(s);
            } else {
                teams.addFirst(s);
                teams.addLast(f);
            }
            round++;
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + " " + results[i][1]);
        }

        reader.close();
        writer.close();
    }
}