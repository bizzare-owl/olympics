package codeforces.edu.community.prefix.step3.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void solution() throws IOException {
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] a = new int[n][m];
        long[][] b = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
                b[i + 1][j + 1] = b[i + 1][j] + b[i][j + 1] - b[i][j] + a[i][j];
            }

        }

        int qc = Integer.parseInt(reader.readLine());
        for (int i = 0; i < qc; i++) {
            String[] lr = reader.readLine().split(" ");
            int lx = Integer.parseInt(lr[0]) - 1;
            int ly = Integer.parseInt(lr[1]) - 1;
            int rx = Integer.parseInt(lr[2]);
            int ry = Integer.parseInt(lr[3]);
            out.println(b[rx][ry] - b[lx][ry] - b[rx][ly] + b[lx][ly]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}