import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1806 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int S = Integer.parseInt(input[1]);

    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int left = 0;
    int right = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;

    while (right <= N) {
      if (sum >= S) {
        min = Math.min(min, right - left);
        sum -= arr[left++];
      } else {
        if (right == N) break;

        sum += arr[right++];
      }
    }


    System.out.println(min == Integer.MAX_VALUE ? 0 : min);
  }

}
