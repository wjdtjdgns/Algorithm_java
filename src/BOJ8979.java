import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ8979 {
    static class Nation implements Comparable<Nation> {
        int name;
        int gold;
        int silver;
        int bronze;

        public Nation(int name, int gold, int silver, int bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold != o.gold) return o.gold - this.gold;
            if (this.silver != o.silver) return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Nation> nations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int name = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);

            nations.add(new Nation(name, gold, silver, bronze));
        }

        Collections.sort(nations);

        Map<Integer, Integer> rank = new HashMap<>();
        int ranking = 1;

        for (int i = 0; i < N; i++) {
            if (i > 0 && nations.get(i).compareTo(nations.get(i - 1)) != 0) {
                ranking = i + 1;
            }

            rank.put(nations.get(i).name, ranking);
        }

        System.out.println(rank.get(K));
    }
}
