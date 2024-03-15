import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                final String[] commands = br.readLine().split(" ");
                if (commands[0].equals("push")) {
                    stack.push(Integer.parseInt(commands[1]));
                } else if (commands[0].equals("pop")) {
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                } else if (commands[0].equals("size")) {
                    System.out.println(stack.size());
                } else if (commands[0].equals("empty")) {
                    System.out.println(stack.isEmpty() ? 1 : 0);
                } else if (commands[0].equals("top")) {
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
