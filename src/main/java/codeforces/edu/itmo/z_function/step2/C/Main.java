package codeforces.edu.itmo.z_function.step2.C;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int l = sc.nextInt();
        StringBuilder builder = new StringBuilder().repeat(" ", l);
        int[] z = new int[l];
        int used = 0;

        for (int i = 0; i < l; i++) {
            z[i] = sc.nextInt();
        }

        for (int p = 0; p < l; p++) {
            boolean forced = false;
            for (int i = 1; i <= p; i++) {
                if (i + z[i] > p) {
                    builder.setCharAt(p, builder.charAt(p - i)); // 0 0 1 0 3 0 1 // ab
                    forced = true;
                    break;
                }
            }
            if (!forced) {
                builder.setCharAt(p, letters.charAt(used++));
            }
        }

        int[] z_ =  new int[l];
        for (int i = 1; i < l; i++) {
            while (z_[i] + i < l && builder.charAt(z_[i]  + i) ==  builder.charAt(z_[i])) {
                z_[i]++;
            }
        }

        for (int i = 0; i  < l; i++ ) {
            if (z[i] != z_[i]) {
                out.println("!");
                return;
            }
        }

        out.println(builder);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int ts = 0; ts < t; ts++) {
            solution();
        }
    }
}