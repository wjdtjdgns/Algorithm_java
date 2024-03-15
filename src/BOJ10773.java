import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(br.readLine());
                if (cur == 0) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
