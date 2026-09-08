package yandex.train10_0.practice.postinfix1_2.E;

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
        Deque<Character> operations = new LinkedList<>();
        StringBuilder postfix = new StringBuilder();
        int i = 0;
        for (; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case ' ':
                    break;

                case '(':
                    operations.addFirst('(');
                    break;

                case ')':
                    while (!operations.isEmpty() && operations.peekFirst() != '(') {
                        postfix.append(operations.pollFirst()).append(' ');
                    }

                    if (operations.isEmpty()) {
                        System.out.println("WRONG");
                        return;
                    }

                    operations.pollFirst();
                    break;

                case '+':
                    while (!operations.isEmpty() && (operations.peekFirst() == '+' || operations.peekFirst() == '-' || operations.peekFirst() == '*')) {
                        postfix.append(operations.pollFirst()).append(' ');
                    }
                    operations.addFirst('+');
                    break;

                case '*':
                    while (!operations.isEmpty() && operations.peekFirst() == '*') {
                        postfix.append(operations.pollFirst()).append(' ');
                    }
                    operations.addFirst('*');
                    break;

                case '-':
                    while (!operations.isEmpty() && (operations.peekFirst() == '+' || operations.peekFirst() == '-' || operations.peekFirst() == '*')) {
                        postfix.append(operations.pollFirst()).append(' ');
                    }
                    operations.addFirst('-');
                    break;
                default:
                    if (!Character.isDigit(line.charAt(i))) {
                        System.out.println("WRONG");
                        return;
                    }

                    int index = i;
                    while (index < line.length() && Character.isDigit(line.charAt(index))) {
                        index++;
                    }
                    postfix.append(line, i, index).append(' ');
                    i = index - 1;
            }
        }

        while (!operations.isEmpty()) {
            postfix.append(operations.pollFirst()).append(' ');
        }

        try {
            String[] values = postfix.toString().trim().split(" ");
            Deque<Integer> stack = new LinkedList<>();
            for (String v : values) {
                if (v.charAt(0) == '-') {
                    if (v.length() == 1) {
                        int top = stack.pollFirst();
                        stack.addFirst(stack.pollFirst() - top);
                    } else {
                        stack.addFirst(Integer.parseInt(v));
                    }
                } else if (v.charAt(0) == '+') {
                    stack.addFirst(stack.pollFirst() + stack.pollFirst());
                } else if (v.charAt(0) == '*') {
                    stack.addFirst(stack.pollFirst() * stack.pollFirst());
                } else {
                    stack.addFirst(Integer.parseInt(v));
                }
            }

            if (stack.size() > 1) {
                System.out.println("WRONG");
                return;
            }

            System.out.println(stack.pollFirst());
        } catch (Exception e) {
            System.out.println("WRONG");
        }

        reader.close();
        writer.close();
    }
}