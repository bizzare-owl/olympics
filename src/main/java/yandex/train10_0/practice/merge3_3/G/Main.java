package yandex.train10_0.practice.merge3_3.G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static int[] merge(int[] l, int[] r) {
        int[] result = new int[l.length + r.length];
        int pointer = 0, left = 0, right = 0;
        for (; left < l.length && right < r.length; pointer++) {
            if (l[left] < r[right]) {
                result[pointer] = l[left];
                left++;
            } else {
                result[pointer] = r[right];
                right++;
            }
        }

        for (;pointer < result.length; pointer++) {
            if (right < r.length) {
                result[pointer] = r[right];
                right++;
            } else {
                result[pointer] = l[left];
                left++;
            }
        }

        return result;
    }

    public static void mergesort(int[] arr) {
        int[] result = mergesortInternal(Arrays.copyOfRange(arr, 0, arr.length / 2), Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static int[] mergesortInternal(int[] l, int[] r) {
        int[] lr = l.length <= 1 ? l : mergesortInternal(Arrays.copyOfRange(l, 0, l.length / 2), Arrays.copyOfRange(l, l.length / 2, l.length));
        int[] rr = r.length <= 1 ? r : mergesortInternal(Arrays.copyOfRange(r, 0, r.length / 2), Arrays.copyOfRange(r, r.length / 2, r.length));

        return merge(lr, rr);
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

        mergesort(arr);

        System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}