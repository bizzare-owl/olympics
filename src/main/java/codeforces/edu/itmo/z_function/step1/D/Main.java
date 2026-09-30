package codeforces.edu.itmo.z_function.step1.D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String s = sc.nextLine();
        String p = sc.nextLine();

        List<Integer> indexesOfSubstrings = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String substr = s.substring(i, i + p.length());
            if (substr.equals(p)) {
                indexesOfSubstrings.add(i);
            }
        }

        long count = 0;
        int prev = -1;
        for (int i : indexesOfSubstrings) {
            int rightBound = i + p.length() - 1;
            int leftBound = prev + 1;
            long chCount = rightBound - leftBound;
            count += chCount * (chCount + 1) / 2;
            prev = i;
        }

        int rightBound = s.length();
        int leftBound = prev + 1;
        long chCount = rightBound - leftBound;
        count += chCount * (chCount + 1) / 2;
        count -= indexesOfSubstrings.size() * (p.length() > 2 ? (long) (p.length() - 2) * (p.length() - 1) / 2 : 0);

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