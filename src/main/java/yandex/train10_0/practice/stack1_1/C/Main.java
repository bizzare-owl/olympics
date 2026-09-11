package yandex.train10_0.practice.stack1_1.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String xml = reader.readLine();
        char[] chars = xml.toCharArray();
        String validChars = "abcdefghijklmnopqrstuvwxyz<>/";
        boolean validFlag = false;
        for (int i = 0; i < xml.length(); i++) {
            if (validFlag) {
                break;
            }

            for (int j = 0; j < validChars.length(); j++) {
                char toReplace = validChars.charAt(j);
                char replaced = chars[i];
                chars[i] = toReplace;
                validFlag = isValidXml(new String(chars));
                if (validFlag) {
                    break;
                }
                chars[i] = replaced;
            }
        }

        System.out.println(new String(chars));

        reader.close();
        writer.close();
    }

    public static boolean isValidXml(String xml) {
        int position = 0;
        Deque<String> stack = new LinkedList<>();
        while (position < xml.length()) {
            if (xml.charAt(position) != '<') {
                return false;
            }

            position++;
            boolean isOpening = true;
            if (xml.charAt(position) == '/') {
                position++;
                isOpening = false;
            }

            StringBuilder name = new StringBuilder();
            while (position < xml.length() && Character.isAlphabetic(xml.charAt(position))) {
                name.append(xml.charAt(position));
                position++;
            }

            if (name.isEmpty() || position >= xml.length() || xml.charAt(position) != '>') {
                return false;
            }

            if (!isOpening) {
                if (stack.isEmpty() || !stack.peekFirst().equals(name.toString())) {
                    return false;
                }
                stack.pollFirst();
            } else {
                stack.addFirst(name.toString());
            }
            position++;

        }

        return stack.isEmpty();
    }

}