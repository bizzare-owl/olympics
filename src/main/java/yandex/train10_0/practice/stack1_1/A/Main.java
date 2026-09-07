package yandex.train10_0.practice.stack1_1.A;

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


        Deque<Character> s = new LinkedList<>();
        String line = reader.readLine();

        boolean isValid = true;
        for (char ch : line.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                s.addFirst(ch);
            }

            if (ch == ']') {
                if (s.isEmpty() || s.peekFirst() != '[') {
                    isValid = false;
                    break;
                }
                s.pollFirst();
            }

            if (ch == '}') {
                if (s.isEmpty() || s.peekFirst() != '{') {
                    isValid = false;
                    break;
                }
                s.pollFirst();
            }

            if (ch == ')') {
                if (s.isEmpty() || s.peekFirst() != '(') {
                    isValid = false;
                    break;
                }
                s.pollFirst();
            }

        }

        if (isValid) {
            isValid = s.isEmpty();
        }

        System.out.println(isValid ? "yes" : "no");

        reader.close();
        writer.close();
    }
}