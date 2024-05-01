import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }

        sb.append(queue.poll());

        System.out.println(sb.toString());
    }
}
