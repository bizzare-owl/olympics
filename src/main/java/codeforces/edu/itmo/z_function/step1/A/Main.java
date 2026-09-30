package codeforces.edu.itmo.z_function.step1.A;

import java.util.Scanner;
import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String s = sc.nextLine();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(0, i + 1);
            boolean isPalindrome = true;
            for (int left = 0, right = substr.length() - 1; left < right; left++, right--) {
                if (substr.charAt(left) != substr.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                max = substr.length();
            }
        }

        out.println(max);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int ts = 0; ts < t; ts++) {
            solution();
        }
    }
}