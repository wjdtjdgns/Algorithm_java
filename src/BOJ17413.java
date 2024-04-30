import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                popAllElements(stack, sb);
                while (input.charAt(i) != '>') {
                    sb.append(input.charAt(i));
                    i++;
                }
                sb.append(input.charAt(i));
            } else if (input.charAt(i) == ' ') {
                popAllElements(stack, sb);
                sb.append(" ");
            } else {
                stack.push(input.charAt(i));
            }
        }

        popAllElements(stack, sb);
        sb.append(" ");
        System.out.println(sb.toString().trim());
    }

    private static void popAllElements(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
