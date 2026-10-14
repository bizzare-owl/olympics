package codeforces.edu.itmo.suffix_array.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public record Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>>(T1 first,
                                                                             T2 second) implements Comparable<Pair<T1, T2>> {
        @Override
        public int compareTo(Pair<T1, T2> o) {
            int comparingResult = first.compareTo(o.first);
            return comparingResult == 0 ? second.compareTo(o.second) : comparingResult;
        }

        @Override
        public String toString() {
            return "(" + first.toString() + ", " + second.toString() + ")";
        }
    }

    public static void countSort(Pair<Character, Integer>[] initial) {
        // TODO: count sort
    }

    public static void radixSort(Pair<Pair<Integer, Integer>, Integer>[] pairs) {
        @SuppressWarnings("unchecked")
        List<Pair<Pair<Integer, Integer>, Integer>>[] buckets = new ArrayList[pairs.length];
        for (Pair<Pair<Integer, Integer>, Integer> pair : pairs) {
            if (buckets[pair.first.first] == null) {
                buckets[pair.first.first] = new ArrayList<>();
            }
            buckets[pair.first.first].add(pair);
        }

        for (int i = 0, p = 0; i < pairs.length; i++) {
            if (buckets[i] == null) {
                continue;
            }

            for (int j = 0; j < buckets[i].size(); j++, p++) {
                pairs[p] = buckets[i].get(j);
            }
        }

//        int[] count = new int[pairs.length];
//        for (Pair<Pair<Integer, Integer>, Integer> pair : pairs) {
//            count[pair.first.first]++;
//        }
//
//        int[] pos = new int[pairs.length];
//        for (int i = 1; i < count.length; i++) {
//            pos[i] = pos[i - 1] + count[i - 1];
//        }
//
//        @SuppressWarnings("unchecked")
//        Pair<Pair<Integer, Integer>, Integer>[] pairsNew = new Pair[pairs.length];
//        for (Pair<Pair<Integer, Integer>, Integer> pair : pairs) {
//            pairsNew[pos[pair.first.first]] = pair;
//            pos[pair.first.first]++;
//        }
//
//        System.arraycopy(pairsNew, 0, pairs, 0, pairs.length);
    }

    public static void solution() throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine() + "$";
        int[] suffixArray = new int[s.length()];
        int[] classes = new int[s.length()];

        @SuppressWarnings("unchecked")
        Pair<Character, Integer>[] initial = new Pair[s.length()];
        for (int i = 0; i < initial.length; i++) {
            initial[i] = new Pair<>(s.charAt(i), i);
        }

        countSort(initial);
        suffixArray[0] = initial[0].second;
        classes[initial[0].second] = 0;
        for (int i = 1; i < classes.length; i++) {
            suffixArray[i] = initial[i].second;
            classes[initial[i].second] = initial[i - 1].first == initial[i].first ? classes[initial[i - 1].second] : classes[initial[i - 1].second] + 1;
        }

        int k = 0;
        while ((1 << k) < s.length()) {
//            out.println("Iteration " + k);
//            for (int i : suffixArray) {
//                out.print(classes[i] + " ");
//            }

            @SuppressWarnings("unchecked")
            Pair<Pair<Integer, Integer>, Integer>[] pairs = new Pair[s.length()];
            for (int i = 0; i < s.length(); i++) {
                int leftHalf = (suffixArray[i] - (1 << k) + s.length()) % s.length();
                pairs[i] = new Pair<>(new Pair<>(classes[leftHalf], classes[suffixArray[i]]), leftHalf);
            }

            radixSort(pairs);
//            for (Pair<Pair<Integer, Integer>, Integer> pair : pairs) {
//                out.println(pair);
//            }

            boolean isConstructed = true;
            suffixArray[0] = pairs[0].second;
            classes[pairs[0].second] = 0;
            for (int i = 1; i < s.length(); i++) {
                boolean isEqual =pairs[i - 1].first.equals(pairs[i].first);
                suffixArray[i] = pairs[i].second;
                classes[pairs[i].second] = isEqual ? classes[pairs[i - 1].second] : classes[pairs[i - 1].second] + 1;
                if (isEqual) {
                    isConstructed = false;
                }
            }

            if (isConstructed) {
                break;
            }

//            out.println(Arrays.toString(classes));

            k++;
        }

        for (int i : suffixArray) {
            out.print(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
//        int ts = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < ts; i++) {
//            solution();
//        }
    }
}