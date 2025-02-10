import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17103 {
    static final int MAX = 1000000;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seive();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(countGoldbachPartitions(N)).append("\n");
        }
        System.out.println(sb);
    }

    private static void seive() {
        isPrime = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int countGoldbachPartitions(int N) {
        int count = 0;

        for (int i = 2; i <= N / 2; i++) {
            if (isPrime[i] && isPrime[N - i]) {
                count++;
            }
        }

        return count;
    }
}
