package yandex.train10_0.practice.merge3_3.E;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            nn[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] mm = new int[m];
        for (int i = 0; i < m; i++) {
            mm[i] = scanner.nextInt();
        }

        System.out.println(Arrays.stream(merge(nn, mm)).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}