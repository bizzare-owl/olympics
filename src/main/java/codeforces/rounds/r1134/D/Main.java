package codeforces.rounds.r1134.D;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

//    public static final FastReader fr = new FastReader(System.in);

    public static final FastReader fr = new FastReader(
            new StringReader("""
                    1
                    10000
                    """ + new Random().ints(10000).mapToObj(i -> {
                        i %= 200;
                        if (i < 97) {
                            return "a";
                        } else if (i > 122) {
                            return "z";
                        } else {
                            return (char)i + "";
                        }
            }).collect(Collectors.joining())
    ));

    public static boolean isPol(CharSequence s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> dp = new HashMap<>();

    public static int dpSolution(String s) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        if (isPol(s)) {
            dp.put(s, 0);
            return 0;
        }

        Set<Character> chars = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (ch != 'a') {
                chars.add(ch);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char ch : chars) {
            int current = dpSolution(s.replace(ch, (char) (ch - 1))) + 1;
            if (current < min) {
                min = current;
            }
        }

        dp.put(s, min);
        return min;
    }

    public static void solution() throws IOException {
        int n = fr.nextInt();
        String s = fr.next();
        System.out.println(dpSolution(s));
        dp = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}