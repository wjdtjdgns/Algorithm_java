import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2230 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int left = 0, right = 0;
    int min = Integer.MAX_VALUE;

    while (right < N) {
      int value = arr[right] - arr[left];

      if (value < M) {
        right++;
      } else {
        min = Math.min(min, value);
        left++;
      }

      if (left > right) right = left;
    }

    System.out.println(min);
  }
}
