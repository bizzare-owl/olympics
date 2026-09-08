package yandex.train10_0.practice.stack1_1.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        scanner.nextLine();
        String w = scanner.nextLine();
        String s = scanner.nextLine();
        StringBuilder result = new StringBuilder(s);

        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.addFirst(ch);
            } else if (!stack.isEmpty()) {
                char top = stack.peekFirst();
                if (top == '(' && ch == ')') {
                    stack.pollFirst();
                } else if (top == '[' && ch == ']'){
                    stack.pollFirst();
                }
            }
        }

        char toAdd = w.indexOf('[') < w.indexOf('(') ? '[' : '(';

        while (!stack.isEmpty()) {
            if (n - result.length() <= stack.size()) {
                while (!stack.isEmpty()) {
                    result.append(stack.pollFirst() == '(' ? ')' : ']');
                }
                break;
            }

            char top = stack.peekFirst();
            if (top == '[') {
                if (w.indexOf(']') < w.indexOf('[') && w.indexOf(']') < w.indexOf('(')) {
                    result.append(']');
                    stack.pollFirst();
                } else {
                    result.append(toAdd);
                    stack.addFirst(toAdd);
                }
            } else {
                if (w.indexOf(')') < w.indexOf('[') && w.indexOf(')') < w.indexOf('(')) {
                    result.append(')');
                    stack.pollFirst();
                } else {
                    result.append(toAdd);
                    stack.addFirst(toAdd);
                }
            }

        }

        boolean repetitivePattern = true;
        if (result.length() != n) {
            if (toAdd == '[') {
                if (w.indexOf(']') < w.indexOf('[')) {
                    repetitivePattern = false;
                }
            }

            if (toAdd == '(') {
                if (w.indexOf(')') < w.indexOf('(')) {
                    repetitivePattern = false;
                }
            }

            int count = (n - result.length()) / 2;
            for (int i = 0; i < count; i++) {
                if (repetitivePattern) {
                    stack.addFirst(toAdd);
                    result.append(toAdd);
                } else {
                    result.append(toAdd).append((toAdd == '[' ? ']' : ')'));
                }
            }

            while (!stack.isEmpty()) {
                result.append(stack.pollFirst() == '(' ? ')' : ']');
            }
        }

        System.out.println(result);

        reader.close();
        writer.close();
    }
}