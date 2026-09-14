package yandex.train10_0.practice.heap2_3.G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final class Heap {
        int[] heap = new int[8];
        int size = 0;

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private void resize() {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        private void swap(int l, int r) {
            int temp = heap[l];
            heap[l] = heap[r];
            heap[r] = temp;
        }

        public void insert(int e) {
            if (size >= heap.length) {
                resize();
            }

            heap[size++] = e;
            int currentIndex = size - 1;
            while (currentIndex > 0 && heap[currentIndex] > heap[parent(currentIndex)]) {
                swap(currentIndex, parent(currentIndex));
                currentIndex = parent(currentIndex);
            }
        }

        public int extract() {
            int max = heap[0];
            int last = heap[size - 1];
            size--;
            if (size > 0) {
                heap[0] = last;
                int currentIndex = 0;
                while (true) {
                    int left = left(currentIndex);
                    int right = right(currentIndex);

                    int largest = currentIndex;
                    if (left < size && heap[left] >= heap[largest]) {
                        largest = left;
                    }

                    if (right < size && heap[right] >= heap[largest]) {
                        largest = right;
                    }

                    if (largest == currentIndex) {
                        break;
                    }

                    swap(currentIndex, largest);
                    currentIndex = largest;
                }
            }
            return max;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                System.out.println(heap.extract());
            } else {
                int num = scanner.nextInt();
                heap.insert(num);
            }
        }

        reader.close();
        writer.close();
    }
}