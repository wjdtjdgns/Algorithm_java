import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        int cur = 1;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                cur++;
            }
            if (cur == line[i]) {
                cur++;
            } else {
                stack.push(line[i]);
            }
        }

        while (!stack.isEmpty()) {
            if (cur != stack.pop()) {
                System.out.println("Sad");
                return;
            }
            cur++;
        }

        System.out.println("Nice");
    }
}
