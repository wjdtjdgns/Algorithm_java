import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        long A = Long.parseLong(line[0]);
        long B = Long.parseLong(line[1]);
        long C = Long.parseLong(line[2]);

        System.out.println(modPow(A, B, C));
    }

    public static long modPow(long a, long b, long c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        long half = modPow(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }
}
