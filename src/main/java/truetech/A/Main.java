package truetech.A;

import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        String v = "025869";
        String prefix = sc.nextLine();
        for (int i = 0; i < prefix.length();i++) {
            if (v.indexOf(prefix.charAt(i)) == -1) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(16);
    }
}
