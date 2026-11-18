package codeforces.rounds.r1134.C;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

        if (n == 1) {
            System.out.println(1);
            System.out.println(fr.nextInt());
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int book = fr.nextInt();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int[] b = map.keySet().stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        List<Integer> p = new ArrayList<>();

        for (int book : b) {
            if (map.get(book) == 1) {
                p.add(book);
            } else {
                p.addFirst(book);
                for (int i = 0; i < map.get(book) - 1; i++) {
                    p.add(book);
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(maxIndex) < p.get(i)) {
                maxIndex = i;
            }
        }

        int count = 2;
        for (int i = 0; i < maxIndex; i++) {
            if (p.get(i) < p.get(i + 1)) {
                count++;
            }
        }

        for (int i = p.size() - 1; i > maxIndex + 1; i--) {
            if (p.get(i) < p.get(i - 1)) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println(p.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    public static void main(String[] args) throws IOException {
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}