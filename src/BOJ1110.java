import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int original = N;
        int count = 0;

        do {
            N = operation(N);
            count++;
        } while (N != original);

        System.out.println(count);
    }

    public static int operation(int n) {
        int tens = n / 10;
        int ones = n % 10;
        int sum = tens + ones;
        return (ones * 10) + (sum % 10);
    }
}
