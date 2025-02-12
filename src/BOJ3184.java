import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3184 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int totalSheep = 0, totalWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int sheep = 0;
        int wolf = 0;

        if (map[r][c] == 'o') sheep++;
        if (map[r][c] == 'v') wolf++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dr = cur[0] + dx[i];
                int dc = cur[1] + dy[i];

                if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;
                if (visited[dr][dc]) continue;
                if (map[dr][dc] == '#') continue;

                visited[dr][dc] = true;
                queue.add(new int[]{dr, dc});

                if (map[dr][dc] == 'o') sheep++;
                if (map[dr][dc] == 'v') wolf++;
            }
        }

        if (sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
}
