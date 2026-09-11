package yandex.train10_0.competitive.init.c2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String substring = s.substring(j, j + i + 1);
                Map<Character, Integer> subMap = new HashMap<>();
                for (char ch : substring.toCharArray()) {
                    subMap.put(ch, subMap.getOrDefault(ch, 0) + 1);
                }

                boolean isValid = true;
                for (Map.Entry<Character, Integer> entry : subMap.entrySet()) {
                    if (!(tMap.containsKey(entry.getKey()) && tMap.get(entry.getKey()) >= entry.getValue())) {
                        isValid = false;
                    }
                }

                if (isValid) {
                    result++;
                }
            }
        }

        System.out.println(result);

        reader.close();
        writer.close();
    }
}