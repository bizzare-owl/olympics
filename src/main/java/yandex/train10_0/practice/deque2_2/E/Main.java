package yandex.train10_0.practice.deque2_2.E;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        Deque<Integer> fHalf = new LinkedList<>();
        Deque<Integer> sHalf = new LinkedList<>();

        for (int i  = 0; i < n; i++) {
            String op = scanner.next();
            int size = sHalf.size() + fHalf.size();
            if (op.equals("-")) {
                System.out.println(fHalf.pollFirst());
                if (size % 2  == 0) {
                    fHalf.addLast(sHalf.pollFirst());
                }
            } else if (op.equals("+")) {
                int g = scanner.nextInt();
                if (fHalf.isEmpty()) {
                    fHalf.addFirst(g);
                } else {
                    if (size % 2 == 0) {
                        fHalf.addLast(sHalf.pollFirst());
                        sHalf.addLast(g);
                    } else {
                        sHalf.addLast(g);
                    }
                }
            } else {
                int g = scanner.nextInt();
                if (size % 2 == 0) {
                    fHalf.addLast(g);
                } else {
                    sHalf.addFirst(g);
                }
            }
        }

        reader.close();
        writer.close();
    }
}