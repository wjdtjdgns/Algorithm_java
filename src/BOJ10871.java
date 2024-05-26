import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]), X = Integer.parseInt(temp[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = Arrays.stream(A).filter(v -> v < X).toArray();

        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
