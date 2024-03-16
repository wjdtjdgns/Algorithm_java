import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ2493 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            final int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int[] result = new int[N];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                while (!stack.isEmpty() && tops[stack.peek()] < tops[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    result[i] = stack.peek() + 1;
                }
                stack.push(i);
            }
            StringBuilder sb = new StringBuilder();
            for (int n : result) {
                sb.append(n).append(" ");
            }
            System.out.println(sb.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
