import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int G = Integer.parseInt(line[2]);
        int U = Integer.parseInt(line[3]);
        int D = Integer.parseInt(line[4]);

        int[] visited = new int[F + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == G) {
                System.out.println(visited[now]);
                return;
            }

            int up = now + U;
            int down = now - D;

            if (U > 0 && up <= F && visited[up] == -1) {
                visited[up] = visited[now] + 1;
                queue.add(up);
            }

            if (D > 0 && down >= 1 && visited[down] == -1) {
                visited[down] = visited[now] + 1;
                queue.add(down);
            }
        }

        System.out.println("use the stairs");
    }
}
