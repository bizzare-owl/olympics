package yandex.train10_0.competitive.block2.c1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        int[][] image = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                image[i][j] = line.charAt(j) == '#' ? 1 : 0;
            }
        }

        List<List<Integer>> rows = new ArrayList<>(n);
        List<List<Integer>> columns = new ArrayList<>(m);

        for (int i = 0; i < n; i++) {
            rows.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            columns.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] row = image[i];
            int count = 0;
            for (int k : row) {
                if (k == 1) {
                    count++;
                } else {
                    if (count != 0) {
                        rows.get(i).add(count);
                        count = 0;
                    }
                }
            }

            if (count != 0) {
                rows.get(i).add(count);
            }
        }

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int value = image[j][i];
                if (value == 1) {
                    count++;
                } else {
                    if (count != 0) {
                        columns.get(i).add(count);
                        count = 0;
                    }
                }
            }
            if (count != 0) {
                columns.get(i).add(count);
            }
        }

        for (List<Integer> r : rows) {
            if (r.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(r.size() + " " + r.stream().map(i -> i + "").collect(Collectors.joining(" ")));
            }
        }
        System.out.println();
        for (List<Integer> r : columns) {
            if (r.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(r.size() + " " + r.stream().map(i -> i + "").collect(Collectors.joining(" ")));
            }
        }

        reader.close();
        writer.close();
    }
}