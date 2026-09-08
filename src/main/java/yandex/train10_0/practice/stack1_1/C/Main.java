package yandex.train10_0.practice.stack1_1.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static record Tag(String name, boolean opening) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        String xml = scanner.nextLine();
        List<Tag> tags = new ArrayList<>();

        for (int i = 0; i < xml.length(); i++) {
            if (xml.charAt(i) == '<') {
                boolean isOpening = xml.charAt(i + 1) != '/';
                int index = isOpening ? i + 1 : i + 2;
                while (xml.charAt(index) != '>') {
                    index++;
                }
                String name = xml.substring(isOpening ? i + 1 : i + 2, index);
                tags.add(new Tag(name, isOpening));
            }
        }

        Deque<Tag> stack = new LinkedList<>();
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).opening()) {
                stack.addFirst(tags.get(i));
            } else {
                Tag current = tags.get(i);
                Tag top = stack.getFirst();
                if (top.name.equals(current.name)) {
                    stack.pollFirst();
                } else {
                    int position = 0;
                    while (!stack.isEmpty()) {
                        stack.pollFirst();
                        position++;
                    }
                    tags.set(position, new Tag(current.name, true));
                    break;
                }
            }
        }

        System.out.println(tags.stream().map(t -> t.opening() ? "<" + t.name + ">" : "</" + t.name + ">").collect(Collectors.joining()));

        reader.close();
        writer.close();
    }
}