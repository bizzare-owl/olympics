package leetcode.t976;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Solution {

        public boolean isTriangle(int a, int b, int c) {
            return a + b > c;
        }

        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            int p = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                if (isTriangle(nums[i], nums[i + 1], nums[i + 2])) {
                    p = Math.max(p, nums[i] + nums[i + 1] + nums[i + 2]);
                }
            }

            return p;
        }
    }

    static void main() {
        System.out.println(new Solution().largestPerimeter(new int[]{1,2,1,10}));
    }
}
