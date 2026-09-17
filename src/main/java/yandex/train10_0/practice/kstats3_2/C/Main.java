package yandex.train10_0.practice.kstats3_2.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static final class Town {
        public int x;
        public int y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();

        List<Town> towns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Town town = new Town();
            town.x = scanner.nextInt();
            town.y = scanner.nextInt();
            towns.add(town);
        }

        towns.sort(Comparator.comparingInt(t -> t.x));
        int xMedian = towns.get(towns.size() / 2).x;
        towns.sort(Comparator.comparingInt(t -> t.y));
        int yMedian = towns.get(towns.size() / 2).y;

        int x = xMedian, y = yMedian;
        double minAvg = Double.MAX_VALUE;
        for (int i = xMedian - 11; i < xMedian + 11; i++) {
            for (int j = yMedian - 11; j < yMedian + 11; j++) {
                double avg = 0;
                boolean isOk = true;
                for (Town t : towns) {
                    if (t.x == i && t.y == j) {
                        isOk = false;
                        break;
                    }

                    avg += Math.abs(t.x - i) + Math.abs(t.y - j);
                }

                if (!isOk) {
                    continue;
                }

                avg /= n;
                if (minAvg > avg) {
                    minAvg = avg;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y);

        reader.close();
        writer.close();
    }
}