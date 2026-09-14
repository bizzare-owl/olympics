package yandex.train10_0.practice.deque2_2.D;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] in = new int[n];
        int[] pref = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
            deque.addFirst(in[i]);
            if (in[maxIndex] < in[i]) {
                maxIndex = i;
            }
            pref[i] = in[maxIndex];
        }

        for (int i = 0; i < maxIndex; i++) {
            int f = deque.pollLast();
            int s = deque.pollLast();

            if (f > s) {
                deque.addLast(f);
                deque.addFirst(s);
            } else {
                deque.addLast(s);
                deque.addFirst(f);
            }
        }

        deque.pollLast();
        Integer[] deq = deque.reversed().toArray(Integer[]::new);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            long k = scanner.nextLong();
            if (k < maxIndex) {
                System.out.println(pref[(int) k - 1] + " " + in[(int)k]);
            } else {
                System.out.println(in[maxIndex] + " " + deq[(int)((k - maxIndex - 1 + deq.length) % deq.length)]);
            }
        }


        reader.close();
        writer.close();
    }
}