import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        Integer[][] dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = array;
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0, N, arr, dp));
    }

    public static int find(int depth, int idx, int N, int[][] arr, Integer[][] dp) {
        if (depth == (N - 1)) return dp[depth][idx];

        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx, N, arr, dp), find(depth + 1, idx + 1, N, arr, dp)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }
}
