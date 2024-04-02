import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long res = 0;

        for (int i = 0; i < NM[0] - 2; i++) {
            for (int j = i + 1; j < NM[0] - 1; j++) {
                for (int k = j + 1; k < NM[0]; k++) {
                    long sum = cards[i] + cards[j] + cards[k];
                    if (sum == NM[1]) {
                        System.out.println(sum);
                        return;
                    }
                    if (sum > NM[1]) continue;
                    if (Math.abs(NM[1] - res) > Math.abs(NM[1] - sum)) {
                        res = sum;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
