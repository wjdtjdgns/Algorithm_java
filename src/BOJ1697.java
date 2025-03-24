import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int max = 100001;
        int[] visited = new int[max];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(visited[current] - 1);
                return;
            }

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next < max && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
