package yandex.train10_0.practice.deque2_2.D;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        long start = System.currentTimeMillis();
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> teams = new ArrayDeque<>();
        int max = 0;
        String[] nums = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(nums[i]);
            if (max < v) {
                max = v;
            }

            teams.addFirst(v);
        }

        HashMap<Integer, Integer> ks = new HashMap<>();
        Map<Integer, Integer> kMap = new HashMap<>();
        Map<Integer, int[]> resultMap = new HashMap<>();
        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            int v = Integer.parseInt(reader.readLine());
            if (ks.containsKey(v)) {
                kMap.put(i, ks.get(v));
                resultMap.put(ks.get(v), null);
            } else {
                Integer vv = v;
                ks.put(vv, vv);
                kMap.put(i, vv);
                resultMap.put(vv, null);
            }
        }

        int round = 1;
        while (teams.peekLast() != max) {
            int f = teams.pollLast();
            int s = teams.pollLast();
            if (resultMap.containsKey(round)) {
                resultMap.put(round, new int[]{f, s});
            }

            if (f > s) {
                teams.addLast(f);
                teams.addFirst(s);
            } else {
                teams.addLast(s);
                teams.addFirst(f);
            }
            round++;
        }

        List<Integer> ksSorted = new ArrayList<>();
        for (Integer v : resultMap.keySet()) {
            if (resultMap.get(v) == null) {
                ksSorted.add(v);
            }
        }

        Collections.sort(ksSorted);

        int pivot = teams.pollLast();
        List<Integer> teamsCycle = teams.reversed().stream().toList();
        for (int k : ksSorted) {
            resultMap.put(k,new int[]{pivot, teamsCycle.get((k - round) % teamsCycle.size())});
        }

        for (int i = 0; i < q; i++) {
            int[] r = resultMap.get(kMap.get(i));
            System.out.println(r[0] + " " + r[1]);
        }


        long end = System.currentTimeMillis();
        System.out.println("RESULT: " + (end - start));


        reader.close();
        writer.close();
    }
}