import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int fromX = Integer.parseInt(line[0]);
            int fromY = Integer.parseInt(line[1]);
            int toX = Integer.parseInt(line[2]);
            int toY = Integer.parseInt(line[3]);

            for (int y = fromY; y < toY; y++) {
                for (int x = fromX; x < toX; x++) {
                    map[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 0 && !visited[y][x]) {
                    areas.add(bfs(x, y));
                }
            }
        }

        Collections.sort(areas);

        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int startX, int startY) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }

        return area;
    }
}
