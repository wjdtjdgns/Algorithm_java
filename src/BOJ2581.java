import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = sieveOfEratosthenes(N);

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        System.out.println((sum == 0) ? -1 : (sum + "\n" + min));
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
