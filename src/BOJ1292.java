import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int A = Integer.parseInt(input[0]);
        final int B = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; list.size() < B; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
