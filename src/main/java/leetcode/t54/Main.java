package leetcode.t54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

            int lb = 0, rb = matrix[0].length, ub = 0, db = matrix.length;
            while (lb < rb && ub < db) {
                int i = lb;
                int j = ub;
                while (i < rb) {
                    result.add(matrix[j][i]);
                    i++;
                }
                j++;
                i--;
                ub++;

                if (ub >= db) {
                    break;
                }

                while (j < db) {
                    result.add(matrix[j][i]);
                    j++;
                }
                rb--;
                j--;
                i--;

                if (lb >= rb) {
                    break;
                }

                while (i >= lb) {
                    result.add(matrix[j][i]);
                    i--;
                }
                lb++;
                db--;
                i++;
                j--;

                while (j >= ub) {
                    result.add(matrix[j][i]);
                    j--;
                }
            }

            return result;
        }
    }

    static void main() {
        System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
    }
}
