import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N - 1 ; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i <= j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
