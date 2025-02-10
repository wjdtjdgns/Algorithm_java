import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        String num = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < cur && K > 0) {
                stack.pop();
                K--;
            }
            stack.push(cur);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}
