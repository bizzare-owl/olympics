package yandex.train10_0.practice.queue2_1.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Main {

    public static final class Rover {
        int from;
        int time;
        int id;
        int pass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int from = scanner.nextInt() - 1;
        int to = scanner.nextInt() - 1;


        List<List<Rover>> rovers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rovers.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            Rover rover = new Rover();
            rover.from = scanner.nextInt() - 1;
            rover.time = scanner.nextInt();
            rover.id = i;
            rovers.get(rover.from).add(rover);
        }

        rovers.forEach(l -> l.sort(Comparator.comparingInt(r -> r.time)));
        List<Queue<Rover>> roversQueue = rovers.stream().map(l -> (Queue<Rover>) new LinkedList<>(l)).toList();

        List<Rover> passed = new ArrayList<>();
        int t = 1;
        while (passed.size() < n) {
            int currentTime = t;
            List<Rover> toPass = Stream.of(roversQueue.get(0).peek(), roversQueue.get(1).peek(), roversQueue.get(2).peek(), roversQueue.get(3).peek())
                    .filter(Objects::nonNull)
                    .filter(r -> r.time <= currentTime)
                    .filter(r -> {
                        int right = (r.from + 3) % 4;
                        if (r.from == from || r.from == to) {
                            if ((right == from || right == to) && roversQueue.get(right).peek() != null && roversQueue.get(right).peek().time <= currentTime) {
                                return false;
                            }
                        } else {
                            boolean isMainRoadOccupied = !roversQueue.get(from).isEmpty() && roversQueue.get(from).peek().time <= currentTime ||
                                    !roversQueue.get(to).isEmpty() && roversQueue.get(to).peek().time <= currentTime;
                            if (roversQueue.get(right).peek() != null && roversQueue.get(right).peek().time <= currentTime || isMainRoadOccupied) {
                                return false;
                            }
                        }
                        return true;
                    }).toList();

            toPass.forEach(r -> {
                r.pass = currentTime;
                passed.add(r);
                roversQueue.get(r.from).poll();
            });


            t++;
        }

        passed.stream().sorted(Comparator.comparingInt(r -> r.id)).mapToInt(r -> r.pass).forEach(System.out::println);

        reader.close();
        writer.close();
    }

}