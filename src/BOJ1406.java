import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final char[] init = br.readLine().toCharArray();
            final int M = Integer.parseInt(br.readLine());
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : init) {
                left.push(c);
            }
            for (int i = 0; i < M; i++) {
                char[] commands = br.readLine().toCharArray();
                if (commands[0] == 'L') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (commands[0] == 'D') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (commands[0] == 'B') {
                    if (!left.isEmpty()) left.pop();
                } else if (commands[0] == 'P') {
                    left.push(commands[2]);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
