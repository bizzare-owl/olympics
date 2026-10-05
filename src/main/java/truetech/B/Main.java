package truetech.B;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static Scanner sc = new Scanner(System.in); // System.in is a standard input stream
    public static Map<Character, int[]> mapOfPositions = Map.of(
            '1', new int[]{0, 0},
            '2', new int[]{0, 1},
            '3', new int[]{0, 2},
            '4', new int[]{1, 0},
            '5', new int[]{1, 1},
            '6', new int[]{1, 2},
            '7', new int[]{2, 0},
            '8', new int[]{2, 1},
            '9', new int[]{2, 2}
    );

    public static void solution() {
        String key = sc.nextLine();

        int[][] map = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 0}
        };

        int res = 0;
        int[] currentPosition = mapOfPositions.get(key.charAt(0));
        map[currentPosition[0]][currentPosition[1]] = 1;
        for (int i = 1; i < key.length(); i++) {
            int[] position = mapOfPositions.get(key.charAt(i));
            if (map[position[0]][position[1]] == 1) {
                System.out.println(-1);
                return;
            }

            // check straights
            int diffX = Math.abs(currentPosition[0] - position[0]);
            int diffY = Math.abs(currentPosition[1] - position[1]);
            if (diffY == 2 && diffX == 2) {
                map[1][1] = 1;
            } else if (diffX == 2 && diffY != 1) {
                if (map[1][position[1]] == 1) {
                    res += 1;
                }
                map[1][position[1]] = 1;
            } else if (diffY == 2 && diffX != 1) {
                if (map[position[0]][1] == 1) {
                    res += 1;
                }
                map[position[0]][1] = 1;
            }

            if (diffX == 1 && diffY != 1) {

            }

            map[position[0]][position[1]] = 1;
            currentPosition = position;
        }

        System.out.println(Arrays.stream(map).map(Arrays::toString).collect(Collectors.joining("\n")));
        System.out.println(res*res);
    }

    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}
