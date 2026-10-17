package leetcode.quest.heap;

import java.util.*;

class Solution {

    public record Pair(int sum, int i, int j) implements Comparable<Pair> {

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(sum, o.sum);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Pair, Integer> visited = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int i = 0, j = 0;

        while (result.size() != k) {

        }
        return null;
    }
}