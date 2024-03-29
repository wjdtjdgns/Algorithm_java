import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int[] paper = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < N; i++) {
            deque.addLast(new int[]{i + 1, paper[i]});
        }
        int n = paper[0];
        sb.append(1).append(" ");

        while (!deque.isEmpty()) {
            if (n > 0) {
                for (int j = 0; j < n - 1; j++) {
                    deque.addLast(deque.pollFirst());
                }
                int[] next = deque.pollFirst();
                n = next[1];
                sb.append(next[0]).append(" ");
            } else {
                for (int j = 0; j < -(n + 1); j++) {
                    deque.addFirst(deque.pollLast());
                }
                int[] next = deque.pollLast();
                n = next[1];
                sb.append(next[0]).append(" ");
            }

        }

        System.out.println(sb.toString().trim());
    }
}
