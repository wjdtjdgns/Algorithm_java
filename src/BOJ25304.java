import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            total -= list[0] * list[1];
        }
        System.out.println(total == 0 ? "Yes" : "No");
    }
}
