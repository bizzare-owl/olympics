package codeforces.JetBrains_Youth_Coding_Club.GreedyAlgorithms.D;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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

    public static final FastReader fr = new FastReader(System.in);

    public static void solution() throws IOException {
        int n = fr.nextInt(), x = fr.nextInt();
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = fr.nextInt();
        }

        Arrays.sort(k);

        int count = 0;
        for (int l = 0, r = n - 1; l <= r;) {
            if (l == r) {
                count++;
                break;
            }

            if (k[l] + k[r] > x) {
                r--;
            } else {
                r--;
                l++;
            }
            count++;
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