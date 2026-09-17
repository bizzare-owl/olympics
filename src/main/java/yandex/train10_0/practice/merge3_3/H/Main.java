package yandex.train10_0.practice.merge3_3.H;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static int[] merge(int[] l, int[] r, ResultHandler resultHandler) {
        int[] result = new int[l.length + r.length];
        int pointer = 0, left = 0, right = 0;
        for (; left < l.length && right < r.length; pointer++) {
            if (l[left] < r[right]) {
                result[pointer] = l[left];
                left++;
            } else {
                result[pointer] = r[right];
                resultHandler.swaps += l.length - left;
                right++;
            }
        }

        for (;pointer < result.length; pointer++) {
            if (right < r.length) {
                result[pointer] = r[right];
                //resultHandler.swaps += l[l.length - 1] > r[right] ? 1 : 0;
                right++;
            } else {
                result[pointer] = l[left];
                left++;
            }
        }

        return result;
    }

    public static void mergesort(int[] arr, ResultHandler resultHandler) {
        int[] result = mergesortInternal(Arrays.copyOfRange(arr, 0, arr.length / 2), Arrays.copyOfRange(arr, arr.length / 2, arr.length), resultHandler);
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static int[] mergesortInternal(int[] l, int[] r, ResultHandler resultHandler) {
        int[] lr = l.length <= 1 ? l : mergesortInternal(Arrays.copyOfRange(l, 0, l.length / 2), Arrays.copyOfRange(l, l.length / 2, l.length), resultHandler);
        int[] rr = r.length <= 1 ? r : mergesortInternal(Arrays.copyOfRange(r, 0, r.length / 2), Arrays.copyOfRange(r, r.length / 2, r.length), resultHandler);

        return merge(lr, rr, resultHandler);
    }

    public static final class ResultHandler {
        public long swaps = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ResultHandler resultHandler = new ResultHandler();
        mergesort(arr, resultHandler);

        System.out.print(resultHandler.swaps + " \n");

        reader.close();
        writer.close();
    }
}