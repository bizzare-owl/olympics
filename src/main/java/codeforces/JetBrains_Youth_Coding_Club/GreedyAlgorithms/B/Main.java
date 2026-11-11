package codeforces.JetBrains_Youth_Coding_Club.GreedyAlgorithms.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public record Pair<F, S>(F first, S second) {}

    public static final class FastReader {
        private final BufferedReader inputStream;

        private StringTokenizer stringTokenizer = null;

        public FastReader(final InputStream inputStream) {
            this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
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

    public static final FastReader fr = new FastReader(System.in);

    public static void solution() throws IOException {
        int n = fr.nextInt();
        long w = fr.nextLong();

        @SuppressWarnings("unchecked")
        Pair<Long, Long>[] cheese = new Pair[n];

        for (int i = 0; i < n; i++) {
            cheese[i] = new Pair<>(fr.nextLong(), fr.nextLong());
        }

        Arrays.sort(cheese, (l, r) -> -l.first.compareTo(r.first));

        long result = 0;
        int i = 0;
        while (w > 0 && i < n) {
            long grams = w > cheese[i].second ? cheese[i].second : w;
            result += cheese[i].first * grams;
            w -= grams;
            i++;
        }

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
//        int t = fr.nextInt();
//        for (int i = 0; i < t; i++) {
            solution();
//        }
    }
}