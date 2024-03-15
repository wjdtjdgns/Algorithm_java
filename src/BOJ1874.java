import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int nextNum = 1;
            for (int i = 0; i < N; i++) {
                int target = Integer.parseInt(br.readLine());
                while (nextNum <= target) {
                    stack.push(nextNum++);
                    sb.append("+\n");
                }
                if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
