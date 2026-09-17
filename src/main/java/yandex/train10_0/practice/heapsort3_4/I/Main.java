package yandex.train10_0.practice.heapsort3_4.I;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static final class SwapCounter {
        public static int swaps = 0;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        SwapCounter.swaps++;
    }

    public static void heapify(int[] arr) {
        int alreadyHeapified = arr.length - arr.length / 2 - ((arr.length % 2 == 0) ? 0 : 1);
        for (int i = arr.length - alreadyHeapified - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void heapify(int[] arr, int i) {
        if (i >= arr.length || leftChild(i) >= arr.length) {
            return;
        }

        int largest = i;
        if (leftChild(i) < arr.length && arr[leftChild(i)] > arr[largest]) {
            largest = leftChild(i);
        }

        if (rightChild(i) < arr.length && arr[rightChild(i)] > arr[largest]) {
            largest = rightChild(i);
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, leftChild(i));
            heapify(arr, rightChild(i));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner =  new Scanner(reader);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        heapify(arr);

        System.out.println(SwapCounter.swaps);
        //System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}