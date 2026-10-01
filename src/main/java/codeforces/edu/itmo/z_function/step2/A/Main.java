package codeforces.edu.itmo.z_function.step2.A;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
       String s = sc.nextLine();
       int[] z = new int[s.length()];
       for (int i = 1; i < s.length(); i++) {
           while (z[i] + i < s.length() && s.charAt(z[i] + i) == s.charAt(z[i])) {
               z[i]++;
           }
       }

        out.println(Arrays.stream(z).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        solution();
    }
}