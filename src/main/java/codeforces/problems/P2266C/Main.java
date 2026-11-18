package codeforces.problems.P2266C;

import java.io.*;
import java.util.StringTokenizer;

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
        int n = fr.nextInt();
        String s = fr.next();
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
        }

        if (s.charAt(0) == '1') {
            System.out.println(zeros);
            return;
        }

        int min = 100000;
        for (int i = 0; i < n; i++) {
            zeros -= (s.charAt(i) == '0' ? 1 : 0);
            ones += (s.charAt(i) == '1' ? 1 : 0);
            min = Math.min(min, zeros + ones);
        }

        System.out.println(min);

    }

    public static void main(String[] args) throws IOException {
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}