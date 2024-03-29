import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            switch (commands[0]) {
                case 1: {
                    deque.addFirst(commands[1]);
                    break;
                }
                case 2: {
                    deque.addLast(commands[1]);
                    break;
                }
                case 3: {
                    sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
                    break;
                }
                case 4: {
                    sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
                    break;
                }
                case 5: {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case 6: {
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case 7: {
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                }
                case 8: {
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
