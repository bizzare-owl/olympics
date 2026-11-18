package codeforces.problems.P2276A;

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
        int a = fr.nextInt(), b = fr.nextInt();
        int count = 0;

        if (a <= b) {
            System.out.println(-1);
            return;
        }

        while (a > b) {
            if (a - 2 > b - 1 && b - 1 != 0) {
                count++;
                a -= 2;
                b--;
            } else {
                break;
            }
        }

        count += a > b ? 1 : 0;

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}