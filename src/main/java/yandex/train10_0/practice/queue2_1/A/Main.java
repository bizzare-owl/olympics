package yandex.train10_0.practice.queue2_1.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class SimpleQueue {
        int[] queue = new int[4];
        int front = 0;
        int back = 0;
        int size = 0;

        private void shiftElements() {
            int shift = queue.length - size;
            for (int i = 0; i < size; i++) {
                queue[i] = queue[i + shift];
            }
            front = 0;
            back -= shift;
        }

        private void rearrange() {
            int[] newQueue = new int[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
        }

        public void push(int e) {
            if (back == queue.length && size != queue.length) {
                shiftElements();
            } else if (back == queue.length) {
                rearrange();
            }

            queue[back] = e;
            back++;
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException();
            }
            size--;
            return queue[front++];
        }

        public int front() {
            if (size == 0) {
                throw new RuntimeException();
            }
            return queue[front];
        }

        public void clear() {
            Arrays.fill(queue, 0);
            size = 0;
            front = 0;
            back = 0;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        SimpleQueue queue = new SimpleQueue();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("front")) {
                try {
                    System.out.println(queue.front());
                } catch (RuntimeException e) {
                    System.out.println("error");
                }
            } else if (line.equals("size")) {
                System.out.println(queue.size());
            } else if (line.equals("exit")) {
                System.out.println("bye");
                break;
            } else if (line.equals("pop")) {
                try {
                    System.out.println(queue.pop());
                } catch (RuntimeException e) {
                    System.out.println("error");
                }
            } else if (line.equals("clear")) {
                queue.clear();
                System.out.println("ok");
            } else {
                queue.push(Integer.parseInt(line.split(" ")[1]));
                System.out.println("ok");
            }
        }


        reader.close();
        writer.close();
    }
}