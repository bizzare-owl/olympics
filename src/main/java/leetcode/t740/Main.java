package leetcode.t740;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Solution {

        int[] memo;
        Map<Integer, Integer> map;
        public int deleteAndEarn(int[] nums) {
            map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            nums = Arrays.stream(nums).sorted().distinct().toArray();
            if (nums.length == 1) {
                return nums[0] * map.get(nums[0]);
            }

            memo = new int[nums.length];
            return Math.max(deleteAndEarn(nums, 0), deleteAndEarn(nums, 1));
        }

        public int deleteAndEarn(int[] nums, int i) {
            if (i >= nums.length) {
                return 0;
            }

            if (memo[i] != 0) {
                return memo[i];
            }

            int result = nums[i] * map.get(nums[i]) + Math.max(
                    deleteAndEarn(nums, i + 1 < nums.length && nums[i + 1] != nums[i] + 1 ? i + 1 : i + 2),
                    deleteAndEarn(nums, i + 1 < nums.length && nums[i + 1] != nums[i] + 1 ? i + 2 : i + 3)
            );
            memo[i] = result;
            return result;
        }
    }

    static void main() {
        System.out.println(new Solution().deleteAndEarn(new int[]{3,1}));
    }
}
