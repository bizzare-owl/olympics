package yandex.train10_0.practice.merge3_3.F;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        int[][] cloths = new int[4][];
        for (int i = 0; i < cloths.length; i++) {
            int n = scanner.nextInt();
            cloths[i] = new int[n];
            for (int j = 0; j < n; j++) {
                cloths[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(cloths[0]);
        Arrays.sort(cloths[1]);
        Arrays.sort(cloths[2]);
        Arrays.sort(cloths[3]);

        int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
        int min1 = i1, min2 = i2, min3 = i3, min4 = i4;
        int minStart = Math.min(Math.min(Math.min(cloths[0][i1], cloths[1][i2]), cloths[2][i3]), cloths[3][i4]);
        int maxStart = Math.max(Math.max(Math.max(cloths[0][i1], cloths[1][i2]), cloths[2][i3]), cloths[3][i4]);
        int minDiff = Math.abs(maxStart - minStart);
        while (i1 < cloths[0].length && i2 < cloths[1].length && i3 < cloths[2].length && i4 < cloths[3].length) {
            int min = Math.min(Math.min(Math.min(cloths[0][i1], cloths[1][i2]), cloths[2][i3]), cloths[3][i4]);
            int max = Math.max(Math.max(Math.max(cloths[0][i1], cloths[1][i2]), cloths[2][i3]), cloths[3][i4]);
            int diff = Math.abs(max - min);
            if (diff < minDiff) {
                minDiff = diff;
                min1 = i1;
                min2 = i2;
                min3 = i3;
                min4 = i4;
            }

            if (diff < 1) {
                break;
            }

            while (i1 < cloths[0].length && cloths[0][i1] == min) {
                i1++;
            }

            while (i2 < cloths[1].length && cloths[1][i2] == min) {
                i2++;
            }

            while (i3 < cloths[2].length && cloths[2][i3] == min) {
                i3++;
            }

            while (i4 < cloths[3].length && cloths[3][i4] == min) {
                i4++;
            }
        }

        System.out.println(cloths[0][min1] + " " + cloths[1][min2] + " " + cloths[2][min3] + " " + cloths[3][min4]);

        reader.close();
        writer.close();
    }
}