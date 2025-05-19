import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fibo = new int[21];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 20; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        System.out.println(fibo[n]);
    }
}
