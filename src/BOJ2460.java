import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int people = 0;

        for (int i = 0; i < 10; i++) {
            String[] station = br.readLine().split(" ");
            people -= Integer.parseInt(station[0]);
            people += Integer.parseInt(station[1]);

            max = Math.max(max, people);
        }

        System.out.println(max);
    }
}
