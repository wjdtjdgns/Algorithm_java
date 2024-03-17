import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < N; i++) {
                Stack<Character> stack = new Stack<>();
                char[] word = br.readLine().toCharArray();
                for (int j = 0; j < word.length; j++) {
                    if (!stack.isEmpty() && stack.peek() == word[j]) {
                        stack.pop();
                    } else {
                        stack.push(word[j]);
                    }
                }
                if (stack.isEmpty()) count++;
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
