package yandex.train10_0.practice.queue2_1.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        Queue<Integer> firstPlayer = new LinkedList<>();
        Queue<Integer> secondPlayer = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            firstPlayer.add(scanner.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            secondPlayer.add(scanner.nextInt());
        }

        int rounds = 0;
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && rounds < 1000000) {
            int f = firstPlayer.poll();
            int s = secondPlayer.poll();

            if (f > s) {
                if (f == 9 && s == 0) {
                    secondPlayer.add(f);
                    secondPlayer.add(s);
                } else {
                    firstPlayer.add(f);
                    firstPlayer.add(s);
                }
            } else {
                if (s == 9 && f == 0) {
                    firstPlayer.add(f);
                    firstPlayer.add(s);
                } else {
                    secondPlayer.add(f);
                    secondPlayer.add(s);
                }
            }

            rounds++;
            if (firstPlayer.isEmpty()) {
                System.out.println("second " + rounds);
                return;
            }

            if (secondPlayer.isEmpty()){
                System.out.println("first " + rounds);
                return;
            }
        }

        System.out.println("botva");

        reader.close();
        writer.close();
    }
}