import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        String[] input = br.readLine().split(" ");
        int personA = Integer.parseInt(input[0]);
        int personB = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(bfs(personA, personB, graph, n));
    }

    public static int bfs(int from, int to, List<List<Integer>> graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[]{from, 0});
        visited[from] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curNode = current[0];
            int depth = current[1];

            if (curNode == to) return depth;

            for (int next : graph.get(curNode)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }

        return -1;
    }
}
