package yandex.train10_0.practice.postinfix1_2.D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine().trim();
        Deque<Integer> stack = new LinkedList<>();
        for (char ch : line.toCharArray()) {
            switch (ch) {
                case ' ':
                    break;
                case '+':
                    stack.addFirst(stack.pollFirst() + stack.pollFirst());
                    break;
                case '-':
                    int top = stack.pollFirst();
                    stack.addFirst(stack.pollFirst() - top);
                    break;
                case '*':
                    stack.addFirst(stack.pollFirst() * stack.pollFirst());
                    break;
                default:
                    stack.addFirst(Integer.parseInt("" + ch));
                    break;
            }
        }

        System.out.println(stack.peekFirst() == null ? 0 : stack.peekFirst());

        reader.close();
        writer.close();
    }
}