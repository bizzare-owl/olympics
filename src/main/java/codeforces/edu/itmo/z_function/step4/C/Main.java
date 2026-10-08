package codeforces.edu.itmo.z_function.step4.C;

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

        int[] z = z(s);

        long[] m = new long[s.length()];
        for (int i = 1; i < z.length; i++) {
            if (z[i] > 0) m[z[i] - 1]++;
        }

        //out.println(Arrays.stream(z).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        //out.println(Arrays.stream(m).mapToObj(Long::toString).collect(Collectors.joining(" ")));

        long csum = 1;
        for (int i = m.length - 1; i >= 0; i--) {
            long csum_temp = csum;
            if (m[i] != 0) {
                csum += m[i];
            }

            m[i] += csum_temp;
        }

        out.println(Arrays.stream(m).mapToObj(Long::toString).collect(Collectors.joining(" ")));

    }

    public static void main(String[] args) {
        int ts = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < ts; i++) {
            solution();
        }
    }
}