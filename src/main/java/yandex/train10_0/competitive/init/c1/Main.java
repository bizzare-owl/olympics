package yandex.train10_0.competitive.init.c1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String v = scanner.nextLine();
            StringBuilder builder = new StringBuilder();

            int prevIndex = 0;
            for (int j = Character.isUpperCase(v.charAt(0)) ? 1 : 0; j < v.length(); j++) {
                while (j < v.length() && !Character.isUpperCase(v.charAt(j))) {
                    j++;
                }

                if (j >= v.length()) {
                    break;
                }

                builder.append(v.substring(prevIndex, j).toLowerCase()).append("_");
                prevIndex = j;
            }

            builder.append(v.substring(prevIndex).toLowerCase());
            System.out.println(builder);
        }

        reader.close();
        writer.close();
    }
}