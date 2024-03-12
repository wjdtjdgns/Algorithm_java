import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3273 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int size = Integer.parseInt(br.readLine());
            final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int X = Integer.parseInt(br.readLine());
            int count = 0;
            Arrays.sort(array);

            int start = 0, end = size - 1;

            while (start < end) {
                if (array[start] + array[end] == X) {
                    count++;
                    start++;
                    end--;
                } else if (array[start] + array[end] < X) {
                    start++;
                } else {
                    end--;
                }
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
