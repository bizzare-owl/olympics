package codeforces.r1125.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(reader);

    public static void solution() throws IOException {
        List<Integer> docs = new ArrayList<>(IntStream.range(1, sc.nextInt() + 1).boxed().toList());
        sc.nextLine();
        String commands = sc.nextLine();
        Set<Integer> printed = new HashSet<>();
        Deque<Integer> mem = new ArrayDeque<>();

        char[] charArray = commands.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char command = charArray[i];
            switch (command) {
                case '1':
                    mem.addFirst(docs.get(i));
                    break;
                case '2':
                    if (!mem.isEmpty()) {
                        printed.add(mem.pollFirst());
                        break;
                    }
                case '3':
                    printed.add(docs.get(i));
                    break;
            }
        }

        docs.removeAll(printed);
        out.println(docs.size());
        out.println(docs.stream().sorted().map(Object::toString).collect(Collectors.joining(" ")));

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}