import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        int count = 1;

        while (B > A) {
            String strB = String.valueOf(B);
            if (strB.charAt(strB.length() - 1) == '1') {
                B /= 10;
                count++;
            } else if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        if (A == B) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
