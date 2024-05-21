import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        for (int num : arr) {
            System.out.print(num);
        }
    }
}
