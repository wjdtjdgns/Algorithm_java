import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10807 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int size = Integer.parseInt(br.readLine());
            final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int target = Integer.parseInt(br.readLine());

            System.out.println(Arrays.stream(array).filter(v -> v == target).toArray().length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}