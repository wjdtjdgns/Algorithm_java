import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int count = 1;
        int i = 666;
        while (count != N) {
            i++;
            if (String.valueOf(i).contains("666")) count++;
        }
        System.out.println(i);
    }
}
