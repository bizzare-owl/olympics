package codeforces.r1123.B;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int k = 0; k < n; k++) {
            int l = scanner.nextInt();
            int[] arr = new int[l];
            Map<Integer, Integer> map = new HashMap<>();

            int max = -1;
            for (int i = 0; i < l; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int[] result = new int[l];
            Set<Integer> inMod = new HashSet<>();
            for (int i = 0; i < l; i++) {
                int t = getNotInList(map, inMod);
                if (t == -1) {
                    result[i] = getMax(map);
                    inMod.clear();
                } else {
                    result[i] = t;
                }
                inMod.add(result[i]);
            }

            System.out.println(Arrays.stream(result).mapToObj(s -> s + "").collect(Collectors.joining(" ")));

        }

    }

    public static int getMax(Map<Integer, Integer> map) {
        int m =  map.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
        decElement(map, m);
        return m;
    }

    public static int getNotInList(Map<Integer, Integer> map, Set<Integer> l) {
        if (l.isEmpty()) {
            return -1;
        }

        int m = map.keySet().stream().filter(x -> !l.contains(x)).mapToInt(Integer::intValue).findFirst().orElse(-1);
        decElement(map, m);
        return m;
    }

    public static void decElement(Map<Integer, Integer> map, Integer m) {
        if (!map.containsKey(m)) {
            return;
        }

        if (map.get(m) - 1 <= 0) {
            map.remove(m);
        } else {
            map.put(m, map.get(m) - 1);
        }
    }
}