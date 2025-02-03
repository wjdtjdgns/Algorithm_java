import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int layer = 1;
        int maxNum = 1;

        while (maxNum < N) {
            maxNum += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}
