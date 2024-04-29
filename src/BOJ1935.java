import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        Stack<Double> stack = new Stack<>();
        HashMap<Character, Double> hm = new HashMap<>();

        for (char start = 'A'; start != 'A' + N; start++) {
            hm.put(start, Double.parseDouble(br.readLine()));
        }

        for (int i = 0; i < input.length; i++) {
            if ('A' <= input[i] && input[i] <= 'Z') {
                stack.push(hm.get(input[i]));
                continue;
            }
            double right = stack.pop();
            double left = stack.pop();
            if (input[i] == '+') {
                stack.push(left + right);
            } else if (input[i] == '-') {
                stack.push(left - right);
            } else if (input[i] == '*') {
                stack.push(left * right);
            } else {
                stack.push(left / right);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
