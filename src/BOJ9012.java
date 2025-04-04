import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String str = br.readLine();
      Stack<Character> stack = new Stack<>();
      boolean flag = true;

      for (char ch : str.toCharArray()) {
        if (ch == '(') {
          stack.push(ch);
        } else if (ch == ')') {
          if (stack.isEmpty()) {
            flag = false;
            break;
          } else {
            stack.pop();
          }
        }
      }

      if (!stack.isEmpty()) {
        flag = false;
      }

      sb.append(flag ? "YES" : "NO").append("\n");
    }

    System.out.print(sb);
  }
}
