import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] testCase = br.readLine().split(" ");
            sb.append("Case #").append(String.valueOf(i + 1)).append(": ").append(String.valueOf(Integer.parseInt(testCase[0]) + Integer.parseInt(testCase[1]))).append("\n");
        }
        System.out.println(sb.toString());
    }
}
