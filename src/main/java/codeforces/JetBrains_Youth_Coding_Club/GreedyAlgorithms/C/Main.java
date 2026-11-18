package codeforces.JetBrains_Youth_Coding_Club.GreedyAlgorithms.C;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public record Pair<F, S>(F first, S second) {}

    public static final class FastReader {
        private final BufferedReader inputStream;

        private StringTokenizer stringTokenizer = null;

        public FastReader(final InputStream inputStream) {
            this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
        }

        public FastReader(final Reader reader) {
            this.inputStream = new BufferedReader(reader);
        }


        public String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(inputStream.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e); // just rethrow it with unchecked exception
                }
            }

            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    public static final FastReader fr = new FastReader(
//            System.in
            new StringReader("50000\n" + IntStream.range(1, 100001).filter(i -> i % 2 != 1).mapToObj(Integer::toString).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" ")))
    );

    public static void solution() throws IOException {
        int n = fr.nextInt();
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            e[i] = fr.nextInt();
        }

        int[] ec = new int[n];
        System.arraycopy(e, 0, ec, 0, n);
        Arrays.sort(ec);
        int[] our = new int[n];
        int oi = 0, ej = 0;
        int current = 1;
        while (oi < n && ej < n) {
            if (current < ec[ej]) {
                while (current < ec[ej]) {
                    our[oi] = current;
                    current++;
                    oi++;
                }
            }

            if (current == ec[ej]) {
                current++;
                ej++;
            }
        }

        if (oi < n) {
            while (oi < n) {
                our[oi] = current;
                current++;
                oi++;
            }
        }

        int count = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                if (our[j] > e[i]) {
                    min = our[j];
                    our[j] = -1;
                    break;
                }
            }

            if (min != -1) {
                count++;
            } else {
                our[l] = -1;
                l++;
            }

        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
//        int t = fr.nextInt();
//        for (int i = 0; i < t; i++) {
        long start = System.currentTimeMillis();
            solution();
            long end = System.currentTimeMillis();
        System.out.println(end - start);
//        }
    }
}