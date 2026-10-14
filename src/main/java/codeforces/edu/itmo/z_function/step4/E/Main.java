package codeforces.edu.itmo.z_function.step4.E;

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
            if (r >= i) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }

            while (z[i] + i < s.length() && s.charAt(z[i]) == s.charAt(z[i] + i)) {
                z[i]++;
            }

            if (r < i + z[i] - 1) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }

    public static void solution() {
        String s = sc.nextLine();
        String p = sc.nextLine();

        if (s.length() != p.length()) {
            out.println("No");
            return;
        }

        int[] z = z(p + "|" + s);
        int maxPrefix = Arrays.stream(z).skip(z.length / 2).max().orElse(0);
        for (int left = maxPrefix, right = s.length() - maxPrefix; left < p.length(); left++, right--) {
            if (p.charAt(left) == s.charAt(right)) {
                out.println("No");
                return;
            }
        }

        out.println("Yes\n" + (s.length() - maxPrefix));
    }

    public static void main(String[] args) {
        solution();
//        int ts = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < ts; i++) {
//            solution();
//        }
    }
}