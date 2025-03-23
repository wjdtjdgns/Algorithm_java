import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        findMinWay(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    static void findMinWay(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 1;


        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
