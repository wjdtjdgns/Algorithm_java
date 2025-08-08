import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        final int[] zeroCount = new int[41];
        final int[] oneCount = new int[41];
        zeroCount[0] = 1;
        oneCount[0] = 0;

        zeroCount[1] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(zeroCount[n] + " " + oneCount[n]);
        }
    }
}
