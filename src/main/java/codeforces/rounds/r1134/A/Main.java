package codeforces.rounds.r1134.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
        int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
        if (a == b && b == c) {
            System.out.println("NO");
            return;
        }

        if ((a + b + c) % 3 != 0) {
            System.out.println("NO");
            return;
        }

        int wanted = (a + b + c) / 3;
        System.out.println(Math.abs(a - wanted) <= 1 && Math.abs(b - wanted) <= 1 && Math.abs(c - wanted) <= 1 ? "YES" : "NO");
    }

    public static void main(String[] args) throws IOException {
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}