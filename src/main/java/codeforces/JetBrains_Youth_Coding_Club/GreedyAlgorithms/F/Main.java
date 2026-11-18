package codeforces.JetBrains_Youth_Coding_Club.GreedyAlgorithms.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
        int n = fr.nextInt(), q = fr.nextInt();
        int[] bridges = new int[n - 1];

        @SuppressWarnings("unchecked")
        Pair<Integer, Integer>[] qs = new Pair[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Pair<>(fr.nextInt(), fr.nextInt());
        }
        Arrays.sort(qs, Comparator.comparing(p -> Math.abs(p.second - p.first)));

        int count = 0;
        for (Pair<Integer, Integer> p : qs) {
            boolean isConnected = true;
            for (int i = p.first - 1; i < p.second - 2; i++) {
                if (bridges[i] == 1) {
                    isConnected = false;
                    break;
                }
            }

            if (isConnected) {
                bridges[p.second - 2] = 1;
                count++;
            }
        }

        System.out.println(count);

    }

    public static void main(String[] args) throws IOException {
//        int t = fr.nextInt();
//        for (int i = 0; i < t; i++) {
            solution();
//        }
    }
}