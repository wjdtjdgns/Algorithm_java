import java.io.*;
import java.util.*;

public class BOJ7562 {

  static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  static boolean[][] visited;
  static int l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      l = Integer.parseInt(br.readLine());
      visited = new boolean[l][l];

      StringTokenizer st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      int result = bfs(startX, startY, endX, endY);
      System.out.println(result);
    }
  }

  static int bfs(int startX, int startY, int endX, int endY) {
    if (startX == endX && startY == endY) return 0;

    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(startX, startY, 0));
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      for (int i = 0; i < 8; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
          if (nx == endX && ny == endY) {
            return p.moves + 1;
          }
          visited[nx][ny] = true;
          queue.offer(new Point(nx, ny, p.moves + 1));
        }
      }
    }

    return 0;
  }

  static class Point {
    int x;
    int y;
    int moves;

    Point(int x, int y, int moves) {
      this.x = x;
      this.y = y;
      this.moves = moves;
    }
  }
}
