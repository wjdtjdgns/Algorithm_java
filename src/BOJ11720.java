import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += numbers[i];
        }

        System.out.println(result);
    }
}
