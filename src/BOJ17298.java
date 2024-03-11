import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int size = Integer.parseInt(br.readLine());
            final int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Stack<Integer> stack = new Stack<>();
            final int[] result = new int[size];
            Arrays.fill(result, -1);

            for (int i = 0; i < size; i++) {
                while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                    result[stack.pop()] = array[i];
                }
                stack.push(i);
            }

            StringBuilder sb = new StringBuilder();
            for (int v : result) {
                sb.append(v).append(" ");
            }
            System.out.println(sb.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
