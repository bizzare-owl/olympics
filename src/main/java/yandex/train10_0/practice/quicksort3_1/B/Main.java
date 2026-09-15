package yandex.train10_0.practice.quicksort3_1.B;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static int partition(int[] arr, int x, int l, int r) {
        int e = l, b = l, c = l;
        for (int i = l; i < r; i++) {
            if (arr[c] == x) {
                arr[c] = arr[b];
                arr[b] = x;
                b++;
                c++;
            } else if (arr[c] > x) {
                c++;
            } else {
                int temp = arr[c];
                arr[c] = arr[b];
                arr[b] = arr[e];
                arr[e] = temp;
                e++;
                b++;
                c++;
            }
        }
        return e - l;
    }

    public static final class SortingIntrospector {
        boolean isNotOptimalSort;
    }

    public static void quicksort(int[] arr) {
        SortingIntrospector sortingIntrospector = new SortingIntrospector();
        quicksortInternal(arr, 0, arr.length, 0, sortingIntrospector);
        if (sortingIntrospector.isNotOptimalSort) {
            Arrays.sort(arr);
        }
    }

    public static void quicksortInternal(int[] arr, int l, int r, int notOptimalPivotChooseCount, SortingIntrospector sortingIntrospector) {
        if (notOptimalPivotChooseCount >= 3) {
            sortingIntrospector.isNotOptimalSort = true;
            return;
        }

        if (sortingIntrospector.isNotOptimalSort) {
            return;
        }

        if (r - l <= 16) {
            bubbleSort(arr, l, r);
            return;
        }

        int pivot = l + new Random().nextInt(r - l);
        int p = partition(arr, arr[pivot], l, r);
        boolean isOptimal = p > (r - l) / 32 + 1;
        quicksortInternal(arr, l, l + p, isOptimal ? 0 : notOptimalPivotChooseCount + 1, sortingIntrospector);
        quicksortInternal(arr, l + p + 1, r, isOptimal ? 0 : notOptimalPivotChooseCount + 1, sortingIntrospector);
    }

    public static void bubbleSort(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            for (int j = l; j < r - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        //long start = System.currentTimeMillis();
        quicksort(arr);
        //long end = System.currentTimeMillis();
        //System.out.println(end - start);

        System.out.println(Arrays.stream(arr).mapToObj(i -> i + "").collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}