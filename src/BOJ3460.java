import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            find1Positions(n);
        }
    }

    private static void find1Positions(int n) {
        StringBuilder sb = new StringBuilder();
        char[] binary = Integer.toBinaryString(n).toCharArray();
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == '1') {
                sb.append((binary.length) - i - 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}
