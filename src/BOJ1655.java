import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            max.add(Integer.parseInt(br.readLine()));

            if (!max.isEmpty() && !min.isEmpty() && (max.peek() > min.peek())) {
                min.add(max.remove());
            }

            if (max.size() > min.size() + 1) {
                min.add(max.remove());
            } else if (min.size() > max.size()) {
                max.add(min.remove());
            }

            sb.append(max.peek()).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
