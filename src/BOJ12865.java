import java.io.*;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = reader.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[] weights = new int[N];
        int[] values = new int[K];

        for (int i = 0; i < N; i++) {
            String[] item = reader.readLine().split(" ");
            weights[i] = Integer.parseInt(item[0]);
            values[i] = Integer.parseInt(item[1]);
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weights[i - 1] <=  j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}