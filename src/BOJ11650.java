import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            coordinates[i] = new Coordinate(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(coordinates);

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }
}
