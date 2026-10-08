package leetcode.quest.heap;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.reverseOrder());

        left.addAll(Arrays.stream(nums1).boxed().toList());
        right.addAll(Arrays.stream(nums2).boxed().toList());

        List<List<Integer>> result = new ArrayList<>();


        return result;
    }
}