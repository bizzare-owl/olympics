package yandex.train10_0.practice.postinfix1_2.F;

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

        final Map<Character, Integer> priorityMap = Map.of('|', 0, '^', 0, '&', 1, '!', 2);
        String input = reader.readLine();

        Deque<Character> operators = new LinkedList<>();
        List<Character> postfix = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '0':
                case '1':
                    postfix.add(ch);
                    break;
                case '!':
                case '&':
                case '^':
                case '|':
                    while (!operators.isEmpty() && operators.peekFirst() != '(' && priorityMap.get(operators.peekFirst()) >= priorityMap.get(ch)) {
                        postfix.add(operators.pollFirst());
                    }

                    operators.addFirst(ch);
                    break;
                case '(':
                    operators.addFirst(ch);
                    break;
                case ')':
                    while (!operators.isEmpty() && operators.peekFirst() != '(') {
                        postfix.add(operators.pollFirst());
                    }
                    operators.pollFirst();
                    break;
            }
        }

        while (!operators.isEmpty()) {
            postfix.add(operators.pollFirst());
        }

        Deque<Boolean> stack = new LinkedList<>();
        for (char ch : postfix) {
            switch (ch) {
                case '0':
                case '1':
                    stack.addFirst(ch == '1');
                    break;
                case '!':
                    stack.addFirst(!stack.pollFirst());
                    break;
                case '&':
                    stack.addFirst(stack.pollFirst() & stack.pollFirst());
                    break;
                case '|':
                    stack.addFirst(stack.pollFirst() | stack.pollFirst());
                    break;
                case '^':
                    stack.addFirst(stack.pollFirst() ^ stack.pollFirst());
                    break;

            }
        }

        System.out.println(stack.peekFirst() ? 1 : 0);

        reader.close();
        writer.close();
    }
}