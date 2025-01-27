import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15650 {
    static int N, M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        selected = new int[M];

        backtrack(1, 0);
    }

    static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            backtrack(i + 1, depth + 1);
        }
    }
}
