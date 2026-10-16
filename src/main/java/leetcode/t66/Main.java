package leetcode.t66;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Solution {
        public int[] plusOne(int[] digits) {
            int[] result = new int[digits.length + 1];

            int sum = digits[digits.length - 1] + 1;
            boolean isOverflow = sum % 10 == 0;
            digits[digits.length - 1] = sum % 10;
            for (int i = digits.length - 2; i >= 0; i--) {
                sum = digits[i] + (isOverflow ? 1 : 0);
                result[i + 1] = sum % 10;
                digits[i] = sum % 10;
                isOverflow = sum % 10 == 0 && sum != 0;
            }

            if (isOverflow) {
                result[0] = 1;
                return result;
            } else {
                return digits;
            }
        }
    }

    static void main() {
        System.out.println(Arrays.toString(new Solution().plusOne(new Scanner(System.in).nextLine().chars().map(i -> i - '0').toArray())));
    }
}
