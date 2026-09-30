package codeforces.edu.itmo.z_function.step1.B;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String s = sc.nextLine();
        int count = 0;
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                String substr = s.substring(i, i + l);
                String prefix = s.substring(0, l);
                String suffix = s.substring(s.length() - l);
                count += substr.equals(prefix) ^ substr.equals(suffix) ? 1 : 0;
            }
        }

        out.println(count);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int ts = 0; ts < t; ts++) {
            solution();
        }
    }
}