import java.io.*;
public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            dp[i][0] = Integer.parseInt(tmp[0]);
            dp[i][1] = Integer.parseInt(tmp[1]);
            dp[i][2] = Integer.parseInt(tmp[2]);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + dp[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + dp[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][2];
        }
        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}
