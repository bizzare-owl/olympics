package codeforces.edu.community.prefix.step3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String[] generateBinaryStrings(int n) {
        String[] strings = new String[(int) Math.pow(2, n)];

        for (int i = 0; i < strings.length; i++) {
            String binaryString = Integer.toBinaryString(i);
            String paddedBinary = String.format("%5s", binaryString).replace(' ', '0');
            strings[i] = paddedBinary;
        }

        return strings;
    }

    public static void solution() throws IOException {
        String[] nm = reader.readLine().split(" ");
        int n1 = Integer.parseInt(nm[0]);
        int n2 = Integer.parseInt(nm[1]);
        int n3 = Integer.parseInt(nm[2]);
        int n4 = Integer.parseInt(nm[3]);
        int n5 = Integer.parseInt(nm[4]);

        int[][][][][] a = new int[n1][n2][n3][n4][n5];
        long[][][][][] b = new long[n1 + 1][n2 + 1][n3 + 1][n4 + 1][n5 + 1];
        String[] maps = generateBinaryStrings(5);

        int[] currentIndexes = new int[5];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n3; k++) {
                    for (int p = 0; p < n4; p++) {
                        int[] values = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                        for (int v = 0; v < n5; v++) {
                            a[i][j][k][p][v] = values[v];
                            currentIndexes[0] = i;
                            currentIndexes[1] = j;
                            currentIndexes[2] = k;
                            currentIndexes[3] = p;
                            currentIndexes[4] = v;
                            long sum = 0;
                            for (String map : maps) {
                                int zeros = 0;
                                for (int c = 0; c < map.length(); c++) {
                                    currentIndexes[c] += map.charAt(c) == '1' ? 1 : 0;
                                    zeros += map.charAt(c) == '0' ? 1 : 0;
                                }
                                sum += b[currentIndexes[0]][currentIndexes[1]][currentIndexes[2]][currentIndexes[3]][currentIndexes[4]] * (zeros % 2 == 1 ? 1 : -1);
                                currentIndexes[0] = i;
                                currentIndexes[1] = j;
                                currentIndexes[2] = k;
                                currentIndexes[3] = p;
                                currentIndexes[4] = v;
                            }
                            b[i + 1][j + 1][k + 1][p + 1][v + 1] = sum + a[i][j][k][p][v];
                        }
                    }
                }
            }
        }


        int qc = Integer.parseInt(reader.readLine());
        for (int i = 0; i < qc; i++) {
            int[] q = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] l = {q[0], q[1], q[2], q[3], q[4]};
            int[] r = {q[5], q[6], q[7], q[8], q[9]};

            long result = 0;
            for (String map : maps) {
                int[] ii = new int[5];
                int lefts = 0;
                for (int j = 0; j < 5; j++) {
                    ii[j] = map.charAt(j) == '1' ? l[j] - 1 : r[j];
                    lefts += map.charAt(j) == '1' ? 1 : 0;
                }

                result += (lefts % 2 == 1 ? -1 : 1) * b[ii[0]][ii[1]][ii[2]][ii[3]][ii[4]];
            }

            out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}