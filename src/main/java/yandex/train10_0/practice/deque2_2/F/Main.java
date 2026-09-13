package yandex.train10_0.practice.deque2_2.F;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //long start = System.currentTimeMillis();

        String[] splitted = reader.readLine().split(" ");
        int n = Integer.parseInt(splitted[0]);
        int k = Integer.parseInt(splitted[1]);
        int[] values = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && values[deque.peekFirst()] >= values[i]) {
                deque.pollFirst();
            }
            deque.addFirst(i);

            if (i - k >= deque.peekLast()) {
                deque.pollLast();
            }

            if (i >= k - 1) {
                writer.write(values[deque.peekLast()] + "\n");
            }
        }


        //long end = System.currentTimeMillis();
        //System.out.println("RESULT" + (end - start) + "RESULT");

        reader.close();
        writer.close();
    }


}