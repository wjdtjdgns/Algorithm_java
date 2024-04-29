import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15649 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] array;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        array = new int[NM[1]];
        visit = new boolean[NM[0]];

        dfs(NM[0], NM[1], 0);

        System.out.println(sb.toString());
    }

    public static void dfs(int N, int M, int depth) {
        if (M == depth) {
            for (int val : array) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
