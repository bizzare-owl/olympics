package codeforces.edu.itmo.z_function.step1.C;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void solution() {
       String s = sc.nextLine();
       String p = sc.nextLine();

       if (p.length() > s.length()) {
           out.println(0 + "\n");
           return;
       }

       String result = "";
       int matchCount = 0;
       for (int i = 0; i < s.length() - p.length() + 1; i++) {
           boolean match = true;
           for (int j = 0; j < p.length(); j++) {
               if (p.charAt(j) == '?') {
                   continue;
               }

               if (s.charAt(i + j) != p.charAt(j)) {
                   match = false;
                   break;
               }
           }

           if (match) {
               matchCount++;
               result += i + " ";
           }
       }

       out.println(matchCount);
       out.println(result);

    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int ts = 0; ts < t; ts++) {
            solution();
        }
    }
}