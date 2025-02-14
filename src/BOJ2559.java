import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] tempertures = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += tempertures[i];
        }
        int max = sum;

        for (int i = K; i < N; i++) {
            sum -= tempertures[i - K];
            sum += tempertures[i];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
