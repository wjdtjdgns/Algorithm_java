import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        double[] scores = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double maxScore = Arrays.stream(scores).max().getAsDouble();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (scores[i] / maxScore) * 100;
        }
        System.out.println(sum / N);
    }
}