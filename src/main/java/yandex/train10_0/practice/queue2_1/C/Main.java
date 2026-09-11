package yandex.train10_0.practice.queue2_1.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();

        int[] rovers = new int[n];
        Comparator<int[]> cmp = (r1, r2) -> Comparator.<Integer>naturalOrder().compare(r1[2], r2[2]);
        @SuppressWarnings("unchecked")
        Queue<int[]>[] cross = new PriorityQueue[]{new PriorityQueue<>(cmp), new PriorityQueue<>(cmp), new PriorityQueue<>(cmp), new PriorityQueue<>(cmp)};

        int mainDirectionFrom = scanner.nextInt() - 1;
        int mainDirectionTo = scanner.nextInt() - 1;

        for (int i = 0; i < n; i++) {
            int direction = scanner.nextInt() - 1;
            int time = scanner.nextInt();
            cross[direction].add(new int[]{i, direction, time});
        }

        int time = 1;
        int crosseed = 0;
        while (crosseed != n) {
            final int currentTime = time;
            List<int[]> roversToCross = Arrays.stream(cross).map(Queue::peek).filter(Objects::nonNull).filter(r -> r[2] <= currentTime).toList();
            Predicate<Integer> isOnMainRoad = r -> r == mainDirectionFrom || r == mainDirectionTo;
            Function<int[], Integer> getIndexOfRightRoad = r -> (r[1] + 3) % 4;
            boolean isMainRoadOccupied = roversToCross.stream().anyMatch(r -> isOnMainRoad.test(r[1]));

            Predicate<int[]> isObstacleFromTheRight = r -> {
                int indexOfRightRoad = getIndexOfRightRoad.apply(r);
                return !cross[indexOfRightRoad].isEmpty() && Objects.requireNonNull(cross[indexOfRightRoad].peek())[2] <= currentTime;
            };

            Stream<int[]> roversOnMainRoad = roversToCross.stream();

            if (isMainRoadOccupied) {
                roversOnMainRoad = roversOnMainRoad.filter(r -> isOnMainRoad.test(r[1]));
            }

            if (isMainRoadOccupied && (mainDirectionTo - mainDirectionFrom == 1 || mainDirectionTo - mainDirectionFrom == 3)) {
                roversOnMainRoad = roversOnMainRoad.filter(r -> !(isObstacleFromTheRight.test(r) && isOnMainRoad.test(getIndexOfRightRoad.apply(r))));
            }

            if (!isMainRoadOccupied) {
                roversOnMainRoad = roversOnMainRoad.filter(r -> !isObstacleFromTheRight.test(r));
            }

            List<int[]> toCross = roversOnMainRoad.toList();
            toCross.forEach(r -> {
                rovers[r[0]] = currentTime;
                cross[r[1]].poll();
            });

            crosseed += toCross.size();
            time++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(rovers[i]);
        }

        reader.close();
        writer.close();
    }

}