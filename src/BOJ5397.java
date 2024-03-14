import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ5397 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                char[] testcase = br.readLine().toCharArray();
                Stack<Character> left = new Stack<>();
                Stack<Character> right = new Stack<>();
                for (char s : testcase) {
                    if (s == '<') {
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                    } else if (s == '>') {
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                    } else if (s == '-') {
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                    } else {
                        left.push(s);
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}