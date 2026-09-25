package codeforces.r1122.C;

import java.util.Arrays;
import java.util.Scanner;

// ХЗ не решил
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int[] binaryString = new int[l];
            scanner.nextLine();
            String str = scanner.nextLine();
            for (int j = 0; j < l; j++) {
                binaryString[j] = str.charAt(j) == '0' ? 0 : 1;
            }

            
        }

    }

    public static int solution(int[] array) {
        return Math.min(solutionAnd(array, 0), solutionOr(array, 0));
    }

    public static int booleanAnd(int[] array, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int booleanOr(int[] array, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean isSorted(int[] array) {
        int i = 0;
        while (array[i] != 1) {
            i++;
        }

        for (; i < array.length; i++) {
            if (array[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static int solutionAnd(int[] array, int index) {
        if (index >= array.length) {
            if (isSorted(array)) {
                return 0;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return 1 + Math.min(solutionAnd(array, index + 1), solutionOr(array, index + 1));
    }

    public static int solutionOr(int[] array, int index) {
        return 0;
    }
}