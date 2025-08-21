import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14940 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] distance;
    static boolean[][] visit;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
        distance = new int[N][M];
        visit = new boolean[N][M];
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);

                if (map[i][j] == 0) {
                    distance[i][j] = 0;
                } else if (map[i][j] == 1) {
                    distance[i][j] = -1;
                } else if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(distance[i][j]);
                if (j < M - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visit[x][y] = true;
        distance[x][y] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visit[nextX][nextY]) continue;
                if(map[nextX][nextY] == 0) continue;

                queue.add(new int[] {nextX, nextY});
                distance[nextX][nextY] = distance[currentX][currentY] + 1;
                visit[nextX][nextY] = true;
            }
        }
    }
}
