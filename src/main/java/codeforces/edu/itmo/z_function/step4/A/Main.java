    package codeforces.edu.itmo.z_function.step4.A;

    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    import static java.lang.System.out;

    public class Main {

        public static Scanner sc = new Scanner(System.in);

        public static int[] z(String s) {
            int[] z = new int[s.length()];

            int l = 0, r = 0;
            for (int i = 1; i < s.length(); i++) {
                if (i <= r) {
                    z[i] = Math.min(z[i - l], r - i + 1);
                }

                while (z[i] + i < s.length() && s.charAt(z[i] + i) == s.charAt(z[i])) {
                    z[i]++;
                }

                if (r < z[i] + i - 1) {
                    l = i;
                    r = z[i] + i - 1;
                }
            }
            return z;
        }

        public static void solution() {
            String s = sc.nextLine();

            int[] z = z(s);
            for (int i = 1; i < s.length(); i++) {
                if (z[i] + i == s.length()) {
                    out.println(s.substring(0, i));
                    return;
                }
            }

            out.println(s);
        }

        public static void main(String[] args) {
            int ts = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < ts; i++) {
                solution();
            }
        }
    }