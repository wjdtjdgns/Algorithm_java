import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    static int N;
    static char[][] graph;
    static char[][] colorBlindGraph;
    static boolean[][] visit;
    static boolean[][] colorBlindVisit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        colorBlindGraph = new char[N][N];
        visit = new boolean[N][N];
        colorBlindVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
                colorBlindGraph[i][j] = (line.charAt(j) == 'G') ? 'R' : line.charAt(j);
            }
        }

        int count = 0, colorBlindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs(j, i, graph[i][j], false);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!colorBlindVisit[i][j]) {
                    bfs(j, i, colorBlindGraph[i][j], true);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(count + " " + colorBlindCount);
    }

    public static void bfs(int x, int y, char color, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        if (!isColorBlind) {
            visit[y][x] = true;
        } else {
            colorBlindVisit[y][x] = true;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!isColorBlind) {
                    if (!visit[ny][nx] && graph[ny][nx] == color) {
                        visit[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                } else {
                    if (!colorBlindVisit[ny][nx] && colorBlindGraph[ny][nx] == color) {
                        colorBlindVisit[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
