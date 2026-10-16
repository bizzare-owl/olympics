package leetcode.t67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static class Solution {
        public String addBinary(String a, String b) {
            List<Integer> binary = new ArrayList<>();

            String shortBinary, longBinary;
            if (a.length() > b.length()) {
                shortBinary = b;
                longBinary = a;
            } else {
                shortBinary = a;
                longBinary = b;
            }

            boolean overflow = false;
            for (int i = 0; i < shortBinary.length(); i++) {
                int f = shortBinary.charAt(shortBinary.length() - i - 1)  == '1' ? 1 : 0;
                int s = longBinary.charAt(longBinary.length() - i - 1) == '1' ? 1 : 0;
                binary.addFirst((f + s + (overflow ? 1 : 0)) % 2);
                overflow = f + s + (overflow ? 1 : 0) >= 2;
            }

            for (int i = 0; i < longBinary.length() - shortBinary.length(); i++) {
                int f = longBinary.charAt(longBinary.length() - shortBinary.length() - i - 1) == '1' ? 1 : 0;
                binary.addFirst((f + (overflow ? 1 : 0)) % 2);
                overflow = (f + (overflow ? 1 : 0)) == 2;
            }

            if (overflow) {
                binary.addFirst(1);
            }

            return binary.stream().map(i -> i == 1 ? "1" : "0").collect(Collectors.joining());
        }
    }

    static void main() {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
