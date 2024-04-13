import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int n, m;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    max = Math.max(max, bfs(j, i));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);

    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visit[y][x] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx + 1 > m || ny + 1 > n) continue;
                if (visit[ny][nx]) continue;
                if (graph[ny][nx] == 1) {
                    size++;
                    visit[ny][nx] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return size;
    }
}
