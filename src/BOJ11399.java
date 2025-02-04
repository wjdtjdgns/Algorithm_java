import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] pi = br.readLine().split(" ");
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(pi[i]);
        }

        Arrays.sort(P);

        int total = 0;
        int acc = 0;

        for (int time : P) {
            acc += time;
            total += acc;
        }

        System.out.println(total);
    }
}
