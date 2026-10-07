package codeforces.edu.community.prefix.step2.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void solution() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        long[] b = new long[n + 1];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
            b[i + 1] = b[i] + a[i];
        }

        int qc = Integer.parseInt(reader.readLine());
        for (int i = 0; i < qc; i++) {
            String[] lr = reader.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            out.println(b[r] - b[l - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}