import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n  + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(maxScore(n, stairs));
    }

    public static int maxScore(int n, int[] stairs) {
        if (n == 1) {
            return stairs[1];
        }
        if (n == 2) {
            return stairs[1] + stairs[2];
        }

        int[] dp = new int[n + 1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        return dp[n];
    }
}
