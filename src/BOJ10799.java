import java.io.*;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(countIronRodPieces(input));
    }

    public static int countIronRodPieces(String input) {
        Stack<Character> stack = new Stack<>();
        int pieces = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    pieces += stack.size();
                } else {
                    pieces += 1;
                }
            }
        }

        return pieces;
    }
}
