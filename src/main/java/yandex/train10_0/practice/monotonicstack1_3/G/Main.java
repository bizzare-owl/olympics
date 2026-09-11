package yandex.train10_0.practice.monotonicstack1_3.G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && input[stack.peekFirst()] > input[i]) {
                result[stack.pollFirst()] = i;
            }
            stack.addFirst(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pollFirst()] = -1;
        }

        System.out.println(Arrays.stream(result).mapToObj(i -> "" + i).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}