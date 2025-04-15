import java.io.*;
import java.util.*;

public class BOJ12852 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N + 1];
    int[] prev = new int[N + 1];

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[1] = 0;

    for (int i = 2; i <= N; i++) {
      if (dp[i - 1] + 1 < dp[i]) {
        dp[i] = dp[i - 1] + 1;
        prev[i] = i - 1;
      }

      if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
        dp[i] = dp[i / 2] + 1;
        prev[i] = i / 2;
      }

      if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
        dp[i] = dp[i / 3] + 1;
        prev[i] = i / 3;
      }
    }

    System.out.println(dp[N]);

    List<Integer> path = new ArrayList<>();
    for (int i = N; i != 0; i = prev[i]) {
      path.add(i);
    }

    for (int i = 0; i < path.size(); i++) {
      System.out.print(path.get(i) + " ");
    }
  }
}
