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

        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && h[stack.peek()] > h[i]) {
                int index = stack.pop();
                int width = i - stack.peek() - 1;
                max = Math.max(max, width * h[index]);
            }
            stack.addFirst(i);
        }

        while (stack.peek() != -1) {
            int index = stack.pollFirst();
            int width = n - stack.peek() - 1;
            max = Math.max(max, width * h[index]);
        }

        System.out.println(max);

        reader.close();
        writer.close();
    }

}