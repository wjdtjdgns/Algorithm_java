import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> apt = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] != 0 && !visited[x][y]) {
                    apt.add(bfs(x, y));
                }
            }
        }

        Collections.sort(apt);
        System.out.println(apt.size());
        for (int area : apt) {
            System.out.println(area);
        }
    }

    static int bfs(int startX, int startY) {
        int count = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
