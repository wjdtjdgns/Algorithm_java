import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
                if (i != N / i) {
                    divisors.add(N / i);
                }
            }
        }

        Collections.sort(divisors);

        System.out.println((divisors.size() < K) ? 0 : divisors.get(K - 1));
    }
}
