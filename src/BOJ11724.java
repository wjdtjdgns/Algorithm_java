import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]), M = Integer.parseInt(temp[1]);

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int src = Integer.parseInt(temp[0]), dst = Integer.parseInt(temp[1]);
            graph.addEdge(src, dst);
        }
        System.out.println(graph.countConnectedComponents());
    }

    static class Graph {
        private final int n ;
        private final int[][] map;
        private final boolean[] check;

        public Graph(int n) {
            this.n = n;
            this.map = new int[n + 1][n + 1];
            check = new boolean[n + 1];
        }

        public void addEdge(int src, int dst) {
            map[src][dst] = 1;
            map[dst][src] = 1;
        }

        public void DFS(int start) {
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                int v = stack.pop();

                if (!check[v]) {
                    check[v] = true;

                    for (int i = 1; i <= n; i++) {
                        if (map[v][i] == 1 && !check[i]) {
                            stack.push(i);
                        }
                    }
                }
            }
        }

        public int countConnectedComponents() {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    DFS(i);
                    count++;
                }
            }

            return count;
        }
    }
}
